package br.com.deckfudion.johnathan.hud

import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.StyleClass
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport

class HudArena(batch: Batch, viewport: Viewport) : Stage(viewport, batch) {

     var fps: Label? = null
    private val table = Table()
    private val tabledico = Table()

    private var fild = Table()
    private var textfield: Label? = null

    private var vida = Table()

    private var cartasMeu: Label? = null
    private var cartasMaquina: Label? = null

    private var vidaminha: Label? = null
    private var vidaMaquina: Label? = null

    private val nomecartaInfor: Label = Label("JOHNATHAN", TextLouder.styleBebas(Color.WHITE,30))

    var enigma:ProgressBar? = null


    val cards = Table()
   private  val infor = Table()



    init {


        table.setFillParent(true)
        table.top()


        tabledico.setFillParent(true)
        tabledico.bottom()


        //FILD

        textfield = Label("NORMAL", TextLouder.styleBebas(Color.WHITE, 30))

        fild.background = TextureRegionDrawable(LouderFull.arenaSprite?.findRegion("field"))

        fild.add(textfield).padTop(25f)




        //VIDA

        vidaminha = Label("8000", TextLouder.styleBebas(Color.WHITE, 30))
        cartasMeu = Label("40", TextLouder.styleBebas(Color.WHITE, 30))


        vidaMaquina = Label("8000", TextLouder.styleBebas(Color.WHITE, 30))
        cartasMaquina = Label("40", TextLouder.styleBebas(Color.WHITE, 30))


        vida.background = TextureRegionDrawable(LouderFull.arenaSprite?.findRegion("vida"))
        vida.scaleBy(0.5f)

        vida.add(vidaminha).padLeft(90f).padTop(5f)
        vida.row()
        vida.add(cartasMeu).padLeft(100f)
        vida.row()
        vida.add(cartasMaquina).padLeft(100f).padTop(5f)
        vida.row()
        vida.add(vidaMaquina).padLeft(90f).padTop(0f)





        fps = Label("", TextLouder.styleFontInitOsRegular(Color.WHITE, 25))


        enigma = ProgressBar(0f,100f,1f,true,StyleClass.enigmaProgress())
        enigma?.value = 50f
        enigma?.setAnimateDuration(0.25f)


        table.add(fild).left().padTop(10f).padLeft(10f).expandX()
        table.add(vida).left().padTop(10f).padRight(10f).height(150f).width(200f)

        table.row()
        table.add(fps).left().expandX()
        table.row()
        table.add(enigma).left()







        //DISCO

        nomecartaInfor.setAlignment(Align.left)

        infor.add(nomecartaInfor).expandX().left().fillX().padLeft(40f)

        cards.add(infor).expandX().bottom().padTop(100f).fillX()

        cards.background = TextureRegionDrawable(LouderFull.arenaSprite?.findRegion("disco1"))
        tabledico.add(cards).expandX().bottom().fillX().padLeft(100f).padRight(100f)


        addActor(table)
        addActor(tabledico)








    }


}