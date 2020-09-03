package br.com.deckfudion.johnathan.hud

import br.com.deckfudion.johnathan.card.Card2dSmall
import br.com.deckfudion.johnathan.custon.Particulas2D
import br.com.deckfudion.johnathan.libs.scene3d.Camera3d
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.PcController
import br.com.deckfudion.johnathan.utill.StyleClass
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport

class AndroidController(batch: Batch, viewport: Viewport) : Stage(viewport, batch) {



    var right: CheckBox? = null

    var ok: ImageButton? = null
    var no: ImageButton? = null
    var vira: ImageButton? = null
    var go: ImageButton? = null
    var olho: ImageButton? = null
    var menu: ImageButton? = null

    var pcController: PcController? = null

    var table = Table()

    var dialog: Dialog? = null
    var particulas2D1: Particulas2D? = null
    var particulas2D2: Particulas2D? = null

    private val fusionlabel: Label = Label("FUSION", TextLouder.styleBebas(Color.WHITE, 30))
    private val duellogo = Image(LouderFull.asset.get("data/imagens/duellogo.png", Texture::class.java))

    private var bu1: TextButton? = null
    private var bu2: TextButton? = null


    private var isOlhoCall = false

    init {




        val rigthStyle = CheckBox.CheckBoxStyle()
        rigthStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
        rigthStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/imagens/iconfu.png", Texture::class.java))
        rigthStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/imagens/iconfu.png", Texture::class.java))


        val downStyle = ImageButton.ImageButtonStyle()
        downStyle.imageUp = TextureRegionDrawable(LouderFull.controllerSprite?.findRegion("bottom"))
        downStyle.imageDown = TextureRegionDrawable(LouderFull.controllerSpriteBig?.findRegion("bottom"))




        right = CheckBox("", rigthStyle)




        val xis = ImageButton.ImageButtonStyle()
        xis.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/ok.png", Texture::class.java))

        val qua = ImageButton.ImageButtonStyle()
        qua.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/no.png", Texture::class.java))


        val bo = ImageButton.ImageButtonStyle()
        bo.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/iconrotate.png", Texture::class.java))


        val tri = ImageButton.ImageButtonStyle()
        tri.imageUp = TextureRegionDrawable(LouderFull.controllerSprite?.findRegion("triangulo"))
        tri.imageDown = TextureRegionDrawable(LouderFull.controllerSpriteBig?.findRegion("triangle"))



        this.ok = ImageButton(xis)
        this.ok?.setPosition(250f, 610f)
        addActor(this.ok)
        ok?.isVisible = false

        this.no = ImageButton(qua)
        this.no?.setPosition(910f, 610f)
        addActor(this.no)
        no?.isVisible = false

        this.vira = ImageButton(bo)
        this.vira?.setPosition(450f, 425f)
        addActor(this.vira)
        vira?.isVisible = false

        olho = ImageButton(StyleClass.olhoButton())
        olho?.setPosition(650f, 640f)
        addActor(olho)

        go = ImageButton(StyleClass.goButton())
        go?.setPosition(650f, 640f)
        addActor(go)

        menu = ImageButton(StyleClass.menuButton())
        menu?.setPosition(450f, 640f)
        addActor(menu)

        fusionlabel.style.background = TextureRegionDrawable(LouderFull.asset.get("data/imagens/menu.png", Texture::class.java))

        fusionlabel.setAlignment(Align.center)

        table.setPosition(1120f, 400f)
        table.setSize(350f, 100f)

        table.add(right).padRight(10f)
        table.add(fusionlabel).width(180f).height(50f)
        addActor(table)

        val w = Window.WindowStyle()

        w.titleFont = TextLouder.styleBebas(Color.WHITE, 30).font
        w.titleFontColor = Color.WHITE
        w.background = TextureRegionDrawable(LouderFull.asset.get("data/imagens/dialog.png", Texture::class.java))


        dialog = Dialog("", w)


        particulas2D1 = Particulas2D(0)
        particulas2D2 = Particulas2D(1)

        val st = TextButton.TextButtonStyle()
        st.up = TextureRegionDrawable(LouderFull.asset.get("data/imagens/button.png", Texture::class.java))
        st.font = TextLouder.styleBebasBorder(Color.WHITE, 23).font

        bu1 = TextButton("Element 1", st)
        bu2 = TextButton("Element 2", st)

        bu1?.addActor(particulas2D1)
        bu2?.addActor(particulas2D2)

        dialog?.contentTable?.row()
        dialog?.contentTable?.add(bu1)?.padBottom(10f)
        dialog?.contentTable?.row()
        dialog?.contentTable?.add(bu2)



        addActor(duellogo)

        duellogo.setPosition(-300f,400f)


    }


   fun  duellogo(runnable1: Runnable,runnable2: Runnable){

       duellogo.addAction(Actions.sequence(Actions.delay(2f),Actions.moveBy(400f,0f,0.2f),
             Actions.parallel(  Actions.run(runnable1),Actions.moveBy(600f,0f,0.5f)),
               Actions.moveBy(1400f,0f,0.2f),Actions.run(runnable2)))
    }


    override fun draw() {

        pcController?.hudCard2d?.combate = pcController?.combate!!

        if (pcController?.hudCard2d?.rotate!!) {
            ok?.isVisible = true

            vira?.isVisible = true
            olho?.isVisible = false
        } else {
            ok?.isVisible = false
            no?.isVisible = false
            vira?.isVisible = false
            olho?.isVisible = true
        }

        if (pcController?.escolhaCampo!!) {

            ok?.isVisible = false
            no?.isVisible = true
            vira?.isVisible = false

        }


        if (pcController?.combate!!) {
            no?.isVisible = pcController?.hudCard?.ataque!!

        }

        go?.isVisible = pcController?.combate!!


        if (pcController?.hudCard2d?.cacheButFusion!!) {
            pcController?.hudCard2d?.cacheButFusion = false
            if (pcController?.hudCard2d?.cardDrag != -1) {

                table.addAction(Actions.moveBy(200f, 0f, 0.1f))

            } else {
                table.addAction(Actions.moveBy(-200f, 0f, 0.1f))
            }
        }



        super.draw()


    }


    fun run() {

        ok?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.moveBy(-20f, 0f, 0.5f),
                Actions.moveBy(20f, 0f, 0.5f))))

        vira?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.moveBy(-20f, 0f, 0.5f),
                Actions.moveBy(20f, 0f, 0.5f))))


        no?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.moveBy(20f, 0f, 0.5f),
                Actions.moveBy(-20f, 0f, 0.5f))))

        right?.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {

                if (right?.isChecked!!) {
                    table.addAction(Actions.moveTo(980f, 400f, 0.1f))
                } else {
                    table.addAction(Actions.moveTo(1120f, 400f, 0.1f))

                    pcController?.fusion?.clear()
                    pcController?.hudCard2d?.allNumeberFusinInvisible()
                }

                pcController?.hudCard2d?.isFusion = right?.isChecked!!
            }
        })


        ok?.addListener(object : ClickListener() {

            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                if (pcController?.actived!!) {

                    if (pcController?.mao!!) {
                        pcController?.escolhaCampo = true
                        pcController?.actived = false
                        Camera3d.rotateBy(0f, -80f, 0f, 0.2f)
                        Camera3d.moveTo(0f, 2.8f, -5.8f, 0.2f, object : Camera3d.CallBackMove {
                            override fun complete() {
                                pcController?.pointLight?.set(Color.WHITE, 0f, 6f, -6f, 100f)
                                pcController?.mao = false
                                pcController?.actived = true
                                pcController?.hudCard2d?.rotate = false
                                pcController?.hudCard?.visivle()

                            }

                            override fun runInit(x: Float, y: Float, z: Float) {

                            }
                        })


                    }

                    if (pcController?.escolhaCampo!!) {


                        pcController?.hudCard2d?.location(pcController?.hudCard2d?.array?.get(pcController?.hudCard2d?.thisCard!!)!!)
                        pcController?.hudCard2d?.shadow()



                        for (i in 0 until pcController?.hudCard?.array?.size!!) {

                            val cardHover = pcController?.hudCard?.array?.get(i)

                            cardHover?.addListener(object : ClickListener() {

                                override fun clicked(event: InputEvent?, x: Float, y: Float) {

                                    pcController?.escolhaCampo = false
                                    pcController?.hudCard?.invisivle()


                                    Camera3d.rotateBy(0f, 80f, 0f, 0.2f)
                                    Camera3d.moveTo(0f, 0f, 0f, 0.2f, object : Camera3d.CallBackMove {
                                        override fun complete() {
                                            no?.isVisible = false
                                            pcController?.hudCard2d?.array?.forEach { card2dSmall: Card2dSmall ->

                                                if (pcController?.hudCard2d?.array?.get(pcController?.hudCard2d?.thisCard!!) == card2dSmall) {

                                                    card2dSmall.addAction(Actions.sequence(Actions.moveTo(560f, 405f, 0.2f),
                                                            Actions.run(Runnable {

                                                                particulas2D1?.setType(card2dSmall.card?.guardian1!!)
                                                                particulas2D2?.setType(card2dSmall.card?.guardian2!!)
                                                                particulas2D1?.setPosition(145f, 270f)
                                                                particulas2D2?.setPosition(145f, 130f)

                                                                dialog?.show(this@AndroidController)


                                                                bu1?.addListener(object : ClickListener() {
                                                                    override fun clicked(event: InputEvent?, x: Float, y: Float) {

                                                                        dialog?.hide()

                                                                        runcombate(card2dSmall, i)

                                                                    }
                                                                })

                                                                bu2?.addListener(object : ClickListener() {
                                                                    override fun clicked(event: InputEvent?, x: Float, y: Float) {

                                                                        dialog?.hide()

                                                                        runcombate(card2dSmall, i)
                                                                    }
                                                                })

                                                            })))

                                                } else {
                                                    card2dSmall.addAction(Actions.moveBy(0f, -350f, 0.2f))
                                                }


                                            }

                                        }

                                        override fun runInit(x: Float, y: Float, z: Float) {

                                        }

                                    })
                                    pcController?.pointLight?.set(Color.WHITE, 0f, 2f, -4f, 20f)
                                    pcController?.hudArena?.cards?.addAction(Actions.moveBy(0f, -300f, 0.2f))


                                }


                            })

                        }

                    }


                }
            }

        })


        no?.addListener(object : ClickListener() {

            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                if (pcController?.actived!!) {

                    if (pcController?.escolhaCampo!!) {
                        pcController?.actived = false
                        pcController?.hudCard?.invisivle()
                        Camera3d.rotateBy(0f, 80f, 0f, 0.2f)
                        Camera3d.moveTo(0f, 0f, 0f, 0.2f, object : Camera3d.CallBackMove {
                            override fun complete() {

                                pcController?.mao = true
                                pcController?.actived = true
                                pcController?.escolhaCampo = false
                                pcController?.hudCard2d?.votarTudoOne()

                            }

                            override fun runInit(x: Float, y: Float, z: Float) {

                            }

                        })
                        pcController?.pointLight?.set(Color.WHITE, 0f, 2f, -4f, 20f)

                    }


                }


                if (pcController?.combate!!) {

                    if (pcController?.hudCard?.ataque!!) {
                        pcController?.hudCard?.ataque = false
                        Camera3d.moveBy(0f, 0f, 3.9f, 0.3f)
                        pcController?.hudCard?.arrayCard?.get(pcController?.hudCard?.indexCardAtk!!)
                                ?.addAction(Actions.sequence(Actions.delay(0.17f), Actions.moveBy(0f, 550f, 0.13f)))

                    }

                }


            }

        })

        olho?.addListener(object : ClickListener() {


            override fun clicked(event: InputEvent?, x: Float, y: Float) {

                if (!isOlhoCall) {
                    isOlhoCall = true
                    Camera3d.rotateBy(0f, -80f, 0f, 0.2f)
                    Camera3d.moveTo(0f, 2.8f, -(5.8f + 4f), 0.2f, object : Camera3d.CallBackMove {
                        override fun complete() {


                        }

                        override fun runInit(x: Float, y: Float, z: Float) {

                        }
                    })
                } else if (isOlhoCall) {
                    isOlhoCall = false
                    Camera3d.rotateBy(0f, 80f, 0f, 0.2f)
                    Camera3d.moveTo(0f, 0f, 0f, 0.2f, object : Camera3d.CallBackMove {
                        override fun complete() {


                        }

                        override fun runInit(x: Float, y: Float, z: Float) {

                        }
                    })
                }
            }


        })

    }


    fun runcombate(card2dSmall: Card2dSmall, i: Int) {

        card2dSmall.addAction(Actions.sequence(Actions.moveBy(0f, 500f, 0.5f),
                Actions.run {
                    pcController?.builder3D?.moveToTabuUp(i, Runnable {

                        Camera3d.rotateBy(0f, -80f, 0f, 0.2f)
                        Camera3d.moveTo(0f, 2.8f, -5.8f, 0.2f, object : Camera3d.CallBackMove {
                            override fun complete() {
                                pcController?.pointLight?.set(Color.WHITE, 0f, 6f, -6f, 100f)
                                pcController?.hudCard?.array?.get(i)?.isVisible = false

                                card2dSmall.isTabuLocale = i
                                pcController?.hudCard?.add(card2dSmall)
                                pcController?.hudCard2d?.array?.remove(card2dSmall)
                                pcController?.combate = true
                                pcController?.builder3D!!.isVisible(i, false)
                                val value = pcController?.hudCard?.localeTabu?.get(i)

                                card2dSmall.setPosition(value!![0], value[1])

                            }

                            override fun runInit(x: Float, y: Float, z: Float) {

                            }
                        })

                    })
                }))

    }

}