package br.com.deckfudion.johnathan.utill

import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label

class TextLouder {


    companion object{


        fun styleFontDigital(louderArena: LouderArena,color: Color, size:Int): Label.LabelStyle {

            val   font =  louderArena.assetI.get(size.toString() + color.toString() + "data/font/digital.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }


        fun styleFontInitOsRegular(color: Color, size:Int): Label.LabelStyle {

            val   font =  LouderFull.asset.get(size.toString() +color.toString() + "data/font/os_regular.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }

        fun styleFontInitOsRegularBold(color: Color, size:Int): Label.LabelStyle {

            val   font =  LouderFull.asset.get(size.toString() + color.toString() + "data/font/bold.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }


        fun styleBebas(color: Color, size:Int): Label.LabelStyle {

            val   font =  LouderFull.asset.get(size.toString() +color.toString() + "data/font/bebas.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }

        fun styleBebasBorder(color: Color, size: Int): Label.LabelStyle {
           return styleBebasBorder(color, size, Color.BLACK)
        }
        fun styleBebasBorder(color: Color, size: Int,border:Color): Label.LabelStyle {

            val   font =  LouderFull.asset.get("${color.toString()}color${size.toString()}size${border.toString()}data/font/bebas.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }

    }

}