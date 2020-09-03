package br.com.deckfudion.johnathan.card

import br.com.deckfudion.johnathan.louder.LouderFull
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Mesh
import com.badlogic.gdx.graphics.VertexAttribute
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g3d.Material
import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute
import com.badlogic.gdx.graphics.g3d.model.MeshPart
import com.badlogic.gdx.graphics.g3d.model.Node
import com.badlogic.gdx.graphics.g3d.model.NodePart
import com.badlogic.gdx.math.Vector3

class Card3d : Model() {

    init {

        val bi = Builder()
        val node = Node()
        node.parts.add(bi)

        nodes.add(node)

    }

    class Builder() : NodePart() {


        val CARD_WIDTH = 0.7f
        val CARD_HEIGHT = CARD_WIDTH * 277f / 200f

        val position = Vector3()
        var angle: Float = 0.toFloat()
        var vertices: kotlin.FloatArray? = null
        var indices: ShortArray? = null

        init {

            val fundo = LouderFull.card3dSprite?.createSprite("cardfront")
            // val front = Sprite(AtlasLouder.card33d)
            val front = LouderFull.card3dSprite?.createSprite("carfback")


            material = Material(
                    TextureAttribute.createDiffuse(front?.texture),
                    BlendingAttribute(false, 1f),
                    FloatAttribute.createAlphaTest(0.5f)
            )

            front?.setSize(CARD_WIDTH, CARD_HEIGHT)
            fundo?.setSize(CARD_WIDTH, CARD_HEIGHT)

            front?.setPosition(-front.width * 0.5f, -front.height * 0.5f)
            fundo?.setPosition(-fundo.width * 0.5f, -fundo.height * 0.5f)

            vertices = convert(front?.vertices!!, fundo?.vertices!!)
            indices = shortArrayOf(0, 1, 2, 2, 3, 0, 4, 5, 6, 6, 7, 4)


            // FIXME: this Mesh needs to be disposed
            meshPart = MeshPart()
            meshPart.mesh = Mesh(false, 8, 12, VertexAttribute.Position(), VertexAttribute.Normal(), VertexAttribute.TexCoords(0))
            meshPart.mesh.setVertices(vertices)
            meshPart.mesh.setIndices(indices)



            meshPart.offset = 0
            meshPart.size = meshPart.mesh.getNumIndices()
            meshPart.primitiveType = GL20.GL_TRIANGLES
            meshPart.update()

        }

        private fun convert(front: kotlin.FloatArray, back: kotlin.FloatArray): kotlin.FloatArray {
            return floatArrayOf(

                    front[Batch.X2], front[Batch.Y2], 0f, 0f, 0f, 1f, front[Batch.U2], front[Batch.V2], front[Batch.X1], front[Batch.Y1], 0f, 0f, 0f, 1f, front[Batch.U1], front[Batch.V1], front[Batch.X4], front[Batch.Y4], 0f, 0f, 0f, 1f, front[Batch.U4], front[Batch.V4], front[Batch.X3], front[Batch.Y3], 0f, 0f, 0f, 1f, front[Batch.U3], front[Batch.V3]

                    , back[Batch.X1], back[Batch.Y1], 0f, 0f, 0f, -1f, back[Batch.U1], back[Batch.V1], back[Batch.X2], back[Batch.Y2], 0f, 0f, 0f, -1f, back[Batch.U2], back[Batch.V2], back[Batch.X3], back[Batch.Y3], 0f, 0f, 0f, -1f, back[Batch.U3], back[Batch.V3], back[Batch.X4], back[Batch.Y4], 0f, 0f, 0f, -1f, back[Batch.U4], back[Batch.V4]


            )
        }


    }}