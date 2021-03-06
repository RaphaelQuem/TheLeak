package com.thousandeyes.TheLeak.State.GameState;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;

public class CharacterGameState extends GameState
{
	GameState previousState;
	Texture background;
	
	Touchable strengthPlus;
	Touchable strengthMinus;
	Transform tStrength;

	Touchable dexterityPlus;
	Touchable dexterityMinus;
	Transform tDexterity;
	
	Touchable resistencePlus;
	Touchable resistenceMinus;
	Transform tResistence;
	
	Touchable firePowerPlus;
	Touchable firePowerMinus;
	Transform tFirePower;
	
	
	
	public CharacterGameState(GameState _previousState)
	{
		previousState = _previousState;
		
		background = new Texture(Gdx.files.internal("character-background.png"));
		this.Touchables = new ArrayList<Touchable>();
	
		strengthPlus = new Touchable("strengthplus","ui-button-plus",GameResources.Camera.viewportWidth /100f*80f, GameResources.Camera.viewportHeight/100f*25f, 5f, 10f);
		strengthMinus = new Touchable("strengthminus","ui-button-minus",GameResources.Camera.viewportWidth /100f*60f, GameResources.Camera.viewportHeight/100f*25f, 5f, 10f);
		this.Touchables.add(strengthPlus);
		this.Touchables.add(strengthMinus);
	
		dexterityPlus = new Touchable("dexterityplus","ui-button-plus",GameResources.Camera.viewportWidth /100f*80f, GameResources.Camera.viewportHeight/100f*40f, 5f, 10f);
		dexterityMinus = new Touchable("dexterityminus","ui-button-minus", GameResources.Camera.viewportWidth /100f*60f, GameResources.Camera.viewportHeight/100f*40f, 5f, 10f);
		this.Touchables.add(dexterityPlus);
		this.Touchables.add(dexterityMinus);
	
		resistencePlus = new Touchable("resistenceplus","ui-button-plus", GameResources.Camera.viewportWidth /100f*80f, GameResources.Camera.viewportHeight/100f*55f, 5f, 10f);
		resistenceMinus = new Touchable("resistenceminus","ui-button-minus", GameResources.Camera.viewportWidth /100f*60f, GameResources.Camera.viewportHeight/100f*55f, 5f, 10f);
		this.Touchables.add(resistencePlus);
		this.Touchables.add(resistenceMinus);
	
		firePowerPlus = new Touchable("firepowerplus","ui-button-plus",GameResources.Camera.viewportWidth /100f*80f, GameResources.Camera.viewportHeight/100f*70f, 5f, 10f);
		firePowerMinus = new Touchable("firepowerminus","ui-button-minus",GameResources.Camera.viewportWidth /100f*60f, GameResources.Camera.viewportHeight/100f*70f, 5f, 10f);
		this.Touchables.add(firePowerPlus);
		this.Touchables.add(firePowerMinus);
	
		
		
		
	}

	@Override
	public void Update()
	{
		tStrength = new Transform( strengthMinus.x + strengthMinus.width + GameResources.getCameraLeft(),strengthMinus.y,5f,strengthMinus.getHeightPercentage());
		tDexterity = new Transform(dexterityMinus.x + dexterityMinus.width + GameResources.getCameraLeft(),dexterityMinus.y,5f,dexterityMinus.getHeightPercentage());
		tResistence = new Transform(resistenceMinus.x + resistenceMinus.width + GameResources.getCameraLeft(),resistenceMinus.y,5f,resistenceMinus.getHeightPercentage());
		tFirePower= new Transform(firePowerMinus.x + firePowerMinus.width + GameResources.getCameraLeft(),firePowerMinus.y,5f,firePowerMinus.getHeightPercentage());
		
		GameResources.SpriteBatch.draw(background,GameResources.Camera.position.x - GameResources.Camera.viewportWidth /2f, GameResources.Camera.position.y - GameResources.Camera.viewportHeight / 2f,GameResources.Camera.viewportWidth, GameResources.Camera.viewportHeight);
		
	
		if(GameResources.Player.getSkillPoints()>0)
		{
		
			if(InputHandler.getTouched("strengthplus"))
			{
				GameResources.Player.setStrength( GameResources.Player.getStrength() +1);
				GameResources.Player.setSkillPoints(GameResources.Player.getSkillPoints()-1);
			}

			if(InputHandler.getTouched("dexterityplus"))
			{
				GameResources.Player.setDexterity( GameResources.Player.getDexterity() +1);
			}
		
			if(InputHandler.getTouched("resistenceplus"))
			{
				GameResources.Player.setResistance( GameResources.Player.getResistance() +1);
			}

			if(InputHandler.getTouched("firepowerplus"))
			{
				GameResources.Player.setFirePower( GameResources.Player.getFirePower() +1);
			}

			
			if(InputHandler.getTouched("strengthminus"))
			
				GameResources.CurrentGameState = previousState;
		
			if(InputHandler.getTouched("dexterityminus"))
				GameResources.CurrentGameState = previousState;
			
			
			
		}
		if(InputHandler.getTouched("strengthminus"))

			GameResources.CurrentGameState = previousState;
		
		
		//GameResources.SpriteBatch.draw(new Texture(Gdx.files.internal("ui-button-minus.png")),0f,0f,30f,30f);
		
		TextHelper.Show(String.valueOf(GameResources.Player.getStrength()),tStrength,1,3);
		TextHelper.Show(String.valueOf(GameResources.Player.getDexterity()),tDexterity,1,3);
		TextHelper.Show(String.valueOf(GameResources.Player.getResistance()),tResistence,1,3);
		TextHelper.Show(String.valueOf(GameResources.Player.getFirePower()),tFirePower,1,3);
		
	}
	
}	
