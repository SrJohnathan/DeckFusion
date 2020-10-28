package br.com.deckfudion.johnathan.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.util.Locale;

import br.com.deckfudion.johnathan.Main;

public class DesktopLauncher {

   public  static Lwjgl3Application application;

	public static void main (String[] arg) {

	//	TexturePacker.process("C:\\Users\\Johnathan\\icons","C:\\Users\\Johnathan\\icons", "opponets.atlas");



		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1280,720);
		config.setDecorated(false);
	 	application = new Lwjgl3Application(new Main(), config);




	}


}
