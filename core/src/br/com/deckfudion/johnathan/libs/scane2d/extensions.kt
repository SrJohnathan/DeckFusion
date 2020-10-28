package br.com.deckfudion.johnathan.libs.scane2d

import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import br.com.deckfudion.johnathan.libs.scane2d.ActionMoveCircular.MethodCircle

fun Actions.moveElipse(r1: Float, r2: Float, direction: MethodCircle, rotate: Boolean, duration: Float, degress:Float, interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
    val action =  Actions.action(ActionMoveCircular::class.java)


    action.setR(r1, r2)
    action.duration = duration
    action.setangleSet( false)
    action.setDegress(degress.toDouble())
    action.setDirection(direction)
    action.setRotate(rotate)
    action.setDegress(degress.toDouble())
    action.interpolation = interpolation

    return action!!
}


fun Actions.moveElipseActor(actor: Actor,r1: Float, r2: Float, direction: MethodCircle, rotate: Boolean, duration: Float,degress:Float,interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
    val action =  Actions.action(ActionMoveCircular::class.java)


  //  action.actor.setOrigin(action.actor?.width!! /2,  action.actor?.height!! /2)

    action.setactor(actor)
    action.setR(r1, r2)
    action.setDegress(degress.toDouble())
    action.duration = duration
    action.setangleSet( false)
    action.setDirection(direction)
    action.setRotate(rotate)
    action.interpolation = interpolation

    return action!!
}

fun Actions.moveElipse(r1: Float, r2: Float, direction: MethodCircle, rotate: Boolean, duration: Float, angle: Float,degress:Float,interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
    val action =  Actions.action(ActionMoveCircular::class.java)

    action.setR(r1, r2)
    action.duration = duration
    action.setangleSet( true)
    action.setDegress(degress.toDouble())
    action.setStartAngle(angle)
    action.setDirection(direction)
    action.setRotate(rotate)
    action.interpolation = interpolation

    return action!!
}

fun  Actions.moveCircleActor(actor: Actor, r: Float, direction: MethodCircle, rotate: Boolean, duration: Float, degress:Float,interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
    return  Actions().moveElipseActor(actor,r, r, direction,rotate, duration,degress,interpolation)
}

fun  Actions.moveCircle( r: Float, direction: MethodCircle, rotate: Boolean, duration: Float,angle: Float,degress:Float, interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
  return  Actions().moveElipse(r, r, direction,rotate, duration,angle,degress,interpolation)
}

fun  Actions.moveCircle( r: Float, direction: MethodCircle, rotate: Boolean, duration: Float,degress:Float ,interpolation: Interpolation? = Interpolation.linear): ActionMoveCircular {
    return  Actions().moveElipse(r, r, direction,rotate, duration,degress,interpolation)
}