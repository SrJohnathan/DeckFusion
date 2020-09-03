package br.com.deckfudion.johnathan.utill

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Json
import com.badlogic.gdx.utils.JsonValue

class GamePref {


    companion object {

        val INIT_GAME = "config"
        val MYCARDS = "mycards"

        fun initGame(): Boolean {


            val pref = Gdx.app.getPreferences(INIT_GAME)

            return pref.getBoolean("initgame", false)

        }


        fun saveInitGame(name: String) {

            val pref = Gdx.app.getPreferences(INIT_GAME)

            pref.putString("name_user", Utiil.encryptDecrypt(name))
            pref.putBoolean("initgame", true)
            pref.flush()

        }

        fun readerInitGame(): String {

            val pref = Gdx.app.getPreferences(INIT_GAME)

            return Utiil.encryptDecrypt(pref.getString("name_user", ""))


        }


        fun getMyCardsDeck(): ArrayList<Int> {

            val array = ArrayList<Int>()

            val pref = Gdx.app.getPreferences(MYCARDS)

            val json = JsonValue(Utiil.encryptDecrypt(pref.getString("cardsDeck")))


            json.asIntArray().forEach { i: Int ->


                array.add(i)

            }


            return array
        }

        fun setMyCardsDeck(array: ArrayList<Int>) {


            val pref = Gdx.app.getPreferences(MYCARDS)


            val json = Json()

            pref.putString("cardsDeck", Utiil.encryptDecrypt(json.toJson(array)))

            pref?.flush()


        }


    }
}