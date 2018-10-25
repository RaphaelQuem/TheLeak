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
		this.Touchables.add(new Touchable("character","bbutton",0f,0f,10f,10f));
		
	}

	@Override
	public void Update()
	{
		if(InputHandler.getTouched("character"))
			GameResources.CurrentGameState = new LevelGameState();
		if(InputHandler.getTouched("action"))
			GameResources.Player.setStrength( GameResources.Player.getStrength() +1);
		

		GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		TextHelper.Show(Integer.toString(GameResources.Player.getStrength()),new Transform(0,0,10,10),2,1);
		
	}
	
}	
