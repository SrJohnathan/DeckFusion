package com.aj.johnathan.yugi.hud

import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.utill.StyleClass
import br.com.deckfudion.johnathan.utill.TextLouder

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.Viewport


class MapHud(batch: Batch, viewport: Viewport) : Stage(viewport, batch) {

    var stage: Stage? = null


    private var rootTable: Table? = null
    private var rootTable2: Table? = null
    private var estrela: Sprite? = null
    private var espada: Sprite? = null

    var labelestelas: Label? = null
    var labelespada: Label? = null


    var nameperson: Label? = null
    var capitulo: Label? = null

  //  var menu: ImageButton? = null
    var volta: ImageButton? = null


    init {


     //   menu = ImageButton(StyleClass.menuButton())
        volta = ImageButton(StyleClass.voltaButton())


        //  avisoPerson = AvisoPerson(viewport!!, sb.avisoBatch, AtlasLouder.buttons!!)


        val testre = LouderFull.asset.get("data/imagens/estela.png", Texture::class.java)
        val tespa = LouderFull.asset.get("data/imagens/espadaicon.png", Texture::class.java)
        val tseta = LouderFull.asset.get("data/imagens/seta.png", Texture::class.java)

        testre.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        estrela = Sprite(testre)

        tespa.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        espada = Sprite(tespa)


        tseta.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);




        capitulo = Label("Capítulo Satuário do Céu", TextLouder.styleBebasBorder(Color.WHITE, 35))


        labelespada = Label("01/07", TextLouder.styleBebasBorder(Color.WHITE, 23))
        labelestelas = Label("1", TextLouder.styleBebasBorder(Color.WHITE, 23))
        nameperson = Label("Vovo Yugi", TextLouder.styleBebas(Color.WHITE, 30))


        val ta1 = Table()
        val ta2 = Table()

        val boxmilenio = Table()

        val box = LouderFull.asset.get("data/imagens/boxmilenio.png", Texture::class.java)
        box.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        boxmilenio.background = TextureRegionDrawable(box)


        val bu = ButtonMilenios()

        boxmilenio.add(bu.anel).padLeft(30f)
        boxmilenio.add(bu.enigma).padLeft(25f)
        boxmilenio.add(bu.olho).padLeft(20f)
        boxmilenio.add(bu.colar).expandX()
        boxmilenio.add(bu.varinha).padRight(20f)
        boxmilenio.add(bu.chave).padRight(25f)
        boxmilenio.add(bu.balanca).padRight(30f)


        val es = Image(estrela?.texture!!)
        val ep = Image(espada?.texture!!)
        es.setSize(10f, 10f)
        ep.setSize(10f, 10f)

        ta2.add(es)
        ta2.add(labelestelas)
        ta2.add(ep)
        ta2.add(labelespada)









        ta1.row()

        //  ta1.add(seta)

        val pixmap = Pixmap(20, 20, Pixmap.Format.RGBA8888);
        val cor = Color(Color.valueOf("000058"))
        cor.a = 0.8f
        pixmap.setColor(cor)
        pixmap.fill();
        ta1.background = TextureRegionDrawable(Texture(pixmap))
        ta1.pad(5f)


        val tablecapi = Table()

        val tableTitle = Table()
        tableTitle.add(capitulo)
        tableTitle.row()
        tableTitle.add(ta2)
        tableTitle.row()

        tableTitle.background = TextureRegionDrawable(tseta)



        tablecapi.add(volta).left().padTop(10f).padLeft(10f).expandX()
        tablecapi.add(tableTitle).padTop(10f).expandX()
      //  tablecapi.add(menu).right().padTop(10f).padRight(10f).expandX()


        pixmap.dispose()


        rootTable = Table()
        rootTable?.top()
        rootTable?.setFillParent(true)
        rootTable?.add(tablecapi)!!.center().expandX().fillX()


        rootTable2 = Table()
        rootTable2?.bottom()
        rootTable2?.setFillParent(true)

        rootTable2?.add(boxmilenio)?.bottom()?.right()?.expandX()!!.padBottom(10f).padRight(10f)


        addActor(rootTable)
        addActor(rootTable2)



        nameperson?.setPosition(600f, 320f)


    }


    internal class ButtonMilenios {

        var anel: CheckBox? = null
        var chave: CheckBox? = null
        var varinha: CheckBox? = null
        var colar: CheckBox? = null
        var balanca: CheckBox? = null
        var olho: CheckBox? = null
        var enigma: CheckBox? = null

        val toggle = ButtonGroup<CheckBox>()
        val array = arrayListOf<CheckBox?>()

        init {


            val anelStyle = CheckBox.CheckBoxStyle()
            anelStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            anelStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("aneld"))
            anelStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("anel"))

            val olhoStyle = CheckBox.CheckBoxStyle()
            olhoStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            olhoStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("olhod"))
            olhoStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("olho"))


            val varinhaStyle = CheckBox.CheckBoxStyle()
            varinhaStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            varinhaStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("varinhad"))
            varinhaStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("varinha"))


            val colarStyle = CheckBox.CheckBoxStyle()
            colarStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            colarStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("colard"))
            colarStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("colar"))

            val balancaStyle = CheckBox.CheckBoxStyle()
            balancaStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            balancaStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("balancad"))
            balancaStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("balanca"))


            val chaveStyle = CheckBox.CheckBoxStyle()
            chaveStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            chaveStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("chaved"))
            chaveStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("chave"))


            val enigmaStyle = CheckBox.CheckBoxStyle()
            enigmaStyle.font = TextLouder.styleBebas(Color.WHITE, 30).font
            enigmaStyle.checkboxOff = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("enigmad"))
            enigmaStyle.checkboxOn = TextureRegionDrawable(LouderFull.asset.get("data/atlass/historia/milenios.atlas", TextureAtlas::class.java).findRegion("enigma"))




            anel = CheckBox("", anelStyle)
            chave = CheckBox("", chaveStyle)
            varinha = CheckBox("", varinhaStyle)
            colar = CheckBox("", colarStyle)
            balanca = CheckBox("", balancaStyle)
            olho = CheckBox("", olhoStyle)
            enigma = CheckBox("", enigmaStyle)


            toggle.add(anel)
            toggle.add(chave)
            toggle.add(varinha)
            toggle.add(colar)
            toggle.add(balanca)
            toggle.add(olho)
            toggle.add(enigma)

            array.add(anel)
            array.add(chave)
            array.add(varinha)
            array.add(colar)
            array.add(balanca)
            array.add(olho)
            array.add(enigma)



            array.forEach { checkBox: CheckBox? ->

                checkBox?.addListener(object : ChangeListener() {
                    override fun changed(event: ChangeEvent?, actor: Actor?) {

                        if (checkBox.isChecked) {
                        }


                        LouderExternal.milenio?.play()
                    }
                })

            }

        }


    }


}