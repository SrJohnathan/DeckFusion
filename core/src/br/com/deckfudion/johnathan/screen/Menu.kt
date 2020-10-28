package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.Preferencies
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.StyleClass
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

class Menu(var game: Main) : Screen2D(game) {


    var history:TextButton? = null
    var freeduel:TextButton? = null
    var remote:TextButton? = null
    var deck:TextButton? = null

    var controles :InputMultiplexer? = null

    init {


        val root = Table()
        val table = Table()
        val panel = Table()
        val image = Table()

        root.setFillParent(true)
        image.setFillParent(true)


        val texture = LouderFull.asset.get("data/wp/fundorootmai.jpg", Texture::class.java)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

        image.background = TextureRegionDrawable(texture)







        table.left()
        panel.right()

        val sty = StyleClass.button()

        history = TextButton(language?.get("history"),sty)
        freeduel = TextButton(language?.get("freeduel"),sty)
        remote = TextButton(language?.get("duelserver"),sty)
        deck = TextButton(language?.get("mydeck"),sty)


        table.add(history).padBottom(20f)
        table.row()
        table.add(freeduel).padBottom(20f).padLeft(50f)
        table.row()
        table.add(remote).padBottom(20f).padLeft(100f)
        table.row()
        table.add(deck).padLeft(150f)



        val texturePanel = LouderFull.asset.get("data/skin/panel.png", Texture::class.java)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        panel.background = TextureRegionDrawable(texturePanel)

        panel.padRight(100f)

        root.add(table).expandX()
        root.add(panel).expandX()

        stage?.addActor(image)
        stage?.addActor(root)



    }


    override fun show() {

        controles =  InputMultiplexer(stage)

        history?.addListener (object : ClickListener(){
            override fun clicked(event: InputEvent?, x: Float, y: Float) {


                val map = Preferencies.getConfig(false)

                if(map.containsKey("video1")){
                    game?.setCustonScreen(Main.Stages.HISTORY)

                }else{

                    val map = hashMapOf<String,String>()
                    map.put("video1",true.toString())
                    Preferencies.config(map,false)
                    game.setCustonScreen(Main.Stages.VIDEO)
                }




            }
        } )


    }


    override fun render2D(delta: Float) {

        if(stage != null){
            Gdx.input.inputProcessor =  controles
        }


    }

    override fun resize2D(width: Int, height: Int) {

    }

    override fun pause() {
    }

    override fun resume() {

    }

    override fun hide() {

    }


}