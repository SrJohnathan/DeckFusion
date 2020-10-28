package br.com.deckfudion.johnathan.screen

import br.com.deckfudion.johnathan.Main
import br.com.deckfudion.johnathan.card.BuilderCard3d
import br.com.deckfudion.johnathan.card.DeckTotal
import br.com.deckfudion.johnathan.hud.AndroidController
import br.com.deckfudion.johnathan.hud.HudArena
import br.com.deckfudion.johnathan.hud.HudCard
import br.com.deckfudion.johnathan.hud.HudCard2d
import br.com.deckfudion.johnathan.libs.scene3d.Actor3d
import br.com.deckfudion.johnathan.libs.scene3d.Camera3d
import br.com.deckfudion.johnathan.libs.scene3d.Stage3d
import br.com.deckfudion.johnathan.libs.scene3d.actions.Actions3d
import br.com.deckfudion.johnathan.libs.scene3d.camera.Actions
import br.com.deckfudion.johnathan.libs.scene3d.camera.CameraMoveCircular
import br.com.deckfudion.johnathan.louder.LouderArena
import br.com.deckfudion.johnathan.louder.LouderExternal
import br.com.deckfudion.johnathan.louder.LouderFull
import br.com.deckfudion.johnathan.louder.LouderMusic
import br.com.deckfudion.johnathan.utill.PcController
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.*
import com.badlogic.gdx.graphics.g3d.Environment
import com.badlogic.gdx.graphics.g3d.environment.PointLight
import com.badlogic.gdx.graphics.g3d.particles.ParticleSystem
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch
import com.badlogic.gdx.graphics.g3d.particles.batches.PointSpriteParticleBatch
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import particles.EffekseerManager
import particles.ParticleEffekseer


class Arena(var game: Main, var louderArena: LouderArena) : Screen {

    private var stage3d: Stage3d? = null
     var arena: Actor3d? = null
    private var array: ArrayList<Actor3d>? = null
    private var camController: CameraInputController? = null

    private var hudArena: HudArena? = null
    private var hudCard: HudCard? = null
    private var hudCard2d: HudCard2d? = null

    private var camera: OrthographicCamera? = null
    private var viewport: Viewport? = null

    private var pcController: PcController? = null
    private var androidController: AndroidController? = null

    val deck = DeckTotal()
    val music = LouderMusic()

    val poi = PointLight().set(Color.WHITE, 0f, 2f, -3f, 30f)

    private var billboardParticleBatch: BillboardParticleBatch? = null
    private var pointSpriteParticleBatch: PointSpriteParticleBatch? = null
    private val particleSys: ParticleSystem = ParticleSystem()




    private var  manager2d:  EffekseerManager? = null
    private var  manager3d:  EffekseerManager? = null
    private var particleUpPoder : ParticleEffekseer? = null

    init {

        stage3d = Stage3d(1280f, 720f)
        camera = OrthographicCamera(1280f, 720f)
        viewport = FitViewport(1280f, 720f, camera)

        //ACTOR3D
        arena = Actor3d(LouderFull.arena)
        camController = CameraInputController(stage3d?.camera)
        array = ArrayList()

        hudArena = HudArena(game.batch!!, viewport!!,louderArena)
        hudCard = HudCard(game.batch!!, viewport!!)
        androidController = AndroidController(this,game.batch!!, viewport!!)
        hudCard2d = HudCard2d(game.batch!!,FitViewport(1280f, 720f, OrthographicCamera(1280f,720f)), deck)
        val bicard = BuilderCard3d(stage3d!!)

        pcController = PcController(this)


        val environment = Environment()

        //  environment.set(ColorAttribute(ColorAttribute.AmbientLight, 1f, 1f, 1f, 1f))
      //     environment.add(DirectionalLight().set(Color.WHITE, -1f, -0.8f, -0.2f))


        environment.add(poi)



        stage3d?.environment = environment


        //FUNTION
        arena?.setPosition(0f, -3f, -8f)
        arena?.addAction3d(Actions3d.rotateBy(90f, 0f, 0f, 0f))

      //  arena?.addAction3d( Actions3d.moveCircular(2f,ActionMoveCircular.MethodCircle.SCHEDULE,true,5f,360f))


        Camera3d.rotateBy(0f, -10f, 0f, 0f)



        pcController?.pointLight = poi
        pcController?.hudCard2d = hudCard2d
        pcController?.hudCard = hudCard
        pcController?.hudArena = hudArena
        pcController?.builder3D = bicard


        androidController?.pcController = pcController


        /*
        pointSpriteParticleBatch = PointSpriteParticleBatch()
        billboardParticleBatch = BillboardParticleBatch()
        pointSpriteParticleBatch?.texture?.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear)
        pointSpriteParticleBatch?.setCamera(stage3d?.camera)
        billboardParticleBatch?.setCamera(stage3d?.camera)
        particleSys.add(pointSpriteParticleBatch)
        particleSys.add(billboardParticleBatch)
        particleSys.update()
*/


        val came = OrthographicCamera(1280f,720f)

        manager2d = EffekseerManager(stage3d?.camera);
        particleUpPoder = ParticleEffekseer(manager2d);

        particleUpPoder?.setMagnification(.3f)




        try {
            particleUpPoder?.load("/gameData/particleeff/ring.efk",false)

        }catch (e:Exception){
            e.printStackTrace()
        }






    }

    override fun hide() {

    }

    override fun show() {




        hudCard?.run()
        hudCard2d?.run()
        androidController?.run()


        //BOTAO CHECKBOX  NA TABELA
        hudArena?.tools?.row()
        hudArena?.tools?.add(androidController?.right)

        stage3d?.addActor3d(arena)





        hudCard2d?.clickHand = pcController


        androidController?.duellogo(runnable1 = { LouderExternal.duel?.play() }, runnable2 = {  music.load(LouderMusic.Musics.FREE_DUEL)
            particleUpPoder?.play()

            particleUpPoder?.setLacation(00f,-2f,-8f)



         /*   Camera3d.instance.addActions(Actions.parallel(

            Actions.rotateTo(180f,0f,0f,10f)
           , Actions.moveCircularActor(arena,4f,CameraMoveCircular.MethodCircle.SCHEDULE,true,10f,180f)
            ))  */
          //  Camera3d.moveCircular(arena,5f,180f,Camera3d.MoveCamera.SCHEDULE,6f)

        })
    }

    override fun render(delta: Float) {

        music.update(delta)



        Gdx.input.inputProcessor = InputMultiplexer(hudCard2d, hudCard, androidController,hudArena, pcController)



        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)




        hudArena?.fps?.setText(Gdx.graphics.framesPerSecond.toString())


        stage3d?.act(delta)
        stage3d?.draw()


        hudCard?.act(delta)
       hudCard?.draw()

        hudArena?.act(delta)
        hudArena?.draw()


        manager2d?.draw(delta)

        hudCard2d?.act(delta)
        hudCard2d?.draw()


        androidController?.act(delta)
        androidController?.draw()


        Camera3d.instance.act(delta)

    }

    override fun pause() {

    }

    override fun resume() {


    }

    override fun resize(width: Int, height: Int) {

        Camera3d.instance.update()
    }

    override fun dispose() {
        manager2d?.dispose()
    }


}