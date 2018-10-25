package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;

public class LevelGameState extends GameState
{
	public LevelGameState()
	{
		this.Touchables = new ArrayList<Touchable>();
		this.Touchables.add(new Touchable("character","bbutton",0f,0f,10f,10f));
	}
	@Override
	public void Update()
	{ 
		
		if(InputHandler.getTouched(("character")))
			GameResources.CurrentGameState = new CharacterGameState();
			
		GameResources.SpriteBatch.draw(GameResources.Level.getBackground(), 0, 0,GameResources.Level.getWidth(), GameResources.Level.getHeight());
		Collections.sort(GameResources.Objects); 
		GameResources.Objects.addAll(GameResources.CreateObjects);
		GameResources.CreateObjects.clear();
		for(GameObject object : GameResources.Objects)
		{
			object.Update();
		}
		GameResources.Objects.removeAll(GameResources.DeleteObjects);
		GameResources.LockingObjects.removeAll(GameResources.DeleteObjects);
		GameResources.DeleteObjects.clear();
		TextHelper.Show("+9-",new Transform(0,0,100f,20f),32,1);
	}
}
