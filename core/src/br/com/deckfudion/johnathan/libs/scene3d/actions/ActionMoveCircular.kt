package br.com.deckfudion.johnathan.libs.scene3d.actions

import br.com.deckfudion.johnathan.libs.scene3d.Actor3d
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.math.Vector2

class ActionMoveCircular : TemporalAction() {

    private var startY: Vector2? = null
    private var startZ: Vector2? = null
    private var r1 = 0f
    private var r2 = 0f
    private var startAngle = 0f
    private var angleSet = false
    private var direction = 0f
    private var movimentZ:Boolean = false
    private var isctor: Actor3d? = null
    private var degrass = 360.0




    override fun begin() {
        super.begin()
        if(actor3d != null){


            if(isctor != null){

                startY = Vector2(isctor!!.x,isctor!!.y)
                startZ = Vector2(isctor!!.x,isctor!!.z)
            }else{
                startY = Vector2(getActor3d().x,getActor3d().y)
                startZ = Vector2(getActor3d().x,getActor3d().z)

            }

        }

        startAngle = Math.toRadians(Vector2(getActor3d().x, getActor3d().z).sub(startZ).angle().toDouble()).toFloat()


    }

    fun setDegress(degress:Double){

        degrass = degress
    }

     fun setDirection(value: MethodCircle) {
        direction = - value.value
    }

    fun setactor(actor: Actor3d?) {
        isctor = actor
    }

     fun setStartAngle(angle: Float) {
        startAngle = angle
    }

     fun movz(moviment: Boolean){
        movimentZ = moviment
    }

    override fun update(percent: Float) {


        if(movimentZ){

            if (!angleSet) {
                // calculate angle between start point and actor position
                startAngle = Math.toRadians(Vector2(getActor3d().x, getActor3d().z).sub(startZ).angle().toDouble()).toFloat()
                angleSet = true
            }
            val angle = (Math.toRadians(degrass) * (direction * percent / 1f)).toFloat() + startAngle
            actor3d.setPosition(startZ!!.x + r1 * Math.cos(angle.toDouble()).toFloat(), startY!!.y,startZ!!.y + r2 * Math.sin(angle.toDouble()).toFloat())


        }else{


        if (!angleSet) {
            // calculate angle between start point and actor position
            startAngle = Math.toRadians(Vector2(getActor3d().x, getActor3d().y).sub(startY).angle().toDouble()).toFloat()
            angleSet = true
        }
        val angle = (Math.toRadians(degrass) * (direction * percent / 1f)).toFloat() + startAngle
        actor3d.setPosition(startY!!.x + r1 * Math.cos(angle.toDouble()).toFloat(), startY!!.y + r2 * Math.sin(angle.toDouble()).toFloat(),startZ!!.y)
    }}

    fun setR(r1: Float, r2: Float) {
        this.r1 = r1
        this.r2 = r2
    }

    
    
    enum class MethodCircle( val value: Float) {

        SCHEDULE(1.0f),
        COUNTER_CLOCKWISE(-1.0f),



    }
    


    
}