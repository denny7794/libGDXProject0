package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont bmf;
	Texture img;
	private final int AST_COUNT = 100;
	//Asteroid[] ast = new Asteroid[AST_COUNT];
	ArrayList<Asteroid> ast = new ArrayList<Asteroid>();
	Random rand = new Random();
	//float x;
	//float y;
	float x = 10.0f;
	float y = 80.0f;
	float c = 0.0f;
	int bang;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("asteroid.tga");
		Asteroid.setMyTexture(new Texture("asteroid.tga"));
		bmf = new BitmapFont(Gdx.files.internal("myfont.fnt"), Gdx.files.internal("myfont.png"), false);
		img = new Texture("bomber.tga");
		/*for (int i = 0; i < AST_COUNT; i++) {
			//ast[i] = new Asteroid(rand.nextInt(800), rand.nextInt(600), (3.0f * rand.nextFloat() - 0.5f), (3.0f * rand.nextFloat() - 0.5f));
			ast[i] = new Asteroid(new Vector2(rand.nextInt(800), rand.nextInt(600)), new Vector2(3.0f * (rand.nextFloat() - 0.5f), (3.0f * (rand.nextFloat() - 0.5f))));
		}*/
		for (int i = 0; i < AST_COUNT; i++) {
			ast.add(new Asteroid(new Vector2(rand.nextInt(800), rand.nextInt(600)), new Vector2(3.0f * (rand.nextFloat() - 0.5f), (3.0f * (rand.nextFloat() - 0.5f)))));
		}

	}

	float time = 0.0f;

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, InputHandler.getMousePosition().x, InputHandler.getMousePosition().y);
		time += 0.5f;
		//batch.draw(img, InputHandler.getMousePosition().x - 20, InputHandler.getMousePosition().y - 20, 20, 20, 40, 40, 2.0f, 2.0f, time, 0, 0, 40, 40, false, false);
		//batch.draw(img, ast.getX(), ast.getY());
		/*for (int i = 0; i < AST_COUNT; i++) {
			ast[i].render(batch);
		}*/
		for (int i = 0; i < ast.size(); i++) {
			ast.get(i).render(batch);
		}

		x += 65.0f * Gdx.graphics.getDeltaTime();
		c += Gdx.graphics.getDeltaTime();
		batch.draw(img, x, y);
		if(InputHandler.keyUp()) y++;

		bmf.draw(batch, "Таймер: " + (int)c + " Столкновений: " + bang, 50, 50);

		for (int i = 0; i < ast.size(); i++) {
			bmf.draw(batch, "" + i, ast.get(i).getPosition().x, ast.get(i).getPosition().y);
		}


		batch.end();
	}

	public void update(){
		for (int i = 0; i < ast.size(); i++) {
			ast.get(i).update();

		}

		/* Проверка столкновений астероидов */
		for (int i = 0; i < ast.size(); i++) {
			boolean bang_flag = false;
			for (int j = i + 1; j < ast.size(); j++) {
				if(ast.get(i).getPosition().cpy().sub(ast.get(j).getPosition().cpy()).len() < 40){
					//ast.remove(i);
					//i--;
					//j--;
					ast.remove(j--);
					//j--;
					bang_flag = true;
				}
			}
			if(bang_flag){
				ast.remove(i--);
				//i--;
				bang++;
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
