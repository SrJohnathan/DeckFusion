package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.card.Card2d
import br.com.deckfudion.johnathan.card.Card2dEditor
import br.com.deckfudion.johnathan.card.DeckTotal
import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.StyleClass
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport


class DeckEditor(var game: Main) : Screen {

    private var camera: OrthographicCamera? = null
    private var viewport: Viewport? = null

    var bau: Bau? = null
    var deck:Deck? = null

    var stback: Stage? = null

    var buttonChar:ImageButton? = null

    var deckEditor: Texture? = null
    var bauOuDeck = false

    val decktotal = DeckTotal()

    init {

        camera = OrthographicCamera(1280f, 720f)
        viewport = FitViewport(1280f, 720f, camera)

        deckEditor = LouderExternal.imgImageDeck
        deckEditor?.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)


        bau = Bau(game.batch, viewport!!,decktotal,this)
        deck = Deck(game.batch, viewport!!,decktotal,this)

        stback = Stage(viewport!!, game.batch)
        val t = Table()
        t.setFillParent(true)
        t.top()
        t.background = TextureRegionDrawable(deckEditor)
        stback?.addActor(t)


        val chest = Label("Deck Edition".toUpperCase(), TextLouder.styleBebasBorder(Color.WHITE, 35))


        val title = Table()

        title.background = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/button.png", Texture::class.java))
        title.add(chest)

        t.add(title).pad(10f).width(500f)








    }


    override fun hide() {
    }

    override fun show() {

        deck?.start()
        bau?.start()

        val xis = ImageButton.ImageButtonStyle()
        xis.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/ok.png", Texture::class.java))

        val button = ImageButton(xis)

        button.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.moveBy(-20f, 0f, 0.5f),
                Actions.moveBy(20f, 0f, 0.5f))))



        button.setPosition(1170f,630f)

        stback?.addActor(button)

    }

    override fun render(delta: Float) {





        Gdx.gl.glClearColor(Color.BLACK)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)


        stback?.draw()


        if(bauOuDeck){

            Gdx.input.inputProcessor = InputMultiplexer(deck,stback)


        }else{
            Gdx.input.inputProcessor = InputMultiplexer( bau,stback)


        }
        deck?.act(delta)
        bau?.act(delta)
        bau?.draw()
        deck?.draw()


        stback?.act(delta)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
        camera?.update()
        viewport?.update(width, height)
    }

    override fun dispose() {
    }


    class Bau(batch: Batch, viewport: Viewport,var deckTotal: DeckTotal, var deckEditor: DeckEditor) : Stage(viewport, batch) {

        var root: Table? = null

        val chests = Label("chest".toUpperCase(), TextLouder.styleBebasBorder(Color.WHITE, 35))
        val chestsNum = Label("00", TextLouder.styleBebasBorder(Color.WHITE, 23))


        init {

            root = Table()
            root?.setFillParent(true)
            root?.bottom()


            val chestDeck = Table()
            chestDeck.background = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/tabc.png", Texture::class.java))

            val back = LouderExternal.imgImageItens!!
            back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

            root?.background = TextureRegionDrawable(back)
            root?.width = viewport.worldWidth
            root?.height = viewport.worldHeight


            chests.setPosition(1120f, 530f)
            chestsNum.setPosition(1200f, 505f)


            chestDeck.add(chests)
            chestDeck.row()
            chestDeck.add(chestsNum)


            val font = TextLouder.styleBebasBorder(Color.WHITE, 23)
            val fontm = TextLouder.styleBebasBorder(Color.WHITE, 30)


            val list = Table()


            val scroll = ScrollPane(list)
            scroll.setScrollingDisabled(true, false)

            for (i in 0..1999) {

                list.row()

                val containerIntens = Table()
                containerIntens.left().padLeft(10f)

                containerIntens.background = TextureRegionDrawable(LouderExternal.imgItens)

                val numero = Label("0000", fontm)
                containerIntens.add(numero).padLeft(5f)
                val nome = Label("O Podoreso Gaia Force Rebelion", TextLouder.styleBebas(Color.GREEN, 30))
                nome.setEllipsis(true)
                containerIntens.add(nome).padLeft(10f).width(350f)

                val es = LouderFull.asset.get("data/imagens/espada.png", Texture::class.java)
                val esc = LouderFull.asset.get("data/imagens/escudo.png", Texture::class.java)

                val atkdef = Table()
                val atk = Label("3000", font)
                atkdef.add(Image(es)).width(25f).height(25f)
                atkdef.add(atk)
                atkdef.row()


                val def = Label("3000", font)
                atkdef.add(Image(esc)).width(25f).height(25f)
                atkdef.add(def)
                containerIntens.add(atkdef).pad(10f)

                val quanti = Table()
                val numeq = Label("Total", font)
                val nume = Label("1", font)

                quanti.add(numeq)
                quanti.row()
                quanti.add(nume)

                containerIntens.add(quanti).pad(10f)


                val deck = Table()
                val deckq = Label("Deck", font)
                val dec = Label("1", font)

                deck.add(deckq)
                deck.row()
                deck.add(dec)

                containerIntens.add(deck).pad(10f)


                val typeimg = LouderFull.iconsMoster?.findRegion("13")
                typeimg?.texture?.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

                containerIntens.add(Image(typeimg)).width(50f).height(50f).pad(10f)


                val add = TextButton("ADD", StyleClass.voltaButtonVerde())
                val info = TextButton("INFO", StyleClass.voltaButtonAzul())

                containerIntens.add(add)
                containerIntens.add(info).padRight(20f)



                list.add(containerIntens).left().expandX()
            }


            val menu = Table()


            val new = StyleClass.textCheckBox("NEW", "ckeck")
            val number = StyleClass.textCheckBox("NUB", "ckeck")
            val type = StyleClass.textCheckBox("TYP", "ckeck")
            val atk = StyleClass.textCheckBox("ATK", "ckeck")
            val def = StyleClass.textCheckBox("DEF", "ckeck")

            menu.add(new).padLeft(50f)
            menu.add(number).padLeft(50f)
            menu.add(type).padLeft(50f)
            menu.add(atk).padLeft(50f)
            menu.add(def).padLeft(50f)
            menu.add(chestDeck).height(120f).expandX().right().padBottom(10f)


            val buttonGroup = ButtonGroup(new, type, number, atk, def)
            buttonGroup.setMaxCheckCount(1);
            buttonGroup.setMinCheckCount(0);



            root?.add(menu)?.center()?.expandX()
            root?.row()
            root?.add(scroll)?.expandX()?.width(1200f)?.height(450f)?.bottom()?.left()?.padBottom(40f)?.padLeft(45f)


            addActor(root)




        }

        fun start() {

            val button = ImageButton(StyleClass.goButton())

            button?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                    Actions.moveBy(-20f, 0f, 0.5f),
                    Actions.moveBy(20f, 0f, 0.5f))))



            button.setPosition(1150f,550f)

            addActor(button)


            button.addListener( object :ClickListener(){

                override fun clicked(event: InputEvent?, x: Float, y: Float) {

                    addAction(Actions.parallel(Actions.parallel(
                        Actions.sequence(
                                Actions.moveBy(20f,0f,0.2f),
                                        Actions.moveBy(-20f,0f,0.2f)


                    ),Actions.fadeOut(0.4f)

                    ),Actions.run(Runnable {

                        deckEditor.bauOuDeck = true

                       deckEditor.deck?. addAction(Actions.parallel(Actions.parallel(
                                Actions.sequence(
                                        Actions.moveBy(-20f,0f,0.2f),
                                        Actions.moveBy(20f,0f,0.2f)


                                ),Actions.fadeIn(0.4f)

                        ),Actions.run(Runnable {}))) })))

                }

            })
        }
    }

   class Deck(batch: Batch, viewport: Viewport,var deckTotal: DeckTotal, var deckEditor: DeckEditor) : Stage(viewport, batch) {

        var root: Table? = null

        val chests = Label("Deck".toUpperCase(), TextLouder.styleBebasBorder(Color.WHITE, 35))
        val chestsNum = Label("00", TextLouder.styleBebasBorder(Color.WHITE, 23))


        init {

            root = Table()
            root?.setFillParent(true)
            root?.bottom()


            val chestDeck = Table()
            chestDeck.background = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/tabc.png", Texture::class.java))

            val back = LouderExternal.imgImageItens!!
            back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

            root?.background = TextureRegionDrawable(back)
            root?.width = viewport.worldWidth
            root?.height = viewport.worldHeight


            chests.setPosition(1120f, 530f)
            chestsNum.setPosition(1200f, 505f)


            chestDeck.add(chests)
            chestDeck.row()
            chestDeck.add(chestsNum)





            val list = Table()


            val scroll = ScrollPane(list)
            scroll.setScrollingDisabled(true, false)

            var row = 1
            for (i in 0..39) {

                if(row == 7){
                    row = 1
                    list.row()
                }
                row += 1

                try {
                    val card =     Card2dEditor(deckTotal.ar.get(1))
                    list.add(card).padLeft(10f).padBottom(10f)
                }catch (e:Exception){
                    e.printStackTrace()
                }


            }


            val menu = Table()


            val number = StyleClass.textCheckBox("NUB", "ckeck")
            val type = StyleClass.textCheckBox("TYP", "ckeck")
            val atk = StyleClass.textCheckBox("ATK", "ckeck")
            val def = StyleClass.textCheckBox("DEF", "ckeck")

            menu.add(number).padLeft(50f)
            menu.add(type).padLeft(50f)
            menu.add(atk).padLeft(50f)
            menu.add(def).padLeft(50f)
            menu.add(chestDeck).height(120f).expandX().right().padBottom(10f)


            val buttonGroup = ButtonGroup( type, number, atk, def)
            buttonGroup.setMaxCheckCount(1);
            buttonGroup.setMinCheckCount(0);



            root?.add(menu)?.center()?.expandX()
            root?.row()
            root?.add(scroll)?.expandX()?.width(1200f)?.height(450f)?.bottom()?.left()?.padBottom(40f)?.padLeft(45f)?.left()


            addActor(root)

            addAction(Actions.fadeOut(0f))
        }



       fun start(){

           val button = ImageButton(StyleClass.voltaButton())

           button?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                   Actions.moveBy(-20f, 0f, 0.5f),
                   Actions.moveBy(20f, 0f, 0.5f))))



        button.setPosition(100f,550f)

        addActor(button)

           button.addListener( object :ClickListener(){

               override fun clicked(event: InputEvent?, x: Float, y: Float) {

                   addAction(Actions.parallel(Actions.parallel(
                           Actions.sequence(
                                   Actions.moveBy(-20f,0f,0.2f),
                                   Actions.moveBy(20f,0f,0.2f)


                           ),Actions.fadeOut(0.4f)

                   ),Actions.run(Runnable {

                       deckEditor.bauOuDeck = false

                       deckEditor.bau?. addAction(Actions.parallel(Actions.parallel(
                               Actions.sequence(
                                       Actions.moveBy(20f,0f,0.2f),
                                       Actions.moveBy(-20f,0f,0.2f)


                               ),Actions.fadeIn(0.4f)

                       ),Actions.run(Runnable {}))) })))

               }

           })

       }

    }

}


