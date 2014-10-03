package me.montecode.game.libgdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import me.montecode.game.libgdx.gameworld.GameRenderer;
import me.montecode.game.libgdx.gameworld.GameWorld;
import me.montecode.game.libgdx.helpers.InputHandler;

/**
 * Created by stevyhacker on 26.9.14..
 */
public class GameScreen implements Screen {
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen() {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth/gameWidth);

        int midPointY = (int) (gameHeight/2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world));
        Gdx.app.log("GameScreen", "Attached");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
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
