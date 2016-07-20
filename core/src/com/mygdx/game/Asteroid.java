package com.mygdx.game;

/**
 * Created by Denis on 20.07.2016.
 */
public class Asteroid {

    private float x;
    private float y;
    private float vx;
    private float vy;

    public Asteroid(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void update(){
        x += vx;
        y += vy;
        if(x > 800) x =-40;
    }
}
