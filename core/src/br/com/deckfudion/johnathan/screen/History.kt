package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.camps.Agua
import br.com.deckfudion.johnathan.camps.Caveira
import br.com.deckfudion.johnathan.camps.Egito
import br.com.deckfudion.johnathan.camps.Terra
import br.com.deckfudion.johnathan.louder.HistoryLouder
import br.com.deckfudion.johnathan.louder.LouderMusic
import br.com.deckfudion.johnathan.utill.CallLouder
import com.aj.johnathan.yugi.hud.MapHud
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport


class History(var game: Main) : Screen, InputProcessor {

    val asset = HistoryLouder()

    private var camera: OrthographicCamera? = null
    var viewport: Viewport? = null

    var cameraHud: OrthographicCamera? = null
    var viewportHud: Viewport? = null

    var agua: Agua? = null
    var egito: Egito? = null
    var mapHud: MapHud? = null
    var terra: Terra? = null
    var caveira:Caveira? = null

    var camp = 0

    val music = LouderMusic()

    init {

        asset.init()

        camera = OrthographicCamera(1280f, 720f)
        cameraHud = OrthographicCamera(1280f, 720f)

        camera?.position?.x = 0f
        camera?.position?.y = 0f
        viewport = FitViewport(1280f, 720f, camera)
        viewportHud = FitViewport(1280f, 720f, cameraHud)

        mapHud = MapHud(game.batch, viewportHud!!)


        asset.callLouder = object : CallLouder {
            override fun call() {

                egito = Egito(this@History)
                agua = Agua(asset, game.batch, viewport!!)
                terra = Terra(this@History)
                caveira= Caveira(this@History)


                terra?.addAction(Actions.fadeOut(0f))
                agua?.addAction(Actions.fadeOut(0f))
                caveira?.addAction(Actions.fadeOut(0f))




                egito?.terraCall = Runnable {

                    terra?.addAction(Actions.fadeIn(2f))
                    egito?.addAction(Actions.fadeOut(2f))
                    music.load(LouderMusic.Musics.DESERTO)
                    camp = 2
                }

                terra?.terraCall = Runnable {

                    caveira?.addAction(Actions.fadeIn(2f))
                    terra?.addAction(Actions.fadeOut(2f))
                    music.load(LouderMusic.Musics.CAVEIRA)
                }

            }
        }


    }


    override fun hide() {

    }

    override fun show() {

        music.reapet = true
        music.load(LouderMusic.Musics.EGITO)


    }

    override fun render(delta: Float) {

        asset.update()
        music.update(delta)

        Gdx.input.inputProcessor = InputMultiplexer(mapHud, this)


        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glEnable(GL20.GL_TEXTURE_2D);
        Gdx.gl.glDepthMask(true)



        game.batch.projectionMatrix = mapHud?.camera?.combined


        when (camp) {

            0 -> {
                Gdx.input.inputProcessor = InputMultiplexer(mapHud, egito, this)


            }

            1 -> {
                Gdx.input.inputProcessor = InputMultiplexer(mapHud, agua, this)


            }

            2 -> {
                Gdx.input.inputProcessor = InputMultiplexer(mapHud, terra, this)


            }
        }


        agua?.draw()
        agua?.act(delta)


        terra?.draw()
        terra?.act(delta)


        egito?.draw()
        egito?.act(delta)

        caveira?.draw()
        caveira?.act(delta)

        mapHud?.draw()
        mapHud?.act(delta)

    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
        viewport?.update(width, height)
        camera?.update()

        viewportHud?.update(width, height)
        cameraHud?.update()
    }

    override fun dispose() {
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {


        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {

        val x = Gdx.input.deltaX.toFloat()
        val y = Gdx.input.deltaY.toFloat()

        var nx = 0f
        var ny = 0f




        if (camera?.position?.x!! >= 860) {
            camera?.position?.x = 860f
        } else {
            nx = x
        }

        if (camera?.position?.x!! < 640) {
            camera?.position?.x = 640f
        } else {
            nx = x
        }


        if (camera?.position?.y!! >= 1120) {
            camera?.position?.y = 1120f
        } else {
            ny = y
        }

        if (camera?.position?.y!! < 360) {
            camera?.position?.y = 360f
        } else {
            ny = y
        }

        camera!!.translate(-nx, ny)
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }


}