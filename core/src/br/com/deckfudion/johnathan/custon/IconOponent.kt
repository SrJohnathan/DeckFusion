package br.com.deckfudion.johnathan.custon

import br.com.deckfudion.johnathan.louder.HistoryLouder
import br.com.deckfudion.johnathan.utill.TextLouder
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table

class IconOponent( nameAtlas: String,level:Any,var asset: HistoryLouder) : Table() {



    init {

        val im = asset.external.get("/gameData/opponents/opponets.atlas", TextureAtlas::class.java).findRegion(nameAtlas)
        im.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        val minion1 = Image(im)

            add(minion1).width(124f).height(109f)
            row()
            add( Label("Lv: $level", TextLouder.styleBebasBorder(Color.WHITE,23)))

    }





}