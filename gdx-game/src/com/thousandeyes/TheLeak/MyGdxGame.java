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
import com.thousandeyes.TheLeak.State.GameState.*;
import com.badlogic.gdx.scenes.scene2d.*;


public class MyGdxGame  implements ApplicationListener
{
	Texture actionTexture;
	Stage stage;
	float time;
	
	@Override
	public void create()
	{
		
		GameResources.Objects.add(new CameraHolder());
		GameResources.Player = new Player(new Transform(0f, 0f, 45f, 1f, 30f,100f));
		GameResources.Objects.add(new CameraHolder());
		GameResources.SpriteBatch = new SpriteBatch();
		GameResources.HudBatch = new SpriteBatch();
		GameResources.ShapeRenderer = new ShapeRenderer();
		
		GameResources.Level1().Load();
		GameResources.Objects.add(GameResources.Player);
		
		GameResources.CurrentGameState = new LevelGameState();
		
	}

	@Override
	public void render()
	{       
		Init();
		
		
		GameResources.CurrentGameState.Update();
	
		//implementar Lightning
		//GameResources.SpriteBatch.setBlendFunction(GL20.GL_DST_COLOR, GL20.GL_SRC_ALPHA);
		//GameResources.SpriteBatch.draw(GameResources.Level.getBackground(),2,1);
		//GameResources.SpriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		GameResources.SpriteBatch.end(); 
		GameResources.CurrentGameState.UpdateUi();
		//GameResources.HudBatch.end();
		UpdateDebug();
		
	}
	private void Init()
	{
		
		time += Gdx.graphics.getDeltaTime();
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameResources.Camera.update();
		GameResources.SpriteBatch.setProjectionMatrix(GameResources.Camera.combined);
		GameResources.SpriteBatch.begin();
		//GameResources.HudBatch.begin();
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
		GameResources.CurrentGameState = new CharacterGameState(GameResources.CurrentGameState);
	}

	@Override
	public void resume()
	{
	}
}
