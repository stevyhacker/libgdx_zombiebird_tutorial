package me.montecode.game.libgdx.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import me.montecode.game.libgdx.gameobjects.Bird;
import me.montecode.game.libgdx.gameobjects.ScrollHandler;
import me.montecode.game.libgdx.helpers.AssetLoader;

/**
 * Created by stevyhacker on 29.9.14..
 */
public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 12);
    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score = 0;
    private int midPointY;

    private GameState currentState;

    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public GameWorld(int midPointY) {
        currentState = GameState.READY;
        this.midPointY = midPointY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);

    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }
    }

    private void updateReady(float delta) {


    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
        }

//        Rectangle code
//        rect.x++;
//        if (rect.x > 137) {
//            rect.x = 0;
//        }
//        if(rect.x>20){
//           rect.y++;
//        }
//        Gdx.app.log("GameWorld", "update");
//        if (rect.y > 205) {
//            rect.y = 0;
//        }
    }

    public Rectangle getRect() {
        return rect;
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

}
