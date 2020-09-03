package br.com.deckfudion.johnathan.custon


import br.com.deckfudion.johnathan.libs.scene3d.Actor3d
import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderExternal
import com.badlogic.gdx.graphics.g3d.Environment
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.particles.ParticleController
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.math.Quaternion
import com.badlogic.gdx.math.Vector3

class Particles3D() {

    class Exploser(var sys: ParticleSystem, louder: LouderArena) : Actor3d() {

        var particle: ParticleEffect? = null
      var  environment: Environment? = null


        init {


            particle = louder.asset.get("/gameData/particulas/dominiotrevas.pfx", ParticleEffect::class.java).copy()

            environment = Environment()
            val pScale = 0.2f
            environment?.set(ColorAttribute(ColorAttribute.AmbientLight,
                    1f, 1f, 1f, 1f))



            setScale(1.5f)
            setPosition(0f,-2.2f,-8f)


            sys.add(particle)




            particle?.init()

        }


        override fun dispose() {

            particle?.dispose()


            super.dispose()
        }



        override fun draw(modelBatch: ModelBatch?, environment: Environment?) {




            sys.begin();
            sys.draw()
            sys.end();
            modelBatch?.render(sys,this.environment)



        }


        override fun act(delta: Float) {

            particle?.setTransform(getTransform())

            particle?.update(delta/5)




        }



    }

}