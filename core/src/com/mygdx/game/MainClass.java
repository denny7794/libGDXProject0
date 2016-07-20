package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x;
	float y;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("asteroid.tga");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		x += 1.5;
		y++;
		batch.draw(img, x, y);



		batch.end();
	}

	public void update(){
		x ++;
		y++;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
