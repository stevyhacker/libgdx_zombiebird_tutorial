package me.montecode.game.libgdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by stevyhacker on 29.9.14..
 */
public class GameWorld {
    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    public void update(float delta) {
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
        if(rect.x>20){
           rect.y++;
        }
        Gdx.app.log("GameWorld", "update");
        if (rect.y > 205) {
            rect.y = 0;
        }
    }

    public Rectangle getRect() {
        return rect;
    }
}
