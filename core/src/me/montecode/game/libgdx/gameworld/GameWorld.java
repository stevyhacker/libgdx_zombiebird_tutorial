package me.montecode.game.libgdx.gameworld;

import com.badlogic.gdx.math.Rectangle;

import me.montecode.game.libgdx.gameobjects.Bird;

/**
 * Created by stevyhacker on 29.9.14..
 */
public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 12);
    private Bird bird;


    public GameWorld(int midPointY){
        bird = new Bird(33, midPointY - 5, 17, 12);

    }

    public void update(float delta) {

        bird.update(delta);

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

    public Bird getBird(){
        return bird;
    }
}
