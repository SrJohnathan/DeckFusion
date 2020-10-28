package br.com.deckfudion.johnathan.utill

import com.badlogic.gdx.utils.Disposable

interface ApiDialog : Disposable {


    fun showDialog(runnable: Runnable)
    fun showDialogInput(varl:Value)
    fun isShow():Boolean

}

interface  Value{
    fun content(st:String)
}