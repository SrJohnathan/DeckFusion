package br.com.deckfudion.johnathan.card


import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable


class Card2d(var card: Cards?) : Table() {


    val ataque = Label("0", TextLouder.styleBebas(Color.WHITE, 30))
    val defeza = Label("0", TextLouder.styleBebas(Color.WHITE, 30))
    var stars = Table()
    val attr = Image()
    val img1 = Image()
    val tableNum = Table()

    init {

        if (card != null) {
            init(card!!)
        }


    }


    fun setCards(cardMy: Cards) {

        ataque.setText(cardMy.atk.toString())
        defeza.setText(cardMy.def.toString())
        this.background = TextureRegionDrawable(LouderFull.card2dBig?.findRegion(cardMy.cardcolor.toString()))
        img1.drawable = TextureRegionDrawable(LouderExternal.cardsTextures?.findRegion(cardMy.idd.toString()))
        attr.drawable = TextureRegionDrawable(LouderFull.iconsMoster?.findRegion(cardMy.attr.toString()))

        stars.clear()

        for (i in 1..cardMy.star) {
            val star = Image(LouderFull.iconsMoster?.findRegion("39"))

            stars.add(star).width(20f).height(20f)
        }

    }


    fun init(cardMy: Cards) {


        img1.drawable = TextureRegionDrawable(LouderExternal.cardsTextures?.findRegion(cardMy.idd.toString()))


        val stars2 = Table()


      /*  for (i in 1..cardMy.star) {
            val star = Image(LouderFull.iconsMoster?.findRegion("39"))

            stars.add(star).width(20f).height(20f)
        } */


    //    attr.drawable = TextureRegionDrawable(LouderFull.iconsMoster?.findRegion(cardMy.attr.toString()))

       // stars2.add(stars).center().fillX().expandX()
      //  stars2.add(attr).width(30f).height(30f).right().padRight(10f)


        this.background = TextureRegionDrawable(LouderFull.card2dBig?.findRegion(cardMy.cardcolor.toString()))

        this.add(img1)?.top()!!.expandX().fillX().padRight(1f).padLeft(1f).height(245f).width(237f).padTop(5f)
      //  this.row()
       // this.add(stars2)?.expandX()?.top()?.padTop(5f)?.fillX()


      //  ataque.setText(cardMy.atk.toString())
      //  defeza.setText(cardMy.def.toString())

        tableNum.add(ataque)!!.expandX().left().padLeft(35f)
        tableNum.add(defeza)!!.expandX().right().padRight(35f)

        this.row()
        this.add(tableNum)!!.expandX()?.expandY()?.center()?.fillX()?.padTop(-10f)

        // root?.setBackground(TextureRegionDrawable(AtlasLouder.cartasBig?.findRegion(card.cardColor.toString())))

    }
}



