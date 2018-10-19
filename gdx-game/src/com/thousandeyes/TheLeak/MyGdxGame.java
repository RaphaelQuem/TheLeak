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
	Texture actionTexture;
	
	
	float time;
	@Override
	public void create()
	{
		
		
		actionTexture = new Texture(Gdx.files.internal("bbutton.png"));
		GameResources.Objects.add(new CameraHolder());
		GameResources.Player = new Player(new Transform(0f, 0f, 10f, 40f,80f,80f));
		GameResources.Objects.add(new CameraHolder());
		GameResources.SpriteBatch = new SpriteBatch();
		GameResources.ShapeRenderer = new ShapeRenderer();
		
		GameResources.Level1().Load();
		GameResources.Objects.add(GameResources.Player);
			
	}

	@Override
	public void render()
	{       
		Init();
		
		GameResources.SpriteBatch.draw(GameResources.Level.getBackground(), 0, 0,GameResources.Level.getWidth(), GameResources.Level.getHeight());
		Collections.sort(GameResources.Objects);
		GameResources.Objects.addAll(GameResources.CreateObjects);
		GameResources.CreateObjects.clear();
		for(GameObject object : GameResources.Objects)
		{
			object.Update();
		}
		GameResources.Objects.removeAll(GameResources.DeleteObjects);
		GameResources.DeleteObjects.clear();
		
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
			GameResources.SpriteBatch.draw(actionTexture, InputHandler.getActionBounds().x, InputHandler.getActionBounds().y, InputHandler.getActionBounds().width, InputHandler.getActionBounds().height);
		GameResources.Camera.update();
	}
	private void UpdateDebug()
	{
		if(GameResources.Debug) 
		{

			GameResources.ShapeRenderer.setProjectionMatrix(GameResources.Camera.combined);
			GameResources.ShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
			Gdx.gl20.glLineWidth(4);
			for(GameObject obj : GameResources.Objects)
			 {
				 
				 GameResources.ShapeRenderer.setColor(1f,0f,0f,0f);
				 GameResources.ShapeRenderer.rect(obj.getTransform().x,obj.getTransform().y,obj.getTransform().width, obj.getTransform().height);
				 GameResources.ShapeRenderer.setColor(0f,1f,0f,0f);
				 for(GameObject objy : GameResources.Objects)
				 { 
					if(obj!= objy)
					{
				 		if(obj.getCollider().overlaps(objy.getTransform()))
				 		{
				 			GameResources.ShapeRenderer.setColor(0f,0f,1f,0f);
						}
					}
				 }
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
