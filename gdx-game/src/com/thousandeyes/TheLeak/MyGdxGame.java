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
	
	
	float time;

	BitmapFont font;
	@Override
	public void create()
	{
		font = new BitmapFont();
		GameResources.Camera = new OrthographicCamera(1280f, 720f);
		GameResources.Camera.position.set(1280f/2f,720f/2f,10f);
		GameResources.Camera.update();
		
		texture = new Texture(Gdx.files.internal("android.jpg"));
		actionTexture = new Texture(Gdx.files.internal("bbutton.png"));

		GameResources.Player = new Player(new Transform(0f, 0f, 10f, 40f,80f,80f));
		GameResources.Player.setSpeed(5f);
		GameResources.SpriteBatch = new SpriteBatch();
		GameResources.ShapeRenderer = new ShapeRenderer();
	
		GameResources.Objects.add(GameResources.Player);
		GameResources.Objects.add(new Enemy(new Transform(500f, 0f,10f,30f,80f,80f)));
		GameResources.Objects.add(new Enemy(new Transform(900f, 300f,10f,30f,80f,100f)));
	}

	@Override
	public void render()
	{       
		Init();
		
		GameResources.SpriteBatch.draw(texture, 0, 0,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		
		for(GameObject object : GameResources.Objects)
		{
			object.Update();
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
							//objy.getState().onTriggerEnter();
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
