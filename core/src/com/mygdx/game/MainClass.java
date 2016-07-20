package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture img;
	Asteroid ast = new Asteroid(50, 50, 3.0f, 0.0f);
	//float x;
	//float y;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("asteroid.tga");
		Asteroid.setMyTexture(new Texture("asteroid.tga"));
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();


		//batch.draw(img, ast.getX(), ast.getY());
		ast.render(batch);


		batch.end();
	}

	public void update(){
		ast.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
