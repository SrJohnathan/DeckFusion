package br.com.deckfudion.johnathan

import br.com.deckfudion.johnathan.utill.Utiil
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences

class Preferencies {

    companion object {
        fun saveCard(map: Map<String,String>,encryption:Boolean){
           val pref: Preferences =   Gdx.app.getPreferences("Cards")
            map.forEach {
                if(encryption){
                    pref.putString( Utiil.encryptDecrypt( it.key),Utiil.encryptDecrypt(it.value));

                }else{
                    pref.putString(it.key,it.value);

                }
                pref.flush()

            }
        }

    }


}