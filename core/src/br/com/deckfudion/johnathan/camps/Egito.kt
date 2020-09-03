package br.com.deckfudion.johnathan.camps

import br.com.deckfudion.johnathan.custon.ActorLine
import br.com.deckfudion.johnathan.custon.IconCamp
import br.com.deckfudion.johnathan.custon.IconGemas
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


class Egito(var history: History) : Stage(history.viewport, history.game.batch) {


    var arrayOp = arrayListOf<Image>()
    val id = 1


    var gemaAgua: IconGemas? = null
    var gemaCaveira: IconGemas? = null
    var gemaDragao: IconGemas? = null
    var gemaForca: IconGemas? = null
    var gemaLuz: IconGemas? = null
    var gemaMaquina: IconGemas? = null
    var gemaPlanta: IconGemas? = null
    var gemaTerra: IconGemas? = null
    var gemaTrevas: IconGemas? = null


    var terraCall:Runnable? = null
    var terra:IconCamp? = null

    init {

        val im = history.asset.external.get("/gameData/camps/egito.jpg", Texture::class.java)
        im.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        val camp = Image(im)




        camp.scaleBy(1.5f)
        addActor(camp)


        //APONENTES
        val minion1 = IconOponent("egito_solder", 1, history.asset)
        val minion2 = IconOponent("egito_solder", 1, history.asset)
        val minion3 = IconOponent("egito_solder", 2, history.asset)
        val minion4 = IconOponent("heishin", 10, history.asset)
        val mahad = IconOponent("mahad", 7, history.asset)
        val mahad2 = IconOponent("mahad", 80, history.asset)
        val atem = IconOponent("atem", 100, history.asset)




        minion1.setPosition(500f, 150f)
        minion2.setPosition(200f, 250f)
        minion3.setPosition(700f, 250f)
        minion4.setPosition(600f, 550f)
        mahad.setPosition(900f, 350f)
        mahad2.setPosition(800f, 1000f)
        atem.setPosition(200f, 1100f)



        //CAMPO
        terra = IconCamp("terra", "Terra", history.asset)
        terra?.settStage(this)
        terra?.circle?.setPosition(1100f, 550f, Align.center)
        terra?.setPosition(1100f, 550f)

        val humana = IconCamp("humano", "Kisara (Dimenção Humana)", history.asset)
        humana.settStage(this)
        humana.circle?.setPosition(1100f, 1250f, Align.center)
        humana.setPosition(1100f, 1250f)



        //GEMAS
        gemaAgua = IconGemas("agua", "Agua", history.asset, "monomento")
        gemaCaveira = IconGemas("caveira", "Caveira", history.asset, "monomento")
        gemaDragao = IconGemas("dragao", "Dragão", history.asset, "monomento")
        gemaForca = IconGemas("forca", "Força", history.asset, "monomento")
        gemaLuz = IconGemas("luz", "Luz", history.asset, "monomento")
        gemaMaquina = IconGemas("maquina", "Maquina", history.asset, "monomento")
        gemaPlanta = IconGemas("planta", "Planta", history.asset, "monomento")
        gemaTerra = IconGemas("terra", "Terra", history.asset, "monomento")
        gemaTrevas = IconGemas("trevas", "Trevas", history.asset, "monomento")


        gemaAgua?.visible(true)
        gemaCaveira?.visible(true)
        gemaDragao?.visible(true)
        gemaForca?.visible(true)
        gemaLuz?.visible(true)
        gemaMaquina?.visible(true)
        gemaPlanta?.visible(true)
        gemaTerra?.visible(true)
        gemaTrevas?.visible(true)

        gemaAgua?.setPosition(200f + 50f, 750f)
        gemaCaveira?.setPosition(320f + 50f, 750f)
        gemaDragao?.setPosition(440f + 50f, 750f)
        gemaForca?.setPosition(560f + 50f, 750f)
        gemaLuz?.setPosition(670f + 50f, 750f)
        gemaMaquina?.setPosition(800f + 50f, 750f)
        gemaPlanta?.setPosition(920f + 50f, 750f)
        gemaTerra?.setPosition(1040f + 50f, 750f)
        gemaTrevas?.setPosition(1160f + 50f, 750f)


        gemaAgua?.settStage(this)
        gemaCaveira?.settStage(this)
        gemaDragao?.settStage(this)
        gemaForca?.settStage(this)
        gemaLuz?.settStage(this)
        gemaMaquina?.settStage(this)
        gemaPlanta?.settStage(this)
        gemaTerra?.settStage(this)
        gemaTrevas?.settStage(this)





        val line1 = ActorLine(minion1, minion2, camera)
        val line2 = ActorLine(minion1, minion3, camera)
        val line3 = ActorLine(minion3, minion4, camera)
        val line4 = ActorLine(minion4, terra!!, camera)
        val line5 = ActorLine(minion4, gemaLuz!!, camera)
        val line6 = ActorLine(minion3, mahad, camera)
        val line6c = ActorLine(mahad, terra!!, camera)

        val line7 = ActorLine(gemaLuz!!, mahad2, camera)
        val line8 = ActorLine(mahad2, atem, camera)
        val line9 = ActorLine(atem, humana, camera)
        line9.colorLine = Color.ROYAL


        addActor(line1)
        addActor(line2)
        addActor(line3)
        addActor(line4)
        addActor(line5)
        addActor(line6)
        addActor(line6c)
        addActor(line7)
        addActor(line8)
        addActor(line9)



        addActor(gemaAgua)
        addActor(gemaCaveira)
        addActor(gemaDragao)
        addActor(gemaForca)
        addActor(gemaLuz)
        addActor(gemaMaquina)
        addActor(gemaPlanta)
        addActor(gemaTerra)
        addActor(gemaTrevas)

        addActor(minion2)
        addActor(minion1)
        addActor(minion3)
        addActor(minion4)
        addActor(terra!!)
        addActor(mahad)
        addActor(mahad2)
        addActor(atem)

        addActor(humana)





        terra?.addListener ( object :ClickListener(){
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                super.clicked(event, x, y)

                if(terraCall != null){
                    terraCall?.run()
                }



            }
        } )

    }



}