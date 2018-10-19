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
		GameResources.SpriteBatch.draw(background, 0, 0,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		/*
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
		*/
	}
}
