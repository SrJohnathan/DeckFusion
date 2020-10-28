package com.aj.johnathan.yugi.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.Preferencies
import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.louder.LouderSound
import br.com.deckfudion.johnathan.screen.Arena
import br.com.deckfudion.johnathan.utill.StyleClass
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport


class Loading(var game: Main) : Screen {


    var camera: OrthographicCamera? = null
    var viewport: Viewport? = null
    var stage: Stage? = null
    var isScreen = false

    var louderArena: LouderArena? = null


    var progressBar: ProgressBar? = null




    init {
        camera = OrthographicCamera()
        viewport = FitViewport(1280f, 720f, camera)
        stage = Stage(viewport, game.batch)

        louderArena = LouderArena()


    }


    override fun hide() {


    }

    override fun show() {

        louderArena?.init()


        renderProgressBar()
    }

    override fun render(delta: Float) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        game.batch.projectionMatrix = camera?.combined
        game.batch.projectionMatrix = stage?.camera?.combined


        if (!isScreen) {
            if (louderArena?.assetI?.isFinished!!) {

                if (louderArena?.asset?.isFinished!!) {
                    isScreen = true

                    progressBar?.value = 1.0f
                    camera?.update()
                    stage?.addAction(Actions.sequence(Actions.delay(1f), Actions.run(Runnable {

                        game.setScreen(Arena(game, louderArena!!))
                    })))

                } else {
                    louderArena?.asset?.update()
                    progressBar?.value = ((louderArena?.asset?.progress!! / 2) + 1.0f)
                }
            } else {
                louderArena?.assetI?.update()
                progressBar?.value = louderArena?.assetI?.progress!! / 2

            }
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
    }

    override fun dispose() {

        stage?.dispose()


    }


    private fun renderProgressBar() {

        val v = TiledDrawable(TextureRegionDrawable(Texture(Gdx.files.internal("data/skin/loading.png"))))
        val t = TiledDrawable(TextureRegionDrawable(Texture(Gdx.files.internal("data/skin/loadingfull.png"))))

        val pro = ProgressBar.ProgressBarStyle()
        // pro.knob = v
        pro.background = v
        pro.knobBefore = t


        progressBar = ProgressBar(0f, 1.0f, 1f, false, pro)
        progressBar?.value = 0f
        progressBar?.setAnimateDuration(0.25f)

        val table = Table()
        table.setFillParent(true)
        table.center()


        val imglogo = Texture(Gdx.files.internal("data/skin/logo.png"))
        imglogo.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

        val image = Image(imglogo)

        table.add(image)
        table.row()
        table.add(progressBar).fillX().width(648f)

        stage?.addActor(table)
    }


}