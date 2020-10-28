package br.com.deckfudion.johnathan.louder

import br.com.deckfudion.johnathan.utill.CallLouder
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem

class LouderArena {


    var asset = AssetManager(ExternalFileHandleResolver())
    var assetp = AssetManager(ExternalFileHandleResolver())
    var assetI = AssetManager()
    private var isupdate = false

    private var callLouder: CallLouder? = null






    fun initLouder(particleSys: ParticleSystem) {
        setParticlesBiilborad(particleSys)
    }


    fun init() {

        assetI.setLoader(FreeTypeFontGenerator::class.java, FreeTypeFontGeneratorLoader(InternalFileHandleResolver()))
        assetI.setLoader(BitmapFont::class.java, ".ttf", FreetypeFontLoader(InternalFileHandleResolver()))

        generetionFontDigital(Color.WHITE,27)

        val file =  Gdx.files.internal("data/skin/")
        file.list().forEach { fileHandle ->
            assetI.load(fileHandle.path(), Texture::class.java)

        }


    }

    fun get(callLouder: CallLouder) {
        this.callLouder = callLouder

    }

    fun update(delta:Float) {

        if (isupdate) {

            assetI.update()
            asset.update()
            if (assetp.isFinished && assetp.progress == 1.0f ) {
                isupdate = false


                if (callLouder != null) {
                    callLouder?.call()
                }

            }
        }

    }

    fun setParticlesBiilborad(particleSys: ParticleSystem) {


        val pame = ParticleEffectLoader.ParticleEffectLoadParameter(particleSys.batches)

        assetp.load("/gameData/particulas/dominiotrevas.pfx", ParticleEffect::class.java, pame)


        isupdate = true
    }


    private fun generetionFontDigital(color: Color, size: Int) {

        val paran = FreetypeFontLoader.FreeTypeFontLoaderParameter()

        paran.fontFileName = "data/font/digitalit.ttf"

        val co = Color(color)



        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
          parameter.magFilter = Texture.TextureFilter.Linear
           parameter.minFilter = Texture.TextureFilter.Linear
        parameter.color = co
        parameter.size = size;
        parameter.spaceX = 2
        parameter.shadowOffsetX = 0;
        parameter.shadowOffsetY = 0;

        paran.fontParameters = parameter

        assetI.load(size.toString() + color.toString() + "data/font/digital.ttf", BitmapFont::class.java, paran)


    }
}