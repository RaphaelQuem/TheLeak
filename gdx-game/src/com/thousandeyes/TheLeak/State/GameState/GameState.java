package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;


public class GameState
{ 
	public void Update(){ }
	public List<Touchable> Touchables;
	public void UpdateUi()
	{
		if(GameResources.HudCamera == null)
		{
			GameResources.HudCamera = new OrthographicCamera(1280f, 720f);
			GameResources.HudCamera.position.set(1280f/2f,720f/2f,10f);
			GameResources.HudCamera.update();
		}
	
		
		GameResources.HudBatch.setProjectionMatrix(GameResources.HudCamera.combined);
		GameResources.HudBatch.begin();
		for(Touchable touchable : this.Touchables)
		{
			touchable.checkTouched();
		}
		
		
		GameResources.HudBatch.end();
	}
}
