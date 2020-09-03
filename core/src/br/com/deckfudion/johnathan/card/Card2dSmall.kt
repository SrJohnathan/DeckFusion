package br.com.deckfudion.johnathan.card


import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Stack
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.Disposable


class Card2dSmall(var card: Cards?) : Stack(), Disposable {


    val ataque = Label("0", TextLouder.styleBebasBorder(Color.WHITE, 23))
    val defeza = Label("0", TextLouder.styleBebasBorder(Color.WHITE, 23))

    val es = LouderFull.asset.get("data/imagens/espada.png", Texture::class.java)
    val esc = LouderFull.asset.get("data/imagens/escudo.png", Texture::class.java)
    val im = Image(LouderFull.asset.get("data/imagens/shadow.png", Texture::class.java))
    val img1 = Image()
    val tableNum = Table()

    var idMao = 0
    var isTabuLocale = -1
    var modoDefence = false;

    var root = Table()



    constructor() : this(null)


    init {


        if (card != null) {
            init(card!!)

            width = 148f
            height = 202f


        }


    }



    fun setCards(cardMy: Cards) {

        ataque.setText(cardMy.atk.toString())
        defeza.setText(cardMy.def.toString())
        root.background = TextureRegionDrawable(LouderFull.card2dSmall?.findRegion(cardMy.cardcolor.toString()))
        img1.drawable = TextureRegionDrawable(LouderExternal.cardsTextures?.findRegion(cardMy.idd.toString()))


    }


    fun init(cardMy: Cards) {


        img1.drawable = TextureRegionDrawable(LouderExternal.cardsTextures?.findRegion(cardMy.idd.toString()))



        root.background = TextureRegionDrawable(LouderFull.card2dSmall?.findRegion(cardMy.cardcolor.toString()))
        root.add(img1)?.top()!!.expandX().fillX().padRight(1f).padLeft(1f).height(141f).width(135f).padTop(5f)



        ataque.setText(cardMy.atk.toString())
        defeza.setText(cardMy.def.toString())

        ataque.setAlignment(Align.right)
        defeza.setAlignment(Align.right)


        es.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)



        val espada = Image(es)


        esc.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

        val escudo = Image(esc)

        tableNum.add(espada).left().padLeft(5f)
        tableNum.add(ataque)!!.expandX().left().fillX()?.padRight(10f)
        tableNum.row()
        tableNum.add(escudo).left().padLeft(5f)
        tableNum.add(defeza)!!.expandX().left()?.padTop(-5f)?.fillX()?.padRight(10f)

        root.row()
        root.add(tableNum)!!.expandX()?.expandY()?.center()?.fillX()

        // root?.setBackground(TextureRegionDrawable(AtlasLouder.cartasBig?.findRegion(card.cardColor.toString())))



        im.width = 148f
       im. height = 202f
        im.isVisible = false

        addActor(root)
        addActor(im)
    }

    override fun dispose() {

        es.dispose()
        esc.dispose()

    }


}



