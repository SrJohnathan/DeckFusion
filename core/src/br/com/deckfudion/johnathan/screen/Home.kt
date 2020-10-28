package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.Preferencies
import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.louder.LouderMusic
import br.com.deckfudion.johnathan.louder.LouderSound
import br.com.deckfudion.johnathan.utill.AlertDialog
import br.com.deckfudion.johnathan.utill.TextLouder
import br.com.deckfudion.johnathan.utill.Value
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.I18NBundle
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import java.util.*
import kotlin.collections.HashMap

class Home(var game: Main) : Screen {


    var camera: OrthographicCamera? = null
    var viewport: Viewport? = null
    var stage: Stage? = null

    var language: I18NBundle? = null
    val music = LouderMusic()
    var labelclick: Label? = null

    var alert = AlertDialog()


    init {

        language = LouderFull.asset.get("data/language/language", I18NBundle::class.java)
        music.duration = 1


        camera = OrthographicCamera()
        viewport = FitViewport(1280f, 720f, camera)
        stage = Stage(viewport, game.batch)


        val table = Table()
        val image = Table()

        table.setFillParent(true)
        image.setFillParent(true)


        val texture = LouderFull.asset.get("data/wp/logo.jpg", Texture::class.java)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

        image.background = TextureRegionDrawable(texture)




        table.bottom()

        stage?.addActor(image)
        stage?.addActor(table)


        labelclick = Label(language?.get("clickWindow"), TextLouder.styleBebasBorder(Color.WHITE, 35))


        labelclick?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.fadeIn(1f),
                Actions.delay(1f),
                Actions.fadeOut(1f))))


        table.add(labelclick).bottom().padBottom(100f)


        stage?.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                LouderSound.click?.play()
                table.removeActor(labelclick)

                if (!alert.isShow()) {
                    alert.showDialogInput(object : Value {
                        override fun content(st: String) {

                            val hashMap = HashMap<String, String>()
                            hashMap.put("user", st)
                            Preferencies.config(hashMap, false)

                            texture.dispose()
                            LouderFull.asset.unload("data/wp/logo.jpg")


                            music.stop(Runnable {

                                music.dispose()
                                game.setCustonScreen(Main.Stages.MENU)
                                dispose()
                            })





                        }
                    })
                }


            }
        })

    }


    override fun hide() {
    }

    override fun show() {

        music.load(LouderMusic.Musics.INTRO_HOME)


    }

    override fun render(delta: Float) {

        music.update(delta)

        if(!alert.isShow()){
            Gdx.input.inputProcessor = stage
        }


        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        game.batch.projectionMatrix = camera?.combined
        game.batch.projectionMatrix = stage?.camera?.combined


        stage?.draw()
        stage?.act(delta)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {

        viewport?.update(width, height)
    }

    override fun dispose() {

    }
}