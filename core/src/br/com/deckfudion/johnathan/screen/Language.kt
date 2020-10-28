package br.com.deckfudion.johnathan.screen


import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.Preferencies
import br.com.deckfudion.johnathan.louder.LouderSound
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import java.util.*
import kotlin.collections.HashMap


class Language(var game: Main) : Screen {


    var camera: OrthographicCamera? = null
    var viewport: Viewport? = null
    var stage: Stage? = null
    var dialog: Dialog? = null
    var chargeLanguage:Boolean = false


    init {


        camera = OrthographicCamera()
        viewport = FitViewport(1280f, 720f, camera)
        stage = Stage(viewport, game.batch)


         val sty =  Label.LabelStyle()
        sty.fontColor = Color.WHITE
        sty.font = font()


        val labelclick = Label("Language", sty)
        labelclick.setAlignment(Align.center)


        val brasil = Texture(Gdx.files.internal("data/imagens/brasil_icon.png"))
        brasil.setFilter(TextureFilter.Linear, TextureFilter.Linear)

        val usa = Texture(Gdx.files.internal("data/imagens/usa_icon.png"))
        usa.setFilter(TextureFilter.Linear, TextureFilter.Linear)


        val click:Sound =  Gdx.audio.newSound(Gdx.files.internal("data/som/click.wav"))

        val imebrasil = Image(brasil)
        val eua = Image(usa)


        val w = Window.WindowStyle()

        w.titleFont = font()
        w.titleFontColor = Color.WHITE


        val dialg = Texture(Gdx.files.internal("data/imagens/dialog.png"))
        dialg.setFilter(TextureFilter.Linear, TextureFilter.Linear)

        w.background = TextureRegionDrawable(dialg)


        dialog = Dialog("", w)






        dialog?.contentTable?.row()
        dialog?.contentTable?.add(labelclick)?.expandX()?.fillX()
        dialog?.contentTable?.row()


        val temp = Table()


        temp.add(imebrasil)?.expandX()
        temp.add(eua)?.expandX()


        dialog?.contentTable?.add(temp)?.expandX()?.fillX()



        imebrasil.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                click.play()
                val map = HashMap<String, String>()
                map.put("eua", "false")
                Preferencies.config(map, false)
                Locale.setDefault(Locale("pt", "BR"))
                game.setCustonScreen(Main.Stages.LOADING)
                dispose()

            }
        })


        eua.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                click.play()
                val map = HashMap<String, String>()
                map.put("eua", "true")
                Preferencies.config(map, false)
                Locale.setDefault(Locale.ENGLISH)
                game.setCustonScreen(Main.Stages.LOADING)
                dispose()
            }
        })
    }


    override fun hide() {
    }

    override fun show() {

        stage?.addAction(Actions.sequence(Actions.delay(1f), Actions.run {
            dialog?.show(stage)
            dialog?.addAction(Actions.sequence(Actions.scaleTo(0.1f,0.1f),
                    Actions.scaleTo(1f,1f, 0.5f, Interpolation.swingOut)))    }))

    }

    override fun render(delta: Float) {

        Gdx.input.inputProcessor = stage

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        game.batch.projectionMatrix = camera?.combined
        game.batch.projectionMatrix = stage?.camera?.combined


        stage?.draw()
        stage?.act(delta)

        dialog?.act(delta)



    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {

        viewport?.update(width, height)
    }

    override fun dispose() {

        stage?.dispose()

    }


    fun font(): BitmapFont? {

      val  generator = FreeTypeFontGenerator(Gdx.files.local("data/font/bebas.ttf"))



        val parameter = FreeTypeFontParameter();
        parameter.magFilter = TextureFilter.Linear
        parameter.minFilter = TextureFilter.Linear
        parameter.color = Color.WHITE
        parameter.size = 35;
        parameter.shadowOffsetX = 0;
        parameter.shadowOffsetY = 0;
        parameter.borderWidth = 2f
        parameter.spaceX = 1
        parameter.borderColor = Color.BLACK

        return generator.generateFont(parameter)
    }
}