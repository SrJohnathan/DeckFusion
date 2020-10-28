package br.com.deckfudion.johnathan.louder

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound

class LouderSound {


    companion object {

        val asset = AssetManager()
        var click: Sound? = null

        fun init() {

            asset.load("data/som/click.wav", Sound::class.java)


        }


        fun get() {
            click = asset.get("data/som/click.wav", Sound::class.java)

        }

    }


}







