package br.com.deckfudion.johnathan.louder

import br.com.deckfudion.johnathan.utill.CallLouder
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem

class LouderArena {


    var asset = AssetManager(ExternalFileHandleResolver())
    private var isupdate = false

    private var callLouder: CallLouder? = null

    fun initLouder(particleSys: ParticleSystem) {


        setParticlesBiilborad(particleSys)

    }


    fun get(callLouder: CallLouder) {
        this.callLouder = callLouder

    }


    fun update(delta:Float) {

        if (isupdate) {

            asset.update()
            if (asset.isFinished && asset.progress == 1.0f) {
                isupdate = false


                if (callLouder != null) {
                    callLouder?.call()
                }

            }
        }

    }

    fun setParticlesBiilborad(particleSys: ParticleSystem) {


        val pame = ParticleEffectLoader.ParticleEffectLoadParameter(particleSys.batches)

        asset.load("/gameData/particulas/dominiotrevas.pfx", ParticleEffect::class.java, pame)


        isupdate = true
    }

}