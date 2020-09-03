package br.com.deckfudion.johnathan.camps

import br.com.deckfudion.johnathan.custon.ActorLine
import br.com.deckfudion.johnathan.custon.IconOponent
import br.com.deckfudion.johnathan.louder.HistoryLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.Viewport


class Agua(var asset: HistoryLouder, batch: Batch, viewport: Viewport) : Stage(viewport, batch) {


    var hamon: IconOponent? = null
    var arrayOp = arrayListOf<Image>()
    val id = 1

    init {

        val im = asset.external.get("/gameData/camps/agua.jpg", Texture::class.java)
        im.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)
        val camp = Image(im)




        camp.scaleBy(1.5f)
        addActor(camp)


        val minion1 = IconOponent("iconsmin",1,asset!!)
        val minion2 = IconOponent("iconsmin",5,asset!!)
        val minion3 = IconOponent("iconsmin",13,asset!!)
        val minion4 = IconOponent("iconsmin",24,asset!!)
        val minion5 = IconOponent("iconsmin",34,asset!!)
        val minion6 = IconOponent("iconsmin",36,asset!!)
        hamon = IconOponent("hamon",40,asset!!)






        minion1.setPosition(200f, 150f)



        minion2.setPosition(1200f, 250f)


        minion3.setPosition(400f, 450f)


        minion4.setPosition(800f, 750f)


        minion5.setPosition(200f, 1000f)


        minion6.setPosition(1100f, 1100f)


        hamon?.setPosition(650f, 1200f)


        val line1 = ActorLine(minion1, minion2, camera)
        val line2 = ActorLine(minion1, minion3, camera)
        val line3 = ActorLine(minion3, minion4, camera)
        val line4 = ActorLine(minion4, minion5, camera)
        val line5 = ActorLine(minion5, minion6, camera)
        val line6 = ActorLine(minion6, hamon!!, camera)
        addActor(line1)
        addActor(line2)
        addActor(line3)
        addActor(line4)
        addActor(line5)
        addActor(line6)

        addActor(minion2)
        addActor(minion1)
        addActor(minion3)
        addActor(minion4)
        addActor(minion5)
        addActor(minion6)
        addActor(hamon)
    }



}