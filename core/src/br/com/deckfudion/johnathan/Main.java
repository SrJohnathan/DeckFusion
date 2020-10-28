package br.com.deckfudion.johnathan;

import com.aj.johnathan.yugi.screen.Loading;
import com.aj.johnathan.yugi.screen.LoadingScreem;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Interpolation;

import java.util.Locale;

import br.com.deckfudion.johnathan.libs.transitions.FadingGame;
import br.com.deckfudion.johnathan.libs.transitions.ScreenTransition;
import br.com.deckfudion.johnathan.libs.transitions.impl.AlphaFadingTransition;
import br.com.deckfudion.johnathan.libs.transitions.impl.ColorFadeTransition;
import br.com.deckfudion.johnathan.screen.Arena;
import br.com.deckfudion.johnathan.screen.DeckEditor;
import br.com.deckfudion.johnathan.screen.History;
import br.com.deckfudion.johnathan.screen.Home;
import br.com.deckfudion.johnathan.screen.Language;
import br.com.deckfudion.johnathan.screen.Menu;
import br.com.deckfudion.johnathan.screen.VideoScreen;
import particles.EffekseerManager;

public class Main extends FadingGame {
    private SpriteBatch batch;
    public Screen screen;
    private Runnable runArena;


    public Main() {
        super();
    }


    @Override
    public void create() {
        super.create();

        batch = new SpriteBatch();

        setTransition(new ColorFadeTransition(Color.BLACK, Interpolation.exp10), 1f);

        if (Boolean.parseBoolean( Preferencies.Companion.getConfig(false).get("eua"))) {

            Locale.setDefault(Locale.ENGLISH);
        } else {
            Locale.setDefault( new Locale("pt","BR"));
        }
        EffekseerManager.InitializeEffekseer();

        setScreen(new Language(this));

    }

    @Override
    public void resume() {
        super.resume();
    }


    public void setRunArena(Runnable runArena) {
        this.runArena = runArena;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

        batch.dispose();
        super.dispose();
    }

    /**
     *
     * @param {Stages} id
     */
    public void setCustonScreen(Stages id) {

        switch (id) {

            case LANGUAGE:
                screen = new Language(this);
                setScreen(screen);

                break;

            case HOME:
                screen = new Home(this);
                setScreen(screen);

                break;


            case LOADING:
                screen = new LoadingScreem(this);
                setScreen(screen);

                break;

            case MENU:
                screen = new Menu(this);
                setScreen(screen);

                break;


            case ARENA:

               screen = new Loading(this);
                setScreen(screen);

                break;


            case HISTORY:
                screen = new History(this);


                setScreen(screen);

                break;

            case VIDEO:
                screen = new VideoScreen(this);
                setScreen(screen);

                break;
        }

        if (runArena != null) {
            runArena.run();
        }
    }



  public   enum  Stages{

        HISTORY,
        ARENA,
        VIDEO,
        LOADING,
        LANGUAGE,
        HOME,
        MENU,

    }
}
