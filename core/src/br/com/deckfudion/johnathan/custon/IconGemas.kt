package br.com.deckfudion.johnathan.custon

import br.com.deckfudion.johnathan.louder.HistoryLouder
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.utils.Align

class IconGemas(nameAtlas: String, name:String, var asset: HistoryLouder,monomento: String) : Table() {


    var circle : Image? = null

    init {

        val im = asset.external.get("/gameData/opponents/gemas.atlas", TextureAtlas::class.java).findRegion(monomento)

        val ci = asset.external.get("/gameData/opponents/gemas.atlas", TextureAtlas::class.java).findRegion(nameAtlas)
        val minion1 = Image(im)
        circle = Image(ci)



        val group = Stack()
        group.addActor(minion1)


        circle?.setSize(100f,100f)







        circle?.addAction(Actions.repeat(RepeatAction.FOREVER,
                Actions.sequence(Actions.moveBy(0f,5f, 1f),Actions.moveBy(0f,-5f, 1f))))








            add(group).width(124f).height(20f)
            row()
            add( Label(name, TextLouder.styleBebasBorder(Color.WHITE,23)))

    }

    fun settStage(stage: Stage) {
        circle?.setPosition(x-50f, y+20)
        stage.addActor(circle)
    }

    fun visible(visible:Boolean){

        circle?.isVisible = visible
    }

   /* Image myImage = new Image(myTexture);
    myImage.addAction(Actions.parallel(Actions.moveTo(endX, endY, duration), Actions.rotateBy(degrees, duration)));
    myImage.setPosition(startX, startY);
    myImage.setOrigin(sizeX/2, sizeY/2);
    stage.add(myImage); */


}