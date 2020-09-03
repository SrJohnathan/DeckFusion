package br.com.deckfudion.johnathan.card

import br.com.deckfudion.johnathan.libs.scene3d.Actor3d
import br.com.deckfudion.johnathan.libs.scene3d.Stage3d
import br.com.deckfudion.johnathan.libs.scene3d.actions.Actions3d
import com.badlogic.gdx.Gdx

class BuilderCard3d(var stage3d: Stage3d) {

    var mycard3d1up = Actor3d(Card3d())
    var mycard3d2up = Actor3d(Card3d())
    var mycard3d3up = Actor3d(Card3d())
    var mycard3d4up = Actor3d(Card3d())
    var mycard3d5up = Actor3d(Card3d())

    var mycard3d1bk = Actor3d(Card3d())
    var mycard3d2bk = Actor3d(Card3d())
    var mycard3d3bk = Actor3d(Card3d())
    var mycard3d4bk = Actor3d(Card3d())
    var mycard3d5bk = Actor3d(Card3d())

    var opcard3d1up = Actor3d(Card3d())
    var opcard3d2up = Actor3d(Card3d())
    var opcard3d3up = Actor3d(Card3d())
    var opcard3d4up = Actor3d(Card3d())
    var opcard3d5up = Actor3d(Card3d())

    var opcard3d1bk = Actor3d(Card3d())
    var opcard3d2bk = Actor3d(Card3d())
    var opcard3d3bk = Actor3d(Card3d())
    var opcard3d4bk = Actor3d(Card3d())
    var opcard3d5bk = Actor3d(Card3d())

    init {

        mycard3d1up.addAction3d(Actions3d.moveTo(-2.4099992f, 4f, -5.9999976f, 0f))
        mycard3d2up.addAction3d(Actions3d.moveTo(-1.2099992f, 4f, -5.9999976f, 0f))
        mycard3d3up.addAction3d(Actions3d.moveTo(0f, 4f, -5.9999976f, 0f))
        mycard3d4up.addAction3d(Actions3d.moveTo(1.2099992f, 4f, -5.9999976f, 0f))
        mycard3d5up.addAction3d(Actions3d.moveTo(2.4099992f, 4f, -5.9999976f, 0f))

        mycard3d1bk.addAction3d(Actions3d.moveTo(-2.4099992f, 4f, -3.9999976f, 0f))
        mycard3d2bk.addAction3d(Actions3d.moveTo(-1.2099992f, 4f, -3.9999976f, 0f))
        mycard3d3bk.addAction3d(Actions3d.moveTo(0f, 4f, -3.9999976f, 0f))
        mycard3d4bk.addAction3d(Actions3d.moveTo(1.2099992f, 4f, -3.9999976f, 0f))
        mycard3d5bk.addAction3d(Actions3d.moveTo(2.4099992f, 4f, -3.9999976f, 0f))


        stage3d.addActor3d(mycard3d1up)
        stage3d.addActor3d(mycard3d2up)
        stage3d.addActor3d(mycard3d3up)
        stage3d.addActor3d(mycard3d4up)
        stage3d.addActor3d(mycard3d5up)


        stage3d.addActor3d(mycard3d1bk)
        stage3d.addActor3d(mycard3d2bk)
        stage3d.addActor3d(mycard3d3bk)
        stage3d.addActor3d(mycard3d4bk)
        stage3d.addActor3d(mycard3d5bk)


        opcard3d1up.addAction3d(Actions3d.moveTo(2.4099992f, 4f, -9.9999952f, 0f))
        opcard3d2up.addAction3d(Actions3d.moveTo(1.2099992f, 4f, -9.9999952f, 0f))
        opcard3d3up.addAction3d(Actions3d.moveTo(0f, 4f, -9.9999952f, 0f))
        opcard3d4up.addAction3d(Actions3d.moveTo(-1.2099992f, 4f, -9.9999952f, 0f))
        opcard3d5up.addAction3d(Actions3d.moveTo(-2.4099992f, 4f, -9.9999952f, 0f))



        opcard3d1bk.addAction3d(Actions3d.moveTo(2.4099992f, 4f, 11.2999952f, 0f))
        opcard3d2bk.addAction3d(Actions3d.moveTo(1.2099992f, 4f, 11.2999952f, 0f))
        opcard3d3bk.addAction3d(Actions3d.moveTo(0f, 4f, 11.2999952f, 0f))
        opcard3d4bk.addAction3d(Actions3d.moveTo(-1.2099992f, 4f, 11.2999952f, 0f))
        opcard3d5bk.addAction3d(Actions3d.moveTo(-2.4099992f, 4f, 11.2999952f, 0f))



        stage3d.addActor3d(opcard3d1up)
        stage3d.addActor3d(opcard3d2up)
        stage3d.addActor3d(opcard3d3up)
        stage3d.addActor3d(opcard3d4up)
        stage3d.addActor3d(opcard3d5up)


        stage3d.addActor3d(opcard3d1bk)
        stage3d.addActor3d(opcard3d2bk)
        stage3d.addActor3d(opcard3d3bk)
        stage3d.addActor3d(opcard3d4bk)
        stage3d.addActor3d(opcard3d5bk)



        Thread(Runnable {

            Thread.sleep(3000)

            Gdx.app.postRunnable(Runnable {
/*

                for (l in 0 until  array!!.size){
                    array?.get(l)?.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                }



                array?.get(0)?.addAction3d(Actions3d.moveTo(-2.4099992f, -1.9000005f, -5.9999976f, 0.5f))
                array?.get(1)?.addAction3d(Actions3d.moveTo(-1.2099992f, -1.9000005f, -5.9999976f, 0.5f))
                array?.get(2)?.addAction3d(Actions3d.moveTo(0f, -1.9000005f, -5.9999976f, 0.5f))
                array?.get(3)?.addAction3d(Actions3d.moveTo(1.2099992f, -1.9000005f, -5.9999976f, 0.5f))
                array?.get(4)?.addAction3d(Actions3d.moveTo(2.4099992f, -1.9000005f, -5.9999976f, 0.5f))

                */



                mycard3d1up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d2up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d3up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d4up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d5up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))

                mycard3d1bk.addAction3d(Actions3d.moveTo(-2.4099992f, -1.9000005f, -4.6f, 0.5f))
                mycard3d2bk.addAction3d(Actions3d.moveTo(-1.2099992f, -1.9000005f, -4.6f, 0.5f))
                mycard3d3bk.addAction3d(Actions3d.moveTo(0f, -1.9000005f, -4.6f, 0.5f))
                mycard3d4bk.addAction3d(Actions3d.moveTo(1.2099992f, -1.9000005f, -4.6f, 0.5f))
                mycard3d5bk.addAction3d(Actions3d.moveTo(2.4099992f, -1.9000005f, -4.6f, 0.5f))

                mycard3d1bk.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d2bk.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d3bk.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d4bk.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
                mycard3d5bk.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))













                opcard3d1up.addAction3d(Actions3d.moveTo(2.4099992f, -1.9000005f, -9.9999952f, 0.5f))
                opcard3d2up.addAction3d(Actions3d.moveTo(1.2099992f, -1.9000005f, -9.9999952f, 0.5f))
                opcard3d3up.addAction3d(Actions3d.moveTo(0f, -1.9000005f, -9.9999952f, 0.5f))
                opcard3d4up.addAction3d(Actions3d.moveTo(-1.2099992f, -1.9000005f, -9.9999952f, 0.5f))
                opcard3d5up.addAction3d(Actions3d.moveTo(-2.4099992f, -1.9000005f, -9.9999952f, 0.5f))


                opcard3d1up.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d2up.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d3up.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d4up.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d5up.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))








                opcard3d1bk.addAction3d(Actions3d.moveTo(2.4099992f, -1.9000005f, -11.2999952f, 0.5f))
                opcard3d2bk.addAction3d(Actions3d.moveTo(1.2099992f, -1.9000005f, -11.2999952f, 0.5f))
                opcard3d3bk.addAction3d(Actions3d.moveTo(0f, -1.9000005f, -11.2999952f, 0.5f))
                opcard3d4bk.addAction3d(Actions3d.moveTo(-1.2099992f, -1.9000005f, -11.2999952f, 0.5f))
                opcard3d5bk.addAction3d(Actions3d.moveTo(-2.4099992f, -1.9000005f, -11.2999952f, 0.5f))



                opcard3d1bk.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d2bk.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d3bk.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d4bk.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))
                opcard3d5bk.addAction3d(Actions3d.rotateBy(0f, 90f, 0f, 0.5f))


            })

        })
    }


    fun draw(delta:Float){



    }


    fun isVisible(id: Int,visible:Boolean){

        when (id) {


            0 -> {
                mycard3d1up.isVisible = visible

            }
            1 -> {
                mycard3d2up.isVisible = visible
            }
            2 -> {
                mycard3d3up.isVisible = visible
            }
            3 -> {
                mycard3d4up.isVisible = visible
            }
            4 -> {
                mycard3d5up.isVisible = visible
            }

        }
    }



    fun moveToTabuUp(id: Int,runnable: Runnable) {



        when (id) {


            0 -> {
                mycard3d1up.addAction3d(Actions3d.sequence(Actions3d.moveTo(-2.2509992f, -1.9000005f, -5.8999976f, 0.6f),Actions3d.run(runnable)))
                mycard3d1up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.6f))

            }
            1 -> {
                mycard3d2up.addAction3d(Actions3d.sequence(Actions3d.moveTo(-1.2099992f, -1.9000005f, -5.8999976f, 0.6f),Actions3d.run(runnable)))
                mycard3d2up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.6f))
            }
            2 -> {
                mycard3d3up.addAction3d(Actions3d.sequence(Actions3d.moveTo(0f, -1.9000005f, -5.8999976f, 0.6f),Actions3d.run(runnable)))
                mycard3d3up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.6f))
            }
            3 -> {
                mycard3d4up.addAction3d(Actions3d.sequence(Actions3d.moveTo(1.2099992f, -1.9000005f, -5.8999976f, 0.6f),Actions3d.run(runnable)))
                mycard3d4up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.6f))
            }
            4 -> {
                mycard3d5up.addAction3d(Actions3d.sequence(Actions3d.moveTo(2.2509992f, -1.9000005f, -5.8999976f, 0.5f),Actions3d.run(runnable)))
                mycard3d5up.addAction3d(Actions3d.rotateBy(-180f, 90f, 0f, 0.5f))
            }

        }

    }
}