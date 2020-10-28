package br.com.deckfudion.johnathan.hud

import br.com.deckfudion.johnathan.card.Card2dSmall
import br.com.deckfudion.johnathan.libs.scene3d.Camera3d
import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.Viewport

class HudCard(batch: Batch, viewport: Viewport) : Stage(viewport, batch) {

    var card1: Image? = null
    var card2: Image? = null
    var card3: Image? = null
    var card4: Image? = null
    var card5: Image? = null

    var table = Group()

    var array = arrayListOf<Image>()

    var ataque = false
    var arrayCard = arrayListOf<Card2dSmall>()
    val localeTabu = HashMap<Int, Array<Float>>()
    var indexCardAtk = -1

    init {


        card1 = Image(LouderFull.asset.get("data/imagens/card_hover.png", Texture::class.java))
        card2 = Image(LouderFull.asset.get("data/imagens/card_hover.png", Texture::class.java))
        card3 = Image(LouderFull.asset.get("data/imagens/card_hover.png", Texture::class.java))
        card4 = Image(LouderFull.asset.get("data/imagens/card_hover.png", Texture::class.java))
        card5 = Image(LouderFull.asset.get("data/imagens/card_hover.png", Texture::class.java))






        card1?.setPosition(165f, 350f)
        card2?.setPosition(360f, 350f)
        card3?.setPosition(570f, 350f)
        card4?.setPosition(770f, 350f)
        card5?.setPosition(970f, 350f)

        localeTabu.put(0, arrayOf(165f, 344f))
        localeTabu.put(1, arrayOf(360f, 344f))
        localeTabu.put(2, arrayOf(570f, 344f))
        localeTabu.put(3, arrayOf(770f, 344f))
        localeTabu.put(4, arrayOf(970f, 344f))


        //  ce?.setPosition(310f, 344f)

        //   table.addActor(ce)


        array.add(card1!!)
        array.add(card2!!)
        array.add(card3!!)
        array.add(card4!!)
        array.add(card5!!)

    }


    fun run() {

        table.addActor(card1)
        table.addActor(card2)
        table.addActor(card3)
        table.addActor(card4)
        table.addActor(card5)

        addActor(table)

        array.forEach { image: Image ->

            image.isVisible = false
            image.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                    Actions.fadeOut(1f),
                    Actions.fadeIn(1f))))


        }
    }


    fun visivle() {

        array.forEach { image: Image ->

            image.isVisible = true
        }
    }


    fun invisivle() {

        array.forEach { image: Image ->

            image.isVisible = false
        }
    }

    fun add(small: Card2dSmall) {
        arrayCard.add(small)



        small.addListener(object : ActorGestureListener() {

            override fun longPress(actor: Actor?, x: Float, y: Float): Boolean {



                when (small.modoDefence) {

                    true -> {
                        small.addAction(Actions.rotateBy(-90f, 0.2f))
                        small.modoDefence = false
                    }
                    false -> {
                        small.addAction(Actions.rotateBy(90f, 0.2f))
                        small.modoDefence = true
                    }

                }




                return true
            }

            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
                if (!ataque) {
                    ataque = true
                    Camera3d.moveBy(0f, 0f, -3.9f, 0.3f)
                    small.addAction(Actions.moveBy(0f, -550f, 0.2f))
                    indexCardAtk = arrayCard.indexOf(small)
                }

            }
        })

    }

}