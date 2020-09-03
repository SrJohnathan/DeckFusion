package br.com.deckfudion.johnathan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.badlogic.gdx.backends.android.AndroidFragmentApplication

class GameFrag : AndroidFragmentApplication() {

    var main:Main? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val config = AndroidApplicationConfiguration()



         main = Main()



      return  initializeForView(main, config)





    }


    override fun startActivity(intent: Intent?) {

    }



}