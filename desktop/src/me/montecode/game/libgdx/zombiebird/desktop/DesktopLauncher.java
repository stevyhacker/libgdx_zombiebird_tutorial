package me.montecode.game.libgdx.zombiebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.montecode.game.libgdx.zombiebird.ZombieBirdGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Zombie Bird";
        config.width = 480;
        config.height = 320;
        new LwjglApplication(new ZombieBirdGame(), config);
	}
}
