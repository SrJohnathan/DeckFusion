package br.com.deckfudion.johnathan.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20

 fun GL20.glClearColor(color: Color) {
     Gdx.gl.glClearColor(color.r, color.g, color.b, 1f)

}