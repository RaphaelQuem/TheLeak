package com.thousandeyes.TheLeak.State.GameState;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;

public class CharacterGameState extends GameState
{
	
	Texture background;
	public CharacterGameState()
	{
		background = new Texture(Gdx.files.internal("character-background.png"));
		this.Touchables = new ArrayList<Touchable>();
		this.Touchables.add(new Touchable("strengthplus","ui-button-plus",GameResources.getCameraLeft() + GameResources.Camera.viewportWidth /100f*65f, GameResources.Camera.viewportHeight/100f*15f, 5f, 10f));
		this.Touchables.add(new Touchable("strengthminus","ui-button-minus",GameResources.getCameraLeft() + GameResources.Camera.viewportWidth /100f*45f, GameResources.Camera.viewportHeight/100f*15f, 5f, 10f));
		
		
	}

	@Override
	public void Update()
	{
		GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
	
		if(InputHandler.getTouched("strengthminus"))
			GameResources.CurrentGameState = new LevelGameState();
		
		if(InputHandler.getTouched("strengthplus"))
			GameResources.Player.setStrength( GameResources.Player.getStrength() +1);
		//GameResources.SpriteBatch.draw(new Texture(Gdx.files.internal("ui-button-minus.png")),0f,0f,30f,30f);
		
		//TextHelper.Show(GameResources.CurrentGameState.getClass().getSimpleName(),new Transform(0f,0f,50f,50f),1,32);
	}
	
}	
