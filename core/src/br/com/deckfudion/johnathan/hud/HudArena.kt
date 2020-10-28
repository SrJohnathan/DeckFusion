package br.com.deckfudion.johnathan.hud

import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.screen.Arena
import br.com.deckfudion.johnathan.utill.StyleClass
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport

class HudArena(batch: Batch, viewport: Viewport,louderArena: LouderArena) : Stage(viewport, batch) {

     var fps: Label? = null
    private val table = Table()
    val tabledico = Table()

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
    val tools = Table()
     val infor = Table()



    init {


        table.setFillParent(true)
        table.top()


        tabledico.setFillParent(true)
        tabledico.bottom()


        //FILD



        val field =  louderArena.assetI.get("data/skin/camp.png", Texture::class.java)
        field.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)








        //VIDA

        val font = TextLouder.styleFontDigital(louderArena,Color.WHITE, 27)
        val bebas = TextLouder.styleBebas(Color.WHITE, 18)

        vidaminha = Label("8000",font )
        cartasMeu = Label("40", TextLouder.styleBebas(Color.WHITE, 30))


        vidaMaquina = Label("8000", font)
        cartasMaquina = Label("40", TextLouder.styleBebas(Color.WHITE, 30))


        val myhud =  louderArena.assetI.get("data/skin/hudnumerop.png", Texture::class.java)
        myhud.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)

        vida.background = TextureRegionDrawable(myhud)

        val you = Label("YOU",bebas)
        val com = Label("COM",bebas)

        textfield = Label("NORMAL", bebas)
        textfield?.setAlignment(Align.center)

        fild.add(textfield).center().expandX().fillX()

        vida.add(cartasMeu).padLeft(20f).padTop(-45f)
        vida.add(you).left().padTop(-40f).padLeft(30f)
        vida.add(vidaminha).padTop(-30f).expandX()
        vida.add(vidaMaquina).padTop(-30f).expandX()
        vida.add(com).right().padTop(-40f).padRight(30f)
        vida.add(cartasMaquina).padRight(20f).padTop(-45f)






        fps = Label("", TextLouder.styleFontInitOsRegular(Color.WHITE, 25))


        //ENIGMA MILENIO
        enigma = ProgressBar(0f,100f,1f,true,StyleClass.enigmaProgress())
        enigma?.value = 50f
        enigma?.setAnimateDuration(0.25f)
        tools.add(enigma)



      //
        table.add(vida).center().width(535f)
        table.row()
        table.add(fild).center().padTop(-50f)

        table.row()
        table.add(fps).left().expandX()




        table.padTop(10f)





        //DISCO

        nomecartaInfor.setAlignment(Align.left)

        infor.add(nomecartaInfor).expandX().left().fillX().padLeft(40f)

        cards.add(infor).expandX().bottom().padTop(100f).fillX()

        val cartasmy =  louderArena.assetI.get("data/skin/cartasmy.png", Texture::class.java)
        cartasmy.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)

        val cartasmytools =  louderArena.assetI.get("data/skin/cartasmytool.png", Texture::class.java)
        cartasmy.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)

        cards.background = TextureRegionDrawable(cartasmy)
        tools.background = TextureRegionDrawable(cartasmytools)

        tabledico.add(tools).bottom().center()
        tabledico.add(cards).bottom().center()


        addActor(table)
        addActor(tabledico)








    }


}