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

	static final int WORLD_WIDTH = 100;
	static final int WORLD_HEIGHT = 100;

	private OrthographicCamera cam;
	
	IGameObject player;
	//IGameObject enemy;
	java.util.List<IGameObject> sceneObjects;
	ListIterator<IGameObject> objectIterator;
	GestureDetector detector;
	Vector2 inputVector;
	SpriteBatch batch;
	float time;
	Transform ePosition;
	Transform manPosition;
	@Override
	public void create()
	{
		
		texture = new Texture(Gdx.files.internal("android.jpg"));
		manPosition = new Transform(100,100);
		manPosition.x =300;
		ePosition = new Transform(10,30);
		ePosition.x = 999;
		ePosition.y = 999;
		
		sceneObjects = new ArrayList<IGameObject>();
		player = new Player(manPosition);
		//enemy = new Enemy(ePosition);
		sceneObjects.add(player);
		//sceneObjects.add(enemy);
		batch = new SpriteBatch();
		objectIterator = sceneObjects.listIterator();
		GameResources.Objects.add(player);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(30, 30 * (h / w));

		cam.position.set(0,0, -1);
		cam.update();
		//GameResources.Objects.add(enemy); 
	}

	@Override
	public void render()
	{       
	cam.update();
		batch.setProjectionMatrix(cam.combined);
		
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		time += Gdx.graphics.getDeltaTime();
		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		
	
		float xprevious = player.getTransform().x;
		float yprevious = player.getTransform().y;
	
		cam.rotate(0.01f,0,0,1);
		player.Update(batch, time);
		//enemy.Update(batch, time);
					 
		/*if(player.getTransform().overlaps(enemy.getTransform()))
		{
			player.getTransform().x = xprevious;
			player.getTransform().y = yprevious;
		}*/
		
		
		
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
