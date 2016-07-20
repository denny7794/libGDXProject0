package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Denis on 20.07.2016.
 */
public class Asteroid {

    private float x;
    private float y;
    private float vx;
    private float vy;
    private static Texture myTexture;

    public Asteroid(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public static void setMyTexture(Texture myTexture) {
        Asteroid.myTexture = myTexture;
    }

    public float getX() { return x; }

    public float getY() { return y; }

    public void render(SpriteBatch batch){
        batch.draw(myTexture, x, y);
    }


    public void update(){
        x += vx;
        y += vy;
        if(x < -40) x = 800;
        if(y < -40) y = 600;
        if(x > 800) x =-40;
        if(y > 600) y = -40;
    }
}
