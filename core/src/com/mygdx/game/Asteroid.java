package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis on 20.07.2016.
 */
public class Asteroid {

    private Vector2 position;
    private Vector2 velocity;
    /*private float x;
    private float y;
    private float vx;
    private float vy;*/
    private static Texture myTexture;

    /*public Asteroid(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }*/

    public Asteroid(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public static void setMyTexture(Texture myTexture) {
        Asteroid.myTexture = myTexture;
    }

    //public float getX() { return x; }

    //public float getY() { return y; }

    public void render(SpriteBatch batch){
        //batch.draw(myTexture, x, y);
        batch.draw(myTexture, position.x, position.y);
    }


    public void update(){
        position.add(velocity);
        //x += vx;
        //y += vy;
        if(position.x < -myTexture.getWidth()) position.x = Gdx.graphics.getWidth();
        if(position.y < -myTexture.getHeight()) position.y = Gdx.graphics.getHeight();
        if(position.x > Gdx.graphics.getWidth()) position.x =-myTexture.getWidth();
        if(position.y > Gdx.graphics.getHeight()) position.y = -myTexture.getHeight();

        if(InputHandler.isPressed()){
            if(position.cpy().sub(InputHandler.getMousePosition()).len() < 150)
                velocity = position.cpy().sub(InputHandler.getMousePosition()).nor().scl(5.0f);
        }
    }
}
