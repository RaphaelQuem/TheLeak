package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;

public class PauseGameState extends GameState
{
	Texture background;
	public PauseGameState()
	{
		background = new Texture(Gdx.files.internal("pause.png"));
	}

	@Override
	public void Update()
	{
		if(InputHandler.getTouched("action"))
		{
			GameResources.CurrentGameState = new LevelGameState();
		}
		
		GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		
	}
}
