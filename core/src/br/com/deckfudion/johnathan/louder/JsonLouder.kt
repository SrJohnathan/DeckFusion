package br.com.deckfudion.johnathan.louder


import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetLoaderParameters
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
import com.badlogic.gdx.assets.loaders.FileHandleResolver
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.JsonReader
import com.badlogic.gdx.utils.JsonValue

class JsonLouder(resolver: FileHandleResolver) : AsynchronousAssetLoader<JsonValue, JsonLouder.JsonParamer>(resolver) {


    var json: JsonValue? = null

    override fun loadSync(manager: AssetManager?, fileName: String?, file: FileHandle?, parameter: JsonParamer?): JsonValue {


        val json = this.json
        this.json = null
        return  json!!

    }

    override fun getDependencies(fileName: String?, file: FileHandle?, parameter: JsonParamer?): Array<AssetDescriptor<Any>>? {

        return null
    }

    override fun loadAsync(manager: AssetManager?, fileName: String?, file: FileHandle?, parameter: JsonParamer?) {

        val jso = JsonReader();
        json = jso.parse(file)


    }


    class JsonParamer : AssetLoaderParameters<JsonValue>() {}
}