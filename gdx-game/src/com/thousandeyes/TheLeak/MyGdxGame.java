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
import java.util.*;
import android.preference.*;


public class MyGdxGame  implements ApplicationListener
{
	Texture texture;

	
	IGameObject player;
	IGameObject enemy;
	java.util.List<IGameObject> sceneObjects;
	ListIterator<IGameObject> objectIterator;
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
	
		sceneObjects = new ArrayList<IGameObject>();
		player = new Player(manPosition);
		enemy = new Enemy(ePosition);
		sceneObjects.add(player);
		sceneObjects.add(enemy);
		batch = new SpriteBatch();
		objectIterator = sceneObjects.listIterator();
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
		
		/*while(objectIterator.hasNext()){
			objectIterator.next().Update(batch, time);*/
	
		Rectangle previous = player.getTransform();
			
		player.Update(batch, time);
		enemy.Update(batch, time);
				 
		if(player.getTransform().overlaps(enemy.getTransform()))
			player.setTransform(previous);
		
		
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
