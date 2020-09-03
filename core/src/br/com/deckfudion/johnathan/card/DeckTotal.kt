package br.com.deckfudion.johnathan.card

import br.com.deckfudion.johnathan.louder.LouderExternal
import com.badlogic.gdx.utils.JsonValue

class DeckTotal {


    val ar = ArrayList<Cards>()

    init {

        if(LouderExternal.jsonCards?.isArray!!){

            LouderExternal.jsonCards?.forEach {  jsonValue: JsonValue? ->

                val ca =  Cards()

                ca.id = jsonValue?.getLong("id");
                ca.type = jsonValue?.getInt("type")!!
                ca.name = jsonValue.getString("name")
                ca.colorname = jsonValue.getInt("colorname")
                ca.cardcolor =jsonValue.getString("cardcolor")
                ca.atk = jsonValue.getInt("atk");
                ca.def = jsonValue.getInt("def")
                ca.attr = jsonValue.getInt("attr")
                ca.star = jsonValue.getInt("star")
                ca.description = jsonValue.getString("description")
                ca.effect = jsonValue.getInt("effect")
                ca.guardian1 = jsonValue.getInt("guardian1")
                ca.guardian2 = jsonValue.getInt("guardian2")
                ca.idd = jsonValue.getInt("idd");

                ca.encrypto()

                ar.add(ca)

            }


        }

    }

}