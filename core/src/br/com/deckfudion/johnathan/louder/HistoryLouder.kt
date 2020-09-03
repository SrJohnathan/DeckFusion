package br.com.deckfudion.johnathan.louder

import br.com.deckfudion.johnathan.utill.CallLouder
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas

class HistoryLouder {


    var callLouder: CallLouder? = null
    var isfinishi = false

    val internall = AssetManager()
    val external = AssetManager(ExternalFileHandleResolver())


    fun init() {


        external.load("/gameData/opponents/opponets.atlas", TextureAtlas::class.java)
        external.load("/gameData/opponents/icone_camp.atlas", TextureAtlas::class.java)
        external.load("/gameData/opponents/gemas.atlas", TextureAtlas::class.java)




        val file =  Gdx.files.external("/gameData/camps/")
        file.list().forEach { fileHandle ->

            external.load(fileHandle.path(), Texture::class.java)

        }


    }


    fun update() {


        if (!isfinishi) {
            internall.update()
            external.update()
            if (internall.isFinished && external.isFinished) {
                isfinishi = true

                callLouder?.call()

            }
        }
    }

    fun  unload(){

        external.assetNames.forEach { s: String? ->

            external.unload(s)
        }
    }


}