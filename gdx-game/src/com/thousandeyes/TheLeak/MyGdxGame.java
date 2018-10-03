package com.thousandeyes.TheLeak;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.badlogic.gdx.input.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.assets.loaders.*;
import java.util.*;
import android.preference.*;
import com.badlogic.gdx.graphics.glutils.*;
import android.os.*;


public class MyGdxGame  implements ApplicationListener
{
	Texture texture;
	Texture actionTexture;
	
	
	IGameObject player;
	IGameObject enemy;
	java.util.List<IGameObject> sceneObjects;
	
	float time;
	Transform ePosition;
	Transform manPosition;
	@Override
	public void create()
	{
		GameResources.Camera = new OrthographicCamera(1280f, 720f);
		GameResources.Camera.position.set(1280f/2f,720f/2f,10f);
		GameResources.Camera.update();
		
		texture = new Texture(Gdx.files.internal("android.jpg"));
		actionTexture = new Texture(Gdx.files.internal("bbutton.png"));
		manPosition = new Transform(10f,40f);
		manPosition.x =300f;
		ePosition = new Transform(10f,30f);
		ePosition.x = 500f;
		
		
		sceneObjects = new ArrayList<IGameObject>();
		player = new Player(manPosition);
		enemy = new Enemy(ePosition);
		sceneObjects.add(player);
		sceneObjects.add(enemy);
		
		GameResources.SpriteBatch = new SpriteBatch();
		GameResources.ShapeRenderer = new ShapeRenderer();
	
		GameResources.Objects.add(player);
		GameResources.Objects.add(enemy);
	}

	@Override
	public void render()
	{       
		Init();
		
		GameResources.SpriteBatch.draw(texture, 0, 0,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		CheckCollisions();
	
		for(IGameObject object : GameResources.Objects)
		{
			object.Update(time);
		}
		
		UpdateUI();
		GameResources.SpriteBatch.end();
		UpdateDebug();
	
		
	}
	private void Init()
	{
		time += Gdx.graphics.getDeltaTime();
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameResources.SpriteBatch.setProjectionMatrix(GameResources.Camera.combined);
		GameResources.SpriteBatch.begin();
	}
	private void UpdateUI()
	{
		if(!InputHandler.getActionPressed())
			GameResources.SpriteBatch.draw(actionTexture, InputHandler.actionBounds.x, InputHandler.actionBounds.y, InputHandler.actionBounds.width, InputHandler.actionBounds.height);
		
	}
	private void CheckCollisions()
	{
		for(Transform t : GameResources.TransformInstances)
		{ t.CheckColisions();
			}
	}
	private void UpdateDebug()
	{
		if(GameResources.Debug) 
		{

			GameResources.ShapeRenderer.setProjectionMatrix(GameResources.Camera.combined);
			GameResources.ShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
			Gdx.gl20.glLineWidth(4);
			for(IGameObject obj : GameResources.Objects)
			 {
				 
				 GameResources.ShapeRenderer.setColor(1f,0f,0f,0f);
				 GameResources.ShapeRenderer.rect(obj.getTransform().x,obj.getTransform().y,obj.getTransform().width, obj.getTransform().height);
				 if(obj.getCollider().IsColliding())
				 	GameResources.ShapeRenderer.setColor(0f,0f,1f,0f);
				 else
					 GameResources.ShapeRenderer.setColor(0f,1f,0f,0f);
				 GameResources.ShapeRenderer.rect(obj.getCollider().x,obj.getCollider().y,obj.getCollider().width, obj.getCollider().height);
			 }
			 GameResources.ShapeRenderer.end();
		}
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
