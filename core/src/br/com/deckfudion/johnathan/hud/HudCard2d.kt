package br.com.deckfudion.johnathan.hud

import br.com.deckfudion.johnathan.card.Card2dSmall
import br.com.deckfudion.johnathan.card.DeckTotal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Dialog
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.Viewport


class HudCard2d(batch: Batch, viewport: Viewport, var deck: DeckTotal) : Stage(viewport, batch) {

    var card1: Card2dSmall? = null
    var card2: Card2dSmall? = null
    var card3: Card2dSmall? = null
    var card4: Card2dSmall? = null
    var card5: Card2dSmall? = null


    var num1 = Image(LouderFull.setanumero?.findRegion("card1"))
    var num2 = Image(LouderFull.setanumero?.findRegion("card2"))
    var num3 = Image(LouderFull.setanumero?.findRegion("card3"))
    var num4 = Image(LouderFull.setanumero?.findRegion("card4"))
    var num5 = Image(LouderFull.setanumero?.findRegion("card5"))


    var table = Group()




    var setaId = 0
    var contagemFusao = 0
    var cardDrag = -1
    var cacheButFusion = false
    var isFusion = false
    var combate = false
    var rotate = false
    var clickHand: ClickHand? = null
    val array = arrayListOf<Card2dSmall>()
    var thisCard = -1


    init {


        card1 = Card2dSmall(deck.ar.get(0))
        card2 = Card2dSmall(deck.ar.get(1))
        card3 = Card2dSmall(deck.ar.get(0))
        card4 = Card2dSmall(deck.ar.get(1))
        card5 = Card2dSmall(deck.ar.get(0))



        card1?.idMao = 0
        card2?.idMao = 1
        card3?.idMao = 2
        card4?.idMao = 3
        card5?.idMao = 4


        card1?.setPosition(150f, 120f)
        card2?.setPosition((card2?.width!! * 2) + 60f, 120f)
        card3?.setPosition((card2?.width!! * 3) + 120f, 120f)
        card4?.setPosition((card2?.width!! * 4) + 180f, 120f)
        card5?.setPosition((card2?.width!! * 5) + 240f, 120f)






        num1.isVisible = false
        num2.isVisible = false
        num3.isVisible = false
        num4.isVisible = false
        num5.isVisible = false


        array.add(card1!!)
        array.add(card2!!)
        array.add(card3!!)
        array.add(card4!!)
        array.add(card5!!)




    }


    fun call(card2dSmall: Card2dSmall): ClickListener {

        return object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                if (isFusion) {
                    clickHand?.click(card2dSmall.idMao)
                }


            }
        }
    }

    fun run() {

        table.addActor(card1)
        table.addActor(card2)
        table.addActor(card3)
        table.addActor(card4)
        table.addActor(card5)


        addActor(table)



        addActor(num1)
        addActor(num2)
        addActor(num3)
        addActor(num4)
        addActor(num5)

        setValueCards()

    }


    fun allNumeberFusinInvisible() {

        num1.isVisible = false
        num2.isVisible = false
        num3.isVisible = false
        num4.isVisible = false
        num5.isVisible = false
        contagemFusao = 0
    }


    private fun setValueCards() {


        array.forEach { card2dSmall: Card2dSmall ->

            card2dSmall.addListener(call(card2dSmall))

            card2dSmall.addListener(object : DragListener() {

                override fun dragStop(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                    if (!isFusion && !combate) {
                        if ((card2dSmall.x > 530f || card2dSmall.x < 580f) && card2dSmall.y > 400f) {

                            if (cardDrag == -1) {
                                card2dSmall.addAction(Actions.moveTo(560f, 405f, 0.1f))
                                cardDrag = card2dSmall.idMao
                                rotate = true
                                cacheButFusion = true
                                thisCard = array.indexOf(card2dSmall)

                            } else {
                                location(card2dSmall)
                                if (cardDrag == card2dSmall.idMao) {
                                    cardDrag = -1
                                    rotate = false
                                    cacheButFusion = true
                                }

                            }

                        } else {

                            location(card2dSmall)
                            if (cardDrag == card2dSmall.idMao) {
                                cardDrag = -1
                                rotate = false
                                cacheButFusion = true
                            }
                        }
                    }


                }

                override fun drag(event: InputEvent, x: Float, y: Float, pointer: Int) {
                    if (!isFusion && !combate ) {
                        card2dSmall.moveBy(x - card2dSmall.getWidth() / 2, y - card2dSmall.getHeight() / 2)
                    }
                }
            })

        }


    }

    fun location(card2dSmall: Card2dSmall) {

        when (card2dSmall.idMao) {

            0 -> {
                card2dSmall.addAction(Actions.moveTo(150f, 120f, 0.2f))
            }
            1 -> {
                card2dSmall.addAction(Actions.moveTo((card2?.width!! * 2) + 60f, 120f, 0.2f))
            }
            2 -> {
                card2dSmall.addAction(Actions.moveTo((card2?.width!! * 3) + 120f, 120f, 0.2f))
            }
            3 -> {
                card2dSmall.addAction(Actions.moveTo((card2?.width!! * 4) + 180f, 120f, 0.2f))
            }
            4 -> {
                card2dSmall.addAction(Actions.moveTo((card2?.width!! * 5) + 240f, 120f, 0.2f))
            }


        }

    }

    fun votarTudoOne() {
        if (cardDrag == array.get(thisCard).idMao) {
            cardDrag = -1
            rotate = false
            array.forEach { card2dSmall: Card2dSmall -> card2dSmall.im.isVisible = false }
        }

    }

    fun shadow() {

        array.forEach { card2dSmall: Card2dSmall ->

            if (array.get(thisCard) != card2dSmall) {
                card2dSmall.im.isVisible = true
            }

        }

    }


    interface ClickHand {

        fun click(id: Int)
    }
}