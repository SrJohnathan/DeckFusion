package br.com.deckfudion.johnathan.custon

import br.com.deckfudion.johnathan.louder.HistoryLouder
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align

class IconCamp(nameAtlas: String, name:String, var asset: HistoryLouder) : Table() {


    var circle : Image? = null

    init {

        val im = asset.external.get("/gameData/opponents/icone_camp.atlas", TextureAtlas::class.java).findRegion(nameAtlas)
        val ci = asset.external.get("/gameData/opponents/icone_camp.atlas", TextureAtlas::class.java).findRegion("circle")
        val minion1 = Image(im)
        circle = Image(ci)



        val group = Stack()
        group.addActor(minion1)
        group.addActor(circle)

        circle?.setSize(124f,124f)


        circle?.setOrigin(  circle?.width!! /2,  circle?.height!! /2)




        circle?.addAction(Actions.repeat(RepeatAction.FOREVER,
                Actions.parallel(Actions.rotateBy(36f,5f, Interpolation.bounce))))



            add(group).width(124f).height(124f)
            row()
            add( Label(name, TextLouder.styleBebasBorder(Color.WHITE,23)))





    }



    fun settStage(stage: Stage) {
      //  stage.addActor(circle)
    }


   /* Image myImage = new Image(myTexture);
    myImage.addAction(Actions.parallel(Actions.moveTo(endX, endY, duration), Actions.rotateBy(degrees, duration)));
    myImage.setPosition(startX, startY);
    myImage.setOrigin(sizeX/2, sizeY/2);
    stage.add(myImage); */


}