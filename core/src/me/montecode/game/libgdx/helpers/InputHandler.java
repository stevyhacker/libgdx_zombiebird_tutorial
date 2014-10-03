package me.montecode.game.libgdx.helpers;

import com.badlogic.gdx.InputProcessor;

import me.montecode.game.libgdx.gameobjects.Bird;
import me.montecode.game.libgdx.gameworld.GameWorld;

/**
 * Created by stevyhacker on 30.9.14..
 */
public class InputHandler implements InputProcessor {

    private GameWorld gameWorld;
    private Bird myBird;

    public InputHandler(GameWorld gameWorld){
        this.gameWorld = gameWorld;
        this.myBird = gameWorld.getBird();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (gameWorld.isReady()) {
            gameWorld.start();
        }

        myBird.onClick();

        if (gameWorld.isGameOver()) {
            // Reset all variables, go to GameState.READ
            gameWorld.restart();
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
