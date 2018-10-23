package com.thousandeyes.TheLeak.State.GameState;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.thousandeyes.TheLeak.Base.*;

public class CharacterGameState extends GameState
{
	Texture background;
	public CharacterGameState()
	{
		background = new Texture(Gdx.files.internal("character-background.png"));
	}

	@Override
	public void Update()
	{
		if(InputHandler.getActionPressed())
		{
			GameResources.CurrentGameState = new LevelGameState();
		}

		GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		
	
		
	}
	
}
