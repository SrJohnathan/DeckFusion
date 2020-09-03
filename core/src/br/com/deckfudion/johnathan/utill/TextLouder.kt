package br.com.deckfudion.johnathan.utill

import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label

class TextLouder {


    companion object{

        fun styleFontInitOsRegular(color: Color, size:Int): Label.LabelStyle {

            val   font =  LouderFull.asset.get(size.toString() +color.toString() + "data/font/os_regular.ttf", BitmapFont::class.java)
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

        fun styleBebasBorder(color: Color, size:Int): Label.LabelStyle {

            val   font =  LouderFull.asset.get(size.toString() +color.toString() + "bodata/font/bebas.ttf", BitmapFont::class.java)
            val style = Label.LabelStyle()
            style.font = font
            return style
        }

    }

}