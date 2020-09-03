package br.com.deckfudion.johnathan;

import com.aj.johnathan.yugi.screen.LoadingScreem;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch;

import br.com.deckfudion.johnathan.screen.Arena;
import br.com.deckfudion.johnathan.screen.DeckEditor;
import br.com.deckfudion.johnathan.screen.History;
import br.com.deckfudion.johnathan.screen.Home;
import br.com.deckfudion.johnathan.screen.VideoScreen;
import particles.EffekseerManager;

public class Main extends Game {
    private SpriteBatch batch;


    //SCREEN
    public Arena arena;

    public Screen screen;

    private LoadingScreem loadingScreem;


    private Runnable runArena;


    public Main() {



    }



    @Override
    public void create() {


        EffekseerManager.InitializeEffekseer();


        batch = new SpriteBatch();

        loadingScreem = new LoadingScreem(this, 1);
        setScreen(loadingScreem);


        //INSTANCIE


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

        if (arena != null) {
            arena.dispose();
        }


    }


    public void setCustonScreen(int id) {


        switch (id) {

            case 1:


                screen = new Home(this);


                setScreen(screen);

                if (runArena != null) {
                    runArena.run();
                }

                break;
        }


    }


}
