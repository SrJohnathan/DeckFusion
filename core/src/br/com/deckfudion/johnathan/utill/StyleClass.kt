package br.com.deckfudion.johnathan.utill

import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.ui.List
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable
import com.badlogic.gdx.utils.Align

class StyleClass {


    companion object {




        fun olhoButton(): ImageButton.ImageButtonStyle {

            val value = ImageButton.ImageButtonStyle()
            value.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/olho.png", Texture::class.java))
            value.imageDown = TextureRegionDrawable(LouderFull.asset.get("data/imagens/olhoclick.png", Texture::class.java))

            return value
        }

        fun goButton(): ImageButton.ImageButtonStyle {

            val value = ImageButton.ImageButtonStyle()
            value.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/go.png", Texture::class.java))
            value.imageDown = TextureRegionDrawable(LouderFull.asset.get("data/imagens/goclick.png", Texture::class.java))
            return value
        }

        fun voltaButton(): ImageButton.ImageButtonStyle {

            val value = ImageButton.ImageButtonStyle()
            value.imageUp = TextureRegionDrawable(LouderFull.asset.get("data/imagens/volta.png", Texture::class.java))
            value.imageDown = TextureRegionDrawable(LouderFull.asset.get("data/imagens/voltaclick.png", Texture::class.java))
            return value
        }

        fun menuButton(louderArena: LouderArena): ImageButton.ImageButtonStyle {

            val value = ImageButton.ImageButtonStyle()
            value.imageUp =   TextureRegionDrawable(louderArena.assetI.get("data/skin/resume_normal.png",Texture::class.java))
            value.imageDown = TextureRegionDrawable(louderArena.assetI.get("data/skin/resume_pressed.png",Texture::class.java))
            return value
        }

        fun enigmaProgress(): ProgressBar.ProgressBarStyle {

            val v = TiledDrawable(TextureRegionDrawable(LouderFull.asset.get("data/imagens/progress.png", Texture::class.java)))
            val t = TiledDrawable(TextureRegionDrawable(LouderFull.asset.get("data/imagens/progressfull.png", Texture::class.java)))

            val pro =  ProgressBar.ProgressBarStyle()
            pro.knob = v
            pro.knobBefore = t
            return pro
        }


        fun listDeck():List.ListStyle{

            val styleClass = List.ListStyle()

            styleClass.font = Label("00", TextLouder.styleBebasBorder(Color.WHITE, 23)).style.font




            return  styleClass
        }


        fun button(): TextButton.TextButtonStyle {

            val value = TextButton.TextButtonStyle()
            value.font = TextLouder.styleFontInitOsRegularBold(Color.WHITE, 20).font
            value.up = TextureRegionDrawable(LouderFull.asset.get("data/imagens/button.png", Texture::class.java))
            return value
        }


        fun voltaButtonAzul(): TextButton.TextButtonStyle {

            val value = TextButton.TextButtonStyle()
            value.font = TextLouder.styleBebasBorder(Color.WHITE, 23).font
            value.up = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/button1.png", Texture::class.java))
            return value
        }

        fun voltaButtonVermelgo(): TextButton.TextButtonStyle {

            val value = TextButton.TextButtonStyle()
            value.font = TextLouder.styleBebasBorder(Color.WHITE, 23).font
            value.up = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/button2.png", Texture::class.java))
            return value
        }

        fun voltaButtonVerde(): TextButton.TextButtonStyle {

            val value = TextButton.TextButtonStyle()
            value.font = TextLouder.styleBebasBorder(Color.WHITE, 23).font
            value.up = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/button3.png", Texture::class.java))
            return value
        }


        fun voltaButtonEditor(): CheckBox.CheckBoxStyle {

            val value = CheckBox.CheckBoxStyle()
            value.font = TextLouder.styleBebasBorder(Color.WHITE, 23).font
            value.checkboxOff = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/buttons.png", Texture::class.java))
            value.checkboxOn = TextureRegionDrawable(LouderExternal.asset.get("/gameData/imagens/buttonsati.png", Texture::class.java))
            return value
        }


        fun textCheckBox(text:String, name:String): CheckBox{


            val check = CheckBox("", voltaButtonEditor())
            val text = Label(text,TextLouder.styleBebasBorder(Color.WHITE, 23))

            check.width = 80f
            check.height = 80f

            check.name = name

            text.setAlignment(Align.center)
            text.setPosition(15f,20f)

            check.addActor(text)


            return  check;
        }
    }

}