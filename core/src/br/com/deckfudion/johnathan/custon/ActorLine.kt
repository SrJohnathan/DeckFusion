package br.com.deckfudion.johnathan.custon

import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.Image

class ActorLine(var imageInicio: Actor, var imageFim: Actor, var camera: Camera) : Group() {

    val sr = ShapeRenderer()

    var pontoAnimation: Image? = null

    var colorLine:Color? = null

    init {

        pontoAnimation = Image(LouderFull.asset.get("data/imagens/ponto.png", Texture::class.java))


        pontoAnimation?.setPosition(imageInicio.x, imageInicio.y)


        pontoAnimation?.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(
                Actions.moveTo(imageFim.x - 20f, imageFim.y - 20f, 2f),
                Actions.moveTo(imageInicio.x - 20f, imageInicio.y - 20f))))

        colorLine = Color.GOLD

        addActor(pontoAnimation)
    }


    override fun draw(batch: Batch?, parentAlpha: Float) {


        batch?.end()

        Gdx.gl.glEnable(GL20.GL_BLEND);

        if(colorLine == null){
            sr.color = Color.GREEN
            sr.color.a = (parentAlpha /2)
        }else{
            sr.color = colorLine
            sr.color.a = (parentAlpha /2)
        }



        sr.begin(ShapeRenderer.ShapeType.Filled)
        sr.projectionMatrix = camera.combined


        sr.rectLine(imageInicio.x, imageInicio.y,
                imageFim.x, imageFim.y, 10f)
        sr.end()
        Gdx.gl.glDisable(GL20.GL_BLEND);
        batch?.begin()



        super.draw(batch, parentAlpha)

    }
}