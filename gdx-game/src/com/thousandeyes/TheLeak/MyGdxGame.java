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
	OrthographicCamera camera;
	Vector2 inputVector;
	SpriteBatch batch;
	float time;
	Transform ePosition;
	Transform manPosition;
	@Override
	public void create()
	{
		camera = new OrthographicCamera(1280f, 720f);
		camera.position.set(1280f/2f,720f/2f,10f);
		camera.update();
		texture = new Texture(Gdx.files.internal("android.jpg"));
		manPosition = new Transform(10f,40f);
		manPosition.x =300f;
		ePosition = new Transform(10f,30f);
		ePosition.x = 999;
		ePosition.y = 999;
		
		sceneObjects = new ArrayList<IGameObject>();
		player = new Player(manPosition);
		enemy = new Enemy(ePosition);
		sceneObjects.add(player);
		sceneObjects.add(enemy);
		batch = new SpriteBatch();
		objectIterator = sceneObjects.listIterator();
		GameResources.Objects.add(player);
		GameResources.Objects.add(enemy); 
	}

	@Override
	public void render()
	{       
		time += Gdx.graphics.getDeltaTime();
		
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		batch.draw(texture, 0, 0, 
				   Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		objectIterator = GameResources.Objects.listIterator();
		while(objectIterator.hasNext())
		{
			float xprevious = player.getTransform().x;
			float yprevious = player.getTransform().y;
			
			
			objectIterator.next().Update(batch,time);
		
			if(player.getTransform().overlaps(enemy.getTransform()))
			{
				player.getTransform().x = xprevious;
				player.getTransform().y = yprevious;
			}
		}
	
	
		if(Gdx.input.isTouched())
		{
			camera.zoom +=0.001f;
			camera.update();
		}
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
