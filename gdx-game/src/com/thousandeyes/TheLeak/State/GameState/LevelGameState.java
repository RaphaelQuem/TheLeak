package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.Entities.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.*;
import com.thousandeyes.TheLeak.State.Player.*;

public class LevelGameState extends GameState
{
	Touchable uiAction;
	Touchable uiCharacter;
	Touchable uiHealth;
	float healthW;
	public LevelGameState()
	{
		
		this.Touchables = new ArrayList<Touchable>();
		uiAction = new Touchable("action","ui-button-plus",GameResources.getCameraLeft()+ GameResources.Camera.viewportWidth /100f*85f, GameResources.Camera.viewportHeight/100f*15f, 15f, 15f);
		uiCharacter= new Touchable("character","facewip",GameResources.getCameraLeft(), GameResources.Camera.viewportHeight/100f*85f, 15f, 15f);
		uiHealth = new Touchable("hp","red", uiCharacter.width , GameResources.Camera.viewportHeight/100f*97f, 50f, 2f);
		
		this.Touchables.add(uiAction);	
		this.Touchables.add(uiCharacter);
		this.Touchables.add(uiHealth);
		
		healthW = Float.parseFloat(Float.toString(uiHealth.width));
		
	}
	@Override
	public void Update()
	{ 
		
		uiHealth.setWidth( GameResources.Player.getHealth() / 100f * healthW);

		
		
		if(InputHandler.getTouched(("character")))
			GameResources.CurrentGameState = new CharacterGameState(this);
		
		int i = 0;
		for(MapLayer layer : GameResources.Level.getMap().getLayers())
		{
		
			
			/*if(i ==1)
				GameResources.SpriteBatch.setBlendFunction(GL20.GL_DST_COLOR, GL20.GL_SRC_ALPHA);
			*/
			GameResources.SpriteBatch.draw(layer.getTexture(), layer.getPositionX(), 0,GameResources.Level.getWidth(), GameResources.Level.getHeight());
		
		
			i++;
		
			//GameResources.SpriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
			
			
		}
		
		Collections.sort(GameResources.Objects); 
		GameResources.Objects.addAll(GameResources.CreateObjects);
		GameResources.CreateObjects.clear();
		for(GameObject object : GameResources.Objects)
		{
			object.Update();
			object.CollisionHandle();
			
		}
		GameResources.Objects.removeAll(GameResources.DeleteObjects);
		GameResources.LockingObjects.removeAll(GameResources.DeleteObjects);
		GameResources.DeleteObjects.clear();
	
		
		
		
		TextHelper.Show(String.valueOf(GameResources.debugme).replace('.','+'),new Transform(GameResources.getCameraLeft(),0,100f,20f),32,1);
		
	}
	
}
