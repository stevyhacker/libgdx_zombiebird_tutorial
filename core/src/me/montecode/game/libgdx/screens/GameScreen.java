package me.montecode.game.libgdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import me.montecode.game.libgdx.gameworld.GameRenderer;
import me.montecode.game.libgdx.gameworld.GameWorld;

/**
 * Created by stevyhacker on 26.9.14..
 */
public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        world = new GameWorld();
        renderer = new GameRenderer(world);
        Gdx.app.log("GameScreen", "Attached");
    }

    @Override
    public void render(float delta) {

        world.update(delta);
        renderer.render();

        // Covert Frame rate to String, print it
        // Gdx.app.log("GameScreen FPS", (1/delta) + "");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void dispose() {
    }
}
