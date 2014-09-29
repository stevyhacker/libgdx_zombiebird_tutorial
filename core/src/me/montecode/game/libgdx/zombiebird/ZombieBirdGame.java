package me.montecode.game.libgdx.zombiebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.montecode.game.libgdx.screens.GameScreen;

public class ZombieBirdGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
        Gdx.app.log("ZBGame", "created");
        setScreen(new GameScreen());

    }
}
