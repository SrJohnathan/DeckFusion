package br.com.deckfudion.johnathan.utill

import br.com.deckfudion.johnathan.card.Card2dSmall
import com.badlogic.gdx.math.Vector2

class Vetores {

    companion object{


         fun position(with: Card2dSmall): Array<Vector2> {

             val p1 =   Vector2 ( (1535 / 2f)-(with.width!! / 2f)  , 110f)

             val p2 = Vector2 ((p1.x - (with.width!! * 2))-20, 110f)
             val p3 = Vector2 ((p1.x  - (with.width!!))-10, 110f)
             val p4 = Vector2((p1.x  + (with.width!!))+10, 110f)
             val p5 = Vector2((p1.x  + (with.width!! * 2))+20, 110f)

             return arrayOf(p2,p3,p1,p4,p5)

        }


    }

}