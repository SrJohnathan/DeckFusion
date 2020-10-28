package br.com.deckfudion.johnathan.louder

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.utils.Disposable

class LouderMusic : Disposable {


    private val asset = AssetManager(ExternalFileHandleResolver())
    private var id: Musics? = null
    private var isupdate = false


    var pause = false
    var reapet = false
    var tmpvolume = 0f

    private var stopCall: Runnable? = null

    var cout = 0f
    var duration = 2
    private var music: Music? = null

    fun load(id: Musics) {


        if (music != null) {
            tmpvolume = music?.volume!!
            pause = true
            stopCall = Runnable {

                unload()


                loadd(id)

            }

        } else {

            loadd(id)

        }


    }


    fun  stop(runnable: Runnable){



        if (music != null) {
            tmpvolume = music?.volume!!
            pause = true
            stopCall = Runnable {

                unload()

                runnable.run()

            }

        }

    }


    private fun loadd(id: Musics) {


        this.id = id
        when (id) {

            Musics.FREE_DUEL -> {
                asset.load("/gameData/som/freeduel.ogg", Music::class.java)
                isupdate = true
            }

            Musics.AGUA_AMBIENT -> {
                asset.load("/gameData/som/agua_ambient.ogg", Music::class.java)
                isupdate = true
            }


            Musics.EGITO -> {
                asset.load("/gameData/som/simon_muran.ogg", Music::class.java)
                isupdate = true
            }


            Musics.DESERTO -> {
                asset.load("/gameData/som/deserto.ogg", Music::class.java)
                isupdate = true
            }

            Musics.CAVEIRA -> {
                asset.load("/gameData/som/caveira.ogg", Music::class.java)
                isupdate = true
            }

            Musics.INTRO_HOME -> {
                asset.load("/gameData/som/introhome.ogg", Music::class.java)
                isupdate = true
            }
        }

    }


    fun update(delta: Float) {

        if (isupdate) {

            asset.update()
            if (asset.isFinished && asset.progress == 1.0f) {
                isupdate = false
                play()
            }
        }

        if (pause) {

            cout += ((delta / duration))

            if (music?.volume!! <= 0.1f) {
                pause = false
                music?.stop()
                cout = 0f
                if (stopCall != null) {
                    stopCall?.run()
                }

            } else {
                music?.volume = (tmpvolume - cout)
            }


        }

    }


    private fun play() {

        when (id) {

            Musics.FREE_DUEL -> {

                music = asset.get("/gameData/som/freeduel.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->
                    music?.dispose()
                    asset.unload("/gameData/som/freeduel.ogg")


                }
            }

            Musics.AGUA_AMBIENT -> {

                music = asset.get("/gameData/som/agua_ambient.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->

                    if (reapet) {

                        music?.play()

                    } else {
                        music?.dispose()
                        asset.unload("/gameData/som/agua_ambient.ogg")
                    }


                }
            }

            Musics.EGITO -> {

                music = asset.get("/gameData/som/simon_muran.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->

                    if (reapet) {

                        music?.play()

                    } else {
                        music?.dispose()
                        asset.unload("/gameData/som/simon_muran.mp3")
                    }


                }
            }



            Musics.DESERTO -> {

                music = asset.get("/gameData/som/deserto.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->

                    if (reapet) {

                        music?.play()

                    } else {
                        music?.dispose()
                        unload()
                    }


                }
            }

            Musics.CAVEIRA -> {

                music = asset.get("/gameData/som/caveira.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->

                    if (reapet) {

                        music?.play()

                    } else {
                        music?.dispose()
                        unload()
                    }


                }
            }

            Musics.INTRO_HOME -> {

                music = asset.get("/gameData/som/introhome.ogg", Music::class.java)
                music?.volume = 0.5f
                music?.play()
                music?.setOnCompletionListener { music: Music? ->

                    if (reapet) {
                        music?.play()
                    } else {
                        music?.dispose()
                        unload()
                    }


                }
            }

        }



    }


    private fun unload() {

        when (id) {

            Musics.FREE_DUEL -> {
                asset.unload("/gameData/som/freeduel.ogg")

            }

            Musics.AGUA_AMBIENT -> {
                asset.unload("/gameData/som/agua_ambient.ogg")

            }


            Musics.EGITO -> {
                asset.unload("/gameData/som/simon_muran.ogg")

            }

            Musics.DESERTO -> {
                asset.unload("/gameData/som/deserto.ogg")

            }

            Musics.CAVEIRA -> {
                asset.unload("/gameData/som/caveira.ogg")

            }

            Musics.INTRO_HOME -> {
                asset.unload("/gameData/som/introhome.ogg")

            }
        }

    }

    enum class Musics {

        FREE_DUEL,
        AGUA_AMBIENT,
        EGITO,
        DESERTO,
        CAVEIRA,
        INTRO_HOME


    }

    override fun dispose() {
        music?.dispose()
        asset.dispose()
    }

}







