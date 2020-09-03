package br.com.deckfudion.johnathan.louder

import br.com.deckfudion.johnathan.Main
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem
import com.badlogic.gdx.utils.JsonValue


class LouderExternal {


    companion object {


        private var verific = false;
        var asset = AssetManager(ExternalFileHandleResolver())

        var assetLocal = AssetManager()


        var jsonCards: JsonValue? = null
        var cardsTextures: TextureAtlas? = null
        var turno: Sound? = null
        var duel: Sound? = null

        var milenio: Sound? = null


        var imgImageDeck: Texture? = null
        var imgImageItens: Texture? = null
        var imgItens: Texture? = null

        @JvmStatic
        fun initLouder() {


            asset.setLoader(JsonValue::class.java, JsonLouder(ExternalFileHandleResolver()))
            asset.setLoader(ParticleEffect::class.java, ParticleEffectLoader(ExternalFileHandleResolver()))


            asset.load("/gameData/json/mycardscripty.json", JsonValue::class.java)
            asset.load("/gameData/cards/cards.atlas", TextureAtlas::class.java)
            asset.load("/gameData/som/nextturn.wav", Sound::class.java)
            asset.load("/gameData/som/duel.wav", Sound::class.java)
            asset.load("/gameData/som/milenio.ogg", Sound::class.java)


            Gdx.files.external("/gameData/imagens/").list().forEach { fileHandle: FileHandle? ->

                asset.load(fileHandle?.path(), Texture::class.java)

            }

        }


        fun get() {


            if (asset.progress == 1.0f) {


                jsonCards = asset.get("/gameData/json/mycardscripty.json", JsonValue::class.java)
                cardsTextures = asset.get("/gameData/cards/cards.atlas", TextureAtlas::class.java)
                turno = asset.get("/gameData/som/nextturn.wav", Sound::class.java)
                duel = asset.get("/gameData/som/duel.wav", Sound::class.java)
                milenio = asset.get("/gameData/som/milenio.ogg", Sound::class.java)

                imgImageDeck = asset.get("/gameData/imagens/torre.jpg", Texture::class.java)
                imgImageItens = asset.get("/gameData/imagens/deck_itens.png", Texture::class.java)
              imgItens =  asset.get("/gameData/imagens/item.png", Texture::class.java)


            }


        }

        @JvmStatic
        fun dispose() {
            milenio?.dispose()
            duel?.dispose()
            cardsTextures?.dispose()


        }


    }


}