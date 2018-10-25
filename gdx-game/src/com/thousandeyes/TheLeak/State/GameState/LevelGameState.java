package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;

public class LevelGameState extends GameState
{
	Texture actionTexture = new Texture(Gdx.files.internal("bbutton.png"));
	@Override
	public void Update()
	{ 
		this.Touchables = new ArrayList<Touchable>();

		this.Touchables.add(new Touchable("test","bbutton",0f,0f,10f,10f));
		if(InputHandler.getCharacterressed())
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
		for(Touchable touchable : this.Touchables)
		{
			touchable.checkTouched();
		}
		TextHelper.Show("+9-",new Transform(0,0,100f,20f),32,1);
	
		
		//UpdateUI();
	}
	private void UpdateUI()
	{
		GameResources.SpriteBatch.draw(actionTexture, InputHandler.getCharacterBounds().x,InputHandler.getCharacterBounds().y, InputHandler.getCharacterBounds().width, InputHandler.getCharacterBounds().height);
		if(!InputHandler.getActionPressed())
			GameResources.SpriteBatch.draw(actionTexture, InputHandler.getActionBounds().x, InputHandler.getActionBounds().y, InputHandler.getActionBounds().width, InputHandler.getActionBounds().height);
		GameResources.Camera.update();
	}
}
