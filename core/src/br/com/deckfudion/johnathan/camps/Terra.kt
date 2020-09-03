package br.com.deckfudion.johnathan.camps

import br.com.deckfudion.johnathan.custon.ActorLine
import br.com.deckfudion.johnathan.custon.IconCamp
import br.com.deckfudion.johnathan.custon.IconOponent
import br.com.deckfudion.johnathan.louder.HistoryLouder
import br.com.deckfudion.johnathan.screen.History
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport


class Terra(var history: History) : Stage(history.viewport, history.game.batch) {


    var arrayOp = arrayListOf<Image>()
    val id = 2

    
        var egito:IconCamp? = null
        var guerreiro:IconCamp? = null
        var caveira:IconCamp? = null
        var terraCall:Runnable? = null

    init {

        val im = history.asset.external.get("/gameData/camps/terra.jpg", Texture::class.java)
        im.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)
        val camp = Image(im)




        camp.scaleBy(1.5f)
        addActor(camp)



        egito = IconCamp("egito", "Reino de Atem(Pos Vida)", history.asset)
        egito?.settStage(this)
        egito?.setPosition(1000f, 250f)

        guerreiro = IconCamp("sogen", "Reino dos Guerreiros", history.asset)
        guerreiro?.settStage(this)
        guerreiro?.setPosition(1100f, 450f)


        caveira = IconCamp("caveira", "Mundo Caveira", history.asset)
        caveira?.settStage(this)
        caveira?.setPosition(300f, 200f)



        val minion2 = IconOponent("estatua_guadian",10,history.asset!!)
        val minion3 = IconOponent("terra_mage",14,history.asset!!)
        val minion4 = IconOponent("terra_mage_matins",17,history.asset!!)
        val minion5 = IconOponent("utimate_tyrano",30,history.asset!!)









       



        minion2.setPosition(200f, 350f)


        minion3.setPosition(400f, 450f)


        minion4.setPosition(800f, 750f)



        minion5.setPosition(1000f, 600f)




        val line1 = ActorLine(egito!!, minion2, camera)
        line1.colorLine = Color.RED

        val line3 = ActorLine(minion2, minion3, camera)
        line3.colorLine = Color.RED


        val line4 = ActorLine(minion3, minion4, camera)
          line4.colorLine = Color.RED


        val line5 = ActorLine(minion3, guerreiro!!, camera)
        line5.colorLine = Color.RED


        val line6 = ActorLine(minion3, caveira!!,camera)
        line6.colorLine = Color.RED

        val line7 = ActorLine(minion4, minion5,camera)
        line7.colorLine = Color.RED


        addActor(line1)

        addActor(line3)
        addActor(line4)
        addActor(line5)
        addActor(line6)
        addActor(line7)




        addActor(minion2)
        addActor(egito)
        addActor(minion3)
        addActor(minion4)
        addActor(guerreiro)
        addActor(caveira)
        addActor(minion5)



        caveira?.addListener ( object : ClickListener(){
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                super.clicked(event, x, y)

                if(terraCall != null){
                    terraCall?.run()
                }



            }
        } )

    }



}