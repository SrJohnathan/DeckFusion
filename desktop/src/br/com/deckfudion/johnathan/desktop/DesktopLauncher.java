package br.com.deckfudion.johnathan.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import br.com.deckfudion.johnathan.Main;

public class DesktopLauncher {



	public static void main (String[] arg) {

	//	TexturePacker.process("C:\\Users\\Johnathan\\icons","C:\\Users\\Johnathan\\icons", "opponets.atlas");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.fullscreen = false;
	 	new LwjglApplication(new Main(), config);



	}


}
