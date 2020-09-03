package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.video.VideoPlayer
import com.badlogic.gdx.video.VideoPlayerCreator
import java.io.FileNotFoundException

class VideoScreen(var game: Main) : Screen {

    private var videoPlayer:VideoPlayer? = null
    private  var render = true

    init {

     videoPlayer = VideoPlayerCreator.createVideoPlayer()



        try {
            if (Gdx.app.type == Application.ApplicationType.Android) {
                videoPlayer?.play(Gdx.files.external("/gameData/som/pos_abertura.mp4"))
            } else {
                videoPlayer?.play(Gdx.files.external("/gameData/som/pos_abertura.ogv"))
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }


        videoPlayer?.setOnCompletionListener { file: FileHandle? ->

            Thread(Runnable {


                Thread.sleep(2000)


                Gdx.app.postRunnable {

                    videoPlayer?.stop()
                    render = false

                    game.setScreen(History(game))

                }


            }).start()


        }
    }

    override fun hide() {
        videoPlayer?.stop()
    }

    override fun show() {
    }

    override fun render(delta: Float) {

        if (render){
            if(!videoPlayer?.render()!!){



            }

        }

    }

    override fun pause() {

        videoPlayer?.pause()
    }

    override fun resume() {

        videoPlayer?.resume()
    }

    override fun resize(width: Int, height: Int) {

        videoPlayer?.resize(width, height)
    }

    override fun dispose() {

        videoPlayer?.dispose()
    }
}