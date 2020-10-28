package br.com.deckfudion.johnathan.libs.scane2d

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction


class ActionMoveCircular : TemporalAction() {
    private var start: Vector2? = null
    private var r1 = 0f
    private var r2 = 0f
    private var startAngle = 0f
    private var angleSet = false
    private var direction = 0f
    private var toRotate = false
     private var isctor:Actor? = null
    private var degrass = 360.0

      override fun begin() {
          super.begin()

          if(isctor != null){

              start = Vector2((isctor?.x!! + ((isctor?.width!! / 2f) - (actor.width /2)  ) ),(isctor?.y!! + ((isctor!!.height / 2f) - (actor.height /2)  ) ))

          }else{
              start = Vector2(getActor().originX,getActor().originY)
          }


      }

    fun setRotate(rotate: Boolean) {
        toRotate = rotate
    }

    fun setDirection(dir: MethodCircle) {
        direction = -dir.value
    }

    fun setDegress(degress:Double){

        degrass = degress
    }

     fun setactor(actor: Actor?) {
        isctor = actor
    }

    fun setangleSet(angleSet: Boolean) {
        this.angleSet = angleSet
    }

      fun position(x:Float,y:Float){
              start = Vector2(x, y)
      }

     fun setStartAngle(angle: Float) {
        startAngle = angle
    }

    override fun update(percent: Float) {
        if (!angleSet) {
            // calculate angle between start point and actor position
            startAngle = Math.toRadians(Vector2(actor.x, actor.y).sub(start).angle().toDouble()).toFloat()
            angleSet = true
        }
        val angle = ( Math.toRadians(degrass) * (direction * percent / 1f)).toFloat() + startAngle

        actor.setPosition(start!!.x + r1 * Math.cos(angle.toDouble()).toFloat(), start!!.y + r2 * Math.sin(angle.toDouble()).toFloat())

        if (toRotate) actor.rotation = Math.toDegrees(angle.toDouble()).toFloat() - 90
    }

    fun setR(r1: Float, r2: Float) {
        this.r1 = r1
        this.r2 = r2
    }

    enum class MethodCircle( val value: Float) {

        SCHEDULE(1.0f),
        COUNTER_CLOCKWISE(-1.0f),



    }

}