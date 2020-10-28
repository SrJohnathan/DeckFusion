package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.I18NBundle
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

abstract class Screen2D(var gm: Main) : Screen {

    var camera: OrthographicCamera? = null
    var viewport: Viewport? = null
    var stage: Stage? = null
    var language: I18NBundle? = null


    abstract fun render2D(delta: Float)
    abstract fun resize2D (width: Int, height: Int)

    init {

        language = LouderFull.asset.get("data/language/language", I18NBundle::class.java)
        camera = OrthographicCamera()
        viewport = FitViewport(1280f, 720f, camera)
        stage = Stage(viewport, gm.batch)

    }


    override fun render(delta: Float) {


        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gm.batch.projectionMatrix = camera?.combined
        gm.batch.projectionMatrix = stage?.camera?.combined

        render2D(delta)

        stage?.draw()
        stage?.act(delta)

    }

    override fun resize(width: Int, height: Int) {
        viewport?.update(width, height)
        resize2D(width, height)
    }

    override fun dispose() {
        stage?.dispose()

    }
}