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
        fun config(map: Map<String,String>,encryption:Boolean){
            val pref: Preferences =   Gdx.app.getPreferences("config")
            map.forEach {
                if(encryption){
                    pref.putString( Utiil.encryptDecrypt( it.key),Utiil.encryptDecrypt(it.value));

                }else{
                    pref.putString(it.key,it.value);

                }
                pref.flush()

            }
        }

        fun getConfig(encryption:Boolean):Map<String,String?> {

            val hash = HashMap<String, String>()

            val pref: Preferences = Gdx.app.getPreferences("config")

            pref.get().forEach {

                if (encryption) {
                    hash.put(Utiil.encryptDecrypt(it.key), Utiil.encryptDecrypt(it.value as String));

                } else {
                    hash.put(it.key, it.value as String)

                }


            }


            return  hash
        }

    }





}