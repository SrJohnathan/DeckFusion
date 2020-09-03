package br.com.deckfudion.johnathan.custon


import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.ParticleEffect
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor


class Particulas2D(type:Int) :Actor() {

    var acc = Vector2()

    companion object{
        val LUZ = 0
        val TREVAS = 1
        val RADIACAO = 2
        val FIRE = 3
        val PLANTA = 4
        val VENTO = 5
        val FORCA = 6
        val TERRA = 7
        val RAIO= 8
        val AGUA = 9


    }


    var fire :ParticleEffect? = null


    init {

        fire = ParticleEffect()

        when(type){

            LUZ ->{
                fire?.load(Gdx.files.external("gameData/particulas/luz.p"), Gdx.files.external("gameData/particulas"))
            }

            TREVAS ->{
                fire?.load(Gdx.files.external("gameData/particulas/trevas.p"), Gdx.files.external("gameData/particulas"))
            }

            RADIACAO ->{
                fire?.load(Gdx.files.external("gameData/particulas/radi.p"), Gdx.files.external("gameData/particulas"))
            }

            FIRE ->{
                fire?.load(Gdx.files.external("gameData/particulas/fire.p"), Gdx.files.external("gameData/particulas"))
            }

            PLANTA ->{
                fire?.load(Gdx.files.external("gameData/particulas/folha.p"), Gdx.files.external("gameData/particulas"))
            }

            VENTO ->{
                fire?.load(Gdx.files.external("gameData/particulas/vento.p"), Gdx.files.external("gameData/particulas"))
            }

            FORCA ->{
                fire?.load(Gdx.files.external("gameData/particulas/forca.p"), Gdx.files.external("gameData/particulas"))
            }

            TERRA ->{
                fire?.load(Gdx.files.external("gameData/particulas/terra.p"), Gdx.files.external("gameData/particulas"))
            }

            RAIO ->{
                fire?.load(Gdx.files.external("gameData/particulas/raio.p"), Gdx.files.external("gameData/particulas"))
            }
            AGUA ->{
                fire?.load(Gdx.files.external("gameData/particulas/agua.p"), Gdx.files.external("gameData/particulas"))
            }

        }

        fire?.start()
    }



    fun setType(type: Int){

        when(type){

            LUZ ->{
                fire?.load(Gdx.files.external("gameData/particulas/luz.p"), Gdx.files.external("gameData/particulas"))
            }

            TREVAS ->{
                fire?.load(Gdx.files.external("gameData/particulas/trevas.p"), Gdx.files.external("gameData/particulas"))
            }

            RADIACAO ->{
                fire?.load(Gdx.files.external("gameData/particulas/radi.p"), Gdx.files.external("gameData/particulas"))
            }

            FIRE ->{
                fire?.load(Gdx.files.external("gameData/particulas/fire.p"), Gdx.files.external("gameData/particulas"))
            }

            PLANTA ->{
                fire?.load(Gdx.files.external("gameData/particulas/folha.p"), Gdx.files.external("gameData/particulas"))
            }

            VENTO ->{
                fire?.load(Gdx.files.external("gameData/particulas/vento.p"), Gdx.files.external("gameData/particulas"))
            }

            FORCA ->{
                fire?.load(Gdx.files.external("gameData/particulas/forca.p"), Gdx.files.external("gameData/particulas"))
            }

            TERRA ->{
                fire?.load(Gdx.files.external("gameData/particulas/terra.p"), Gdx.files.external("gameData/particulas"))
            }

            RAIO ->{
                fire?.load(Gdx.files.external("gameData/particulas/raio.p"), Gdx.files.external("gameData/particulas"))
            }
            AGUA ->{
                fire?.load(Gdx.files.external("gameData/particulas/agua.p"), Gdx.files.external("gameData/particulas"))
            }

        }

        fire?.start()
    }

    override fun setPosition(x: Float, y: Float) {
        fire?.emitters?.forEach {
            it.setPosition(x, y)
        }
    }


    override fun draw(batch: Batch?, parentAlpha: Float) {
        if(isVisible) {
            fire?.draw(batch)
        }
    }


    override fun act(delta: Float) {
        super.act(delta);
        acc.set(getWidth()/2, getHeight()/2);
        localToStageCoordinates(acc);
        fire?.update(delta)


    }


    fun start() {
        fire?.start()
    }

    fun allowCompletion() {
        fire?.allowCompletion()
    }

}


