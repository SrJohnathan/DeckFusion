/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package br.com.deckfudion.johnathan.libs.transitions;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.utils.Array;
import java.util.ArrayList;

import br.com.deckfudion.johnathan.screen.VideoScreen;


public class FadingGame extends Game {

    protected Batch batch;
    private final Array<TransitionListener> listeners;
    protected FrameBuffer currentScreenFBO;
    protected FrameBuffer nextScreenFBO;
    protected Screen nextScreen;
    private float transitionDuration;
    private float currentTransitionTime;
    private boolean transitionRunning;
    private ScreenTransition screenTransition;
    protected ArrayList<ScreenTransition> transitions;


    public FadingGame() {
        this.listeners = new Array<TransitionListener>();
        transitions = new ArrayList<ScreenTransition>();
    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        this.currentScreenFBO = new FrameBuffer(Format.RGBA8888, 1280, 720, false);
        this.nextScreenFBO = new FrameBuffer(Format.RGBA8888, 1280, 720,  false);
    }

    @Override
    public void dispose() {
        if (screen != null) screen.hide();
        if (nextScreen != null) nextScreen.hide();

        this.currentScreenFBO.dispose();
        this.nextScreenFBO.dispose();

        batch.dispose();
    }

    @Override
    public void pause() {
        if (screen != null) screen.pause();
        if (nextScreen != null) nextScreen.pause();
    }

    @Override
    public void resume() {
        if (screen != null) screen.resume();
        if (nextScreen != null) nextScreen.resume();
    }


    public void superSetScrenn(Screen screen){

       super.setScreen(screen);

    }

    @Override
    public void render() {


        if(screen.getClass().getName().equals(VideoScreen.class.getName())){

            super.render();

        }else {
            float delta = Gdx.graphics.getDeltaTime();

            if (nextScreen == null) {
                // no other screen
                screen.render(delta);
            } else {
                if (transitionRunning && currentTransitionTime >= transitionDuration) {
                    // is active and time limit reached
                    this.screen.hide();
                    this.screen = this.nextScreen;
                    this.screen.resume();
                    transitionRunning = false;
                    this.nextScreen = null;
                    notifyFinished();
                    this.screen.render(delta);

                } else {
                    // transition is active
                    if (screenTransition != null) {
                        currentScreenFBO.begin();
                        this.screen.render(delta);
                        currentScreenFBO.end();

                        nextScreenFBO.begin();
                        this.nextScreen.render(delta);
                        nextScreenFBO.end();

                        float percent = currentTransitionTime / transitionDuration;

                        screenTransition.render(batch, currentScreenFBO.getColorBufferTexture(), nextScreenFBO.getColorBufferTexture(),
                                percent);
                        currentTransitionTime += delta;

                    }

                }

            }
        }
    }

    @Override
    public void resize(int width, int height) {
        if (screen != null) screen.resize(width, height);
        if (nextScreen != null) nextScreen.resize(width, height);

        this.currentScreenFBO.dispose();
        this.nextScreenFBO.dispose();

        this.currentScreenFBO = new FrameBuffer(Format.RGBA8888,1280, 720,  false);
        this.nextScreenFBO = new FrameBuffer(Format.RGBA8888, 1280, 720,  false);

    }

    /** Sets the {@link ScreenTransition} which is used. May be {@code null} to use instant switching.
     * @param screenTransition may be {@code null}
     * @param duration the transition duration in seconds
     * @return {@code true} if successful false if transition is running */
    public boolean setTransition(ScreenTransition screenTransition, float duration) {
        if (transitionRunning) return false;
        this.screenTransition = screenTransition;
        this.transitionDuration = duration;
        return true;

    }

    /** @return the currently active {@link Screen}. */
    @Override
    public Screen getScreen() {
        return screen;
    }

    /** Sets the current screen. {@link Screen#hide()} is called on any old screen, and {@link Screen#show()} is called on the new
     * screen, if any.
     * @param screen may be {@code null} */
    @Override
    public void setScreen(Screen screen) {

        if(screen.getClass().getName().equals(VideoScreen.class.getName())){

            super.setScreen(screen);

        }else {
            screen.show();
            if (transitionRunning)
                Gdx.app.log(FadingGame.class.getSimpleName(), "Changed Screen while transition in progress");
            if (this.screen == null) {
                this.screen = screen;
            } else {
                if (screenTransition == null) {
                    this.screen.hide();
                    this.screen = screen;
                } else {
                    this.nextScreen = screen;
                    this.screen.pause();
                    this.nextScreen.pause();
                    currentTransitionTime = 0;
                    transitionRunning = true;
                    notifyStarted();
                }

            }

            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }


    }

    /** @return the next {@link Screen}. */
    public Screen getNextScreen() {
        return nextScreen;
    }

    /** @param listener to get transition events */
    public void addTransitionListener(TransitionListener listener) {
        listeners.add(listener);
        return;
    }

    /** @param listener to remove
     * @return {@code true} if successful */
    public boolean removeTransitionListener(TransitionListener listener) {
        return listeners.removeValue(listener, true);
    }

    /** Clear listeners */
    public void clearTransitionListeners() {
        listeners.clear();
    }

    private void notifyFinished() {
        for (TransitionListener transitionListener : listeners) {
            transitionListener.onTransitionFinished();
        }
    }

    private void notifyStarted() {
        for (TransitionListener transitionListener : listeners) {
            transitionListener.onTransitionStart();
        }
    }




}
