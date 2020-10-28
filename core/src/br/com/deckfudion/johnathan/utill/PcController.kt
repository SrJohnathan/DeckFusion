package br.com.deckfudion.johnathan.utill

import br.com.deckfudion.johnathan.card.BuilderCard3d
import br.com.deckfudion.johnathan.hud.HudArena
import br.com.deckfudion.johnathan.hud.HudCard
import br.com.deckfudion.johnathan.hud.HudCard2d
import br.com.deckfudion.johnathan.libs.scene3d.Camera3d
import br.com.deckfudion.johnathan.libs.scene3d.camera.Actions
import br.com.deckfudion.johnathan.libs.scene3d.camera.CameraMoveCircular
import br.com.deckfudion.johnathan.screen.Arena
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g3d.environment.PointLight

class PcController( var arena: Arena) : InputProcessor, HudCard2d.ClickHand {

    var actived = true

    var pointLight: PointLight? = null
    var hudCard2d: HudCard2d? = null
    var hudCard: HudCard? = null
    var hudArena: HudArena? = null
    var builder3D: BuilderCard3d? = null

    var mao = true
    var olhar = false
    var combate = false
    var fusion = HashMap<Int, Int>()
    var escolhaCampo = false


    init {


    }


    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {

        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {

        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun keyDown(keycode: Int): Boolean {

        if (actived) {


            when (keycode) {

                Input.Keys.SPACE ->{

                    Camera3d.instance.addActions( Actions.moveCircularActor(arena?.arena,8f, CameraMoveCircular.MethodCircle.SCHEDULE,true,0.3f,180f))
                    Camera3d.instance.addActions( Actions.rotateTo(180f,0f,0f,0.3f))


                //    Camera3d.rotateBy(180f,0f,0f,3f)
                }



            /*    Input.Keys.SPACE -> {

                    if (mao) {
                        actived = false
                        Camera3d.rotateBy(0f, -80f, 0f, 0.2f)
                        Camera3d.moveTo(0f, 2.8f, -5.6f, 0.2f, object : Camera3d.CallBackMove {
                            override fun complete() {
                                pointLight?.set(Color.WHITE, 0f, 6f, -6f, 100f)
                                mao = false
                                combate = true

                                actived = true
                            }

                            override fun runInit(x: Float, y: Float, z: Float) {

                            }
                        })

                    }


                } */

                Input.Keys.BACKSPACE -> {

                    if (combate) {
                        actived = false
                        Camera3d.rotateBy(0f, 80f, 0f, 0.2f)
                        Camera3d.moveTo(0f, 0f, 0f, 0.2f, object : Camera3d.CallBackMove {
                            override fun complete() {


                                mao = true
                                combate = false

                                actived = true
                            }

                            override fun runInit(x: Float, y: Float, z: Float) {

                            }

                        })
                        pointLight?.set(Color.WHITE, 0f, 2f, -4f, 20f)

                    }


                }

                Input.Keys.LEFT -> {

                    if (mao) {
                        if (hudCard2d?.setaId!! > 0) {
                            actived = false
                            hudCard2d?.setaId = hudCard2d?.setaId!! - 1


                        }


                    }

                }
                Input.Keys.RIGHT -> {


                    if (mao) {

                        if (hudCard2d?.setaId!! < 4) {
                            actived = false
                            hudCard2d?.setaId = hudCard2d?.setaId!! + 1


                        }


                    }


                }
                Input.Keys.UP -> {
                    up()
                }


            }

        }

        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    companion object {

        fun move(i: Int): Float {

            var x = 0

            when (i) {

                0 -> {
                    x = 130
                }
                1 -> {
                    x = 335
                }
                2 -> {
                    x = 545
                }
                3 -> {
                    x = 750
                }
                4 -> {
                    x = 960
                }

            }

            return x.toFloat()
        }


    }


    private fun countFusion(i: Int) {

        when (hudCard2d?.contagemFusao) {
            0 -> {
                hudCard2d?.num1?.setPosition((move(i) + 150), 310f)
                hudCard2d?.num1?.isVisible = true
            }

            1 -> {
                hudCard2d?.num2?.setPosition((move(i) + 150), 310f)
                hudCard2d?.num2?.isVisible = true
            }

            2 -> {
                hudCard2d?.num3?.setPosition((move(i) + 150), 310f)
                hudCard2d?.num3?.isVisible = true
            }

            3 -> {
                hudCard2d?.num4?.setPosition((move(i) + 150), 310f)
                hudCard2d?.num4?.isVisible = true
            }

            4 -> {
                hudCard2d?.num5?.setPosition((move(i) + 150), 310f)
                hudCard2d?.num5?.isVisible = true
            }
        }

    }

    fun up() {

        if (mao) {

            if (!fusion.contains(hudCard2d?.setaId!!)) {
                countFusion(hudCard2d?.setaId!!)
                hudCard2d?.contagemFusao = hudCard2d?.contagemFusao!! + 1
                fusion.put(hudCard2d?.setaId!!, hudCard2d?.contagemFusao!!)


            }

        }

    }

    override fun click(id: Int) {


        if (mao) {

            if (!fusion.contains(id)) {
                countFusion(id)
                hudCard2d?.contagemFusao = hudCard2d?.contagemFusao!! + 1
                fusion.put(id, hudCard2d?.contagemFusao!!)


            }

        }

    }
}