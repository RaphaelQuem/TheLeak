package com.thousandeyes.TheLeak;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.badlogic.gdx.input.*;
import org.apache.http.conn.util.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.assets.loaders.*;


public class MyGdxGame  implements ApplicationListener
{
	Texture texture;

	/*Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
	Touchpad controller = new Touchpad(5f,skin);*/
	IGameObject player;
	GestureDetector detector;
	Animation walkAnimation;
	Animation idleAnimation;
	Vector2 inputVector;
	SpriteBatch batch;
	float time;
	Rectangle manPosition;
	//AnimationHelper animationHelper;
	@Override
	public void create()
	{
		//animationHelper = new AnimationHelper();
		texture = new Texture(Gdx.files.internal("android.jpg"));
		manPosition = new Rectangle();
		manPosition.width = 150;
		manPosition.height = 300;
		//walkAnimation = animationHelper.GetAnimationFromSpritesheet("hero-walking-spritesheet.png",5,2,0.1f);
		//idleAnimation = animationHelper.GetAnimationFromSpritesheet("hero-idle-spritesheet.png",5,2,0.1f);
		player = new Player(manPosition);
		batch = new SpriteBatch();
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		time += Gdx.graphics.getDeltaTime();
		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);

		
				  
		player.Update(batch,time);
			
		batch.end();
	
		
}
	@Override
	public void dispose()
	{
	}
	
	
	@Override
	public void resize(int width, int height)
	{
	}
	
	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
