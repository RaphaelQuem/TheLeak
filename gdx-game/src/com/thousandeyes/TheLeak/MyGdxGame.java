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

	
	IGameObject player;
	IGameObject enemy;
	
	GestureDetector detector;
	Vector2 inputVector;
	SpriteBatch batch;
	float time;
	Rectangle ePosition;
	Rectangle manPosition;
	@Override
	public void create()
	{
		
		texture = new Texture(Gdx.files.internal("android.jpg"));
		manPosition = new Rectangle();
		manPosition.width = 150;
		manPosition.height = 300;
	manPosition.x =100;
		ePosition = new Rectangle();
		ePosition.width = 150;
		ePosition.height = 300;
	
		
		player = new Player(manPosition);
		enemy = new Player(ePosition);
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
		enemy.Update(batch,time);
			
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
