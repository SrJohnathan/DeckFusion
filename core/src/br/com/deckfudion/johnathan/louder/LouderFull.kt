package br.com.deckfudion.johnathan.louder

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.I18NBundleLoader.I18NBundleParameter
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader
import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.utils.I18NBundle
import java.util.*


class LouderFull {

    companion object {

        val asset = AssetManager()
        var louderCallBack: LoadindAsset? = null


        private var loadind: TextureAtlas? = null
        var card3dSprite: TextureAtlas? = null
        var arenaSprite: TextureAtlas? = null
        var arena: Model? = null

        var card2dBig: TextureAtlas? = null
        var card2dSmall: TextureAtlas? = null
        var iconsMoster: TextureAtlas? = null
        var controllerSprite: TextureAtlas? = null
        var controllerSpriteBig: TextureAtlas? = null

        var setanumero: TextureAtlas? = null






        fun initLouder() {


            asset.setLoader(FreeTypeFontGenerator::class.java, FreeTypeFontGeneratorLoader(InternalFileHandleResolver()))
            asset.setLoader(BitmapFont::class.java, ".ttf", FreetypeFontLoader(InternalFileHandleResolver()))

            generetionOSRegular(Color.WHITE, 25)
            generetionOSRegular(Color.YELLOW, 25)
            generetionOSRegular(Color.ORANGE, 25)
            generetionOSRegular(Color.GREEN, 25)
            generetionOSRegular(Color.CYAN, 25)
            generetionOSRegular(Color.RED, 25)
            generetionOSRegular(Color.PURPLE, 25)
            generetionOSRegular(Color.BLUE, 25)

            generetionOSRegular(Color.WHITE, 30)

            generetionBebas(Color.WHITE, 30)
            generetionBebas(Color.YELLOW, 30)
            generetionBebas(Color.ORANGE, 30)
            generetionBebas(Color.GREEN, 30)
            generetionBebas(Color.RED, 30)
            generetionBebas(Color.PURPLE, 30)
            generetionBebas(Color.BLUE, 30)
            generetionBebas(Color.CYAN, 30)
            generetionBebas(Color.BLACK, 30)


            generetionBebas(Color.WHITE, 18)


            generetionBebasBorder(Color.WHITE, 18)
            generetionBebasBorder(Color.WHITE, 18, Color.CYAN)
            generetionBebasBorder(Color.WHITE, 23)
            generetionBebasBorder(Color.WHITE, 30)
            generetionBebasBorder(Color.WHITE, 35)



            generetionFonTOsBold(Color.WHITE, 20)
            generetionFonTOsBold(Color.WHITE, 30)
            generetionFonTOsBold(Color.WHITE, 40)




            //ROOT
            asset.load("data/language/language", I18NBundle::class.java)


            // HOME
            asset.load("data/wp/logo.jpg", Texture::class.java)


            //MENU
            asset.load("data/wp/fundorootmai.jpg", Texture::class.java)
            asset.load("data/skin/panel.png", Texture::class.java)


            asset.load("data/sprites/card3d/cardtresd.atlas", TextureAtlas::class.java)
            asset.load("data/sprites/arena/hud.atlas", TextureAtlas::class.java)



            asset.load("data/obj/duelo.g3dj", Model::class.java)
            asset.load("data/atlass/cards/small/small.atlas", TextureAtlas::class.java)
            asset.load("data/atlass/cards/bigs/cartasfundoo.atlas", TextureAtlas::class.java)
            asset.load("data/atlass/icones_moster/icon_moster.atlas", TextureAtlas::class.java)
            asset.load("data/atlass/controller/controller.atlas", TextureAtlas::class.java)
            asset.load("data/atlass/controller/controllerbig.atlas", TextureAtlas::class.java)
            asset.load("data/atlass/historia/milenios.atlas", TextureAtlas::class.java)

            asset.load("data/imagens/espada.png", Texture::class.java)
            asset.load("data/imagens/escudo.png", Texture::class.java)
            asset.load("data/imagens/no.png", Texture::class.java)
            asset.load("data/imagens/ok.png", Texture::class.java)
            asset.load("data/imagens/iconrotate.png", Texture::class.java)
            asset.load("data/imagens/iconfu.png", Texture::class.java)
            asset.load("data/imagens/shadow.png", Texture::class.java)
            asset.load("data/imagens/menu.png", Texture::class.java)
            asset.load("data/imagens/card_hover.png", Texture::class.java)
            asset.load("data/imagens/dialog.png", Texture::class.java)
            asset.load("data/imagens/button.png", Texture::class.java)
            asset.load("data/imagens/olho.png", Texture::class.java)
            asset.load("data/imagens/olhoclick.png", Texture::class.java)
            asset.load("data/imagens/goclick.png", Texture::class.java)
            asset.load("data/imagens/go.png", Texture::class.java)
            asset.load("data/imagens/menuarenaclick.png", Texture::class.java)
            asset.load("data/imagens/menuarena.png", Texture::class.java)
            asset.load("data/imagens/progress.png", Texture::class.java)
            asset.load("data/imagens/progressfull.png", Texture::class.java)
            asset.load("data/imagens/duellogo.png", Texture::class.java)
            asset.load("data/imagens/estela.png", Texture::class.java)
            asset.load("data/imagens/espadaicon.png", Texture::class.java)
            asset.load("data/imagens/seta.png", Texture::class.java)
            asset.load("data/imagens/boxmilenio.png", Texture::class.java)
            asset.load("data/imagens/ponto.png", Texture::class.java)
            asset.load("data/imagens/voltaclick.png", Texture::class.java)
            asset.load("data/imagens/volta.png", Texture::class.java)


            asset.load("data/atlass/utill/utiil.atlas", TextureAtlas::class.java)
        }


        fun relouderLanguage(){

            asset.unload("data/language/language")
            asset.update()
            asset.finishLoading()
            asset.load("data/language/language", I18NBundle::class.java)
            asset.update()



        }

        fun get() {

            if (asset.progress == 1.0f) {


                card3dSprite = asset.get("data/sprites/card3d/cardtresd.atlas", TextureAtlas::class.java)
                arenaSprite = asset.get("data/sprites/arena/hud.atlas", TextureAtlas::class.java)
                arena = asset.get("data/obj/duelo.g3dj", Model::class.java)
                card2dSmall = asset.get("data/atlass/cards/small/small.atlas", TextureAtlas::class.java)
                card2dBig = asset.get("data/atlass/cards/bigs/cartasfundoo.atlas", TextureAtlas::class.java)
                iconsMoster = asset.get("data/atlass/icones_moster/icon_moster.atlas", TextureAtlas::class.java)


                controllerSprite = asset.get("data/atlass/controller/controller.atlas", TextureAtlas::class.java)
                controllerSpriteBig = asset.get("data/atlass/controller/controllerbig.atlas", TextureAtlas::class.java)


                setanumero = asset.get("data/atlass/utill/utiil.atlas", TextureAtlas::class.java)






                setanumero?.regions?.forEach { atlasRegion: TextureAtlas.AtlasRegion? -> atlasRegion?.texture?.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)  }
            }


        }


        private fun generetionOSRegular(color: Color, size: Int) {

            val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

            paran.fontFileName = "data/font/os_regular.ttf"

            val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
            //   parameter.magFilter = Texture.TextureFilter.Linear
            //   parameter.minFilter = Texture.TextureFilter.Linear
            parameter.color = color
            parameter.size = size;
            parameter.shadowOffsetX = 0;
            parameter.shadowOffsetY = 0;

            paran.fontParameters = parameter

            asset.load(size.toString() + color.toString() + "data/font/os_regular.ttf", BitmapFont::class.java, paran)

        }

        private fun generetionOsBoldItalic(color: Color, size: Int) {

            val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

            paran.fontFileName = size.toString() + "data/utiil/bold_italic.ttf"

            val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
            //   parameter.magFilter = Texture.TextureFilter.Linear
            //   parameter.minFilter = Texture.TextureFilter.Linear
            parameter.color = color
            parameter.size = size;
            parameter.shadowOffsetX = 0;
            parameter.shadowOffsetY = 0;

            paran.fontParameters = parameter


            asset.load("data/utiil/bold_italic.ttf", BitmapFont::class.java, paran)
        }

        private fun generetionBebas(color: Color, size: Int) {

            val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

            paran.fontFileName = "data/font/bebas.ttf"

            val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
            //   parameter.magFilter = Texture.TextureFilter.Linear
            //    parameter.minFilter = Texture.TextureFilter.Linear
            parameter.color = color
            parameter.size = size;
            parameter.shadowOffsetX = 0;
            parameter.shadowOffsetY = 0;

            paran.fontParameters = parameter

            asset.load(size.toString() + color.toString() + "data/font/bebas.ttf", BitmapFont::class.java, paran)

        }

        private fun generetionBebasBorder(color: Color, size: Int){
            generetionBebasBorder(color, size, Color.BLACK)
        }
        private fun generetionBebasBorder(color: Color, size: Int,border:Color) {

            val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

            paran.fontFileName = "data/font/bebas.ttf"

            val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.magFilter = Texture.TextureFilter.Linear
            parameter.minFilter = Texture.TextureFilter.Linear
            parameter.color = color
            parameter.size = size;
            parameter.shadowOffsetX = 0;
            parameter.shadowOffsetY = 0;
            parameter.borderWidth = 1f
            parameter.spaceX = 1
            parameter.borderColor = border

            paran.fontParameters = parameter

            asset.load("${color.toString()}color${size.toString()}size${border.toString()}data/font/bebas.ttf", BitmapFont::class.java, paran)

        }


        private fun generetionFonTOsBold(color: Color, size: Int) {

            val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

            paran.fontFileName = "data/font/bold.ttf"

            val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
            //  parameter.magFilter = Texture.TextureFilter.Linear
            //   parameter.minFilter = Texture.TextureFilter.Linear
            parameter.color = color
            parameter.size = size;
            parameter.shadowOffsetX = 0;
            parameter.shadowOffsetY = 0;

            paran.fontParameters = parameter

            asset.load(size.toString() + color.toString() + "data/font/bold.ttf", BitmapFont::class.java, paran)


        }

    }

    public interface LoadindAsset {

        fun porce()
    }
}