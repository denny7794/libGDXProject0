package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Denis on 20.07.2016.
 */
public class InputHandler {

    public static boolean isClicked(){
        return Gdx.input.justTouched();
    }

    public static boolean isPressed(){
        return Gdx.input.isTouched();
    }

    public static Vector2 getMousePosition(){
        return new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    public static boolean keyUp(){
        return Gdx.input.isKeyPressed(Input.Keys.UP);
    }
}
