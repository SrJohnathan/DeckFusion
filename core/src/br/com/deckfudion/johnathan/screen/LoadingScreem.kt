package com.aj.johnathan.yugi.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.Preferencies
import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.louder.LouderSound
import br.com.deckfudion.johnathan.utill.AlertDialog
import br.com.deckfudion.johnathan.utill.AnimatedSprite
import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import io.reactivex.rxjava3.internal.jdk8.FlowableFirstStageSubscriber
import java.io.FileNotFoundException


class LoadingScreem(var game: Main) : Screen {


    companion object{

        val EXTERNAL_LOUDER = 1
        val ARENA_LOUDER = 2
    }


    private val PROGRESS_BAR_WIDTH = 762f / 2f
    private val PROGRESS_BAR_HEIGHT = 50f
    var camera: OrthographicCamera? = null
    var viewport: Viewport? = null
    var stage: Stage? = null
    var isScreen = true


    var verificExternal = false;

    var   alert =  AlertDialog()





    init {
        camera = OrthographicCamera()
        viewport = FitViewport(1280f, 720f, camera)
        stage = Stage(viewport, game.batch)

    }


    override fun hide() {
        // video?.stop()

    }

    override fun show() {

        LouderSound.init()


        verificExternal = Gdx.files.external("/gameData").exists()
        renderProgressBar()


        LouderFull.initLouder()

                if(verificExternal){
                    LouderExternal.initLouder()
                }else{

                    alert.showDialog { v: Boolean ->
                            Gdx.app.exit()
                    }
                }



    }

    override fun render(delta: Float) {

        LouderSound.asset.update()


        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        game.batch.projectionMatrix = camera?.combined
        game.batch.projectionMatrix = stage?.camera?.combined


        LouderExternal.asset.update()
        LouderFull.asset.update()
        //   LouderArena.getTextures(null)
        if (LouderFull.asset.isFinished && LouderExternal.asset.isFinished  && isScreen) {
            isScreen = false

            //


            //  video?.pause()
            go()

        }





        stage?.act(delta)
        stage?.draw()


    }

    override fun pause() {
        //  video?.pause()
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
        viewport?.update(width, height)
        stage?.viewport?.update(width, height)
        // video?.resize(width,height)
    }

    override fun dispose() {

        //video?.dispose()
        stage?.dispose()


    }


    private fun renderProgressBar() {

        val tt = TextureAtlas("data/sprites/loading/loading.atlas")

        val anima = Animation<TextureRegion>(1 / 12f, tt.regions)
        anima.playMode = Animation.PlayMode.LOOP_PINGPONG
        val seta = AnimatedSprite(anima)

        stage?.addActor(AnimatedSprite.SpriteAniActor(seta).spritePos(550f, 300f))


    }


    private fun go() {

        LouderSound.get()
        LouderFull.get()
        LouderExternal.get()


        val map = Preferencies.getConfig(false)

        if(map.containsKey("user")){


            game.setCustonScreen(Main.Stages.MENU)
        }else{
            game.setCustonScreen(Main.Stages.HOME)
        }





    }

}