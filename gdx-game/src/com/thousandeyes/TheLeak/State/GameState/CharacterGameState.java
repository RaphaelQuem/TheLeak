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
		this.Touchables.add(new Touchable("strength","facewip",GameResources.getCameraLeft() + GameResources.Camera.viewportWidth /100f*85f, GameResources.Camera.viewportHeight/100f*15f, 15f, 15f));
		
		
	}

	@Override
	public void Update()
	{
		//GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
	
		
		if(InputHandler.getTouched("strength"))
			GameResources.Player.setStrength( GameResources.Player.getStrength() +1);
		
	}
	
}	
