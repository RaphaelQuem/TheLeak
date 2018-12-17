package com.thousandeyes.TheLeak.Entities;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.thousandeyes.TheLeak.State.Player.*;

public class Player extends GameObject
{
	private int experience;
	private int abilityPoints;
	public Player(Transform _transform){
		this.setSpeed(5f);
		this.setTransform ( _transform);
		this.getTransform().setOwner(this);
		this.setState( new PlayerIdleState(this));
		
	}

	public void setAbilityPoints(int abilityPoints)
	{
		this.abilityPoints = abilityPoints;
	}

	public int getAbilityPoints()
	{
		return abilityPoints;
	}

	public void increaseExperience(int experience)
	{
		this.experience += experience;
	}

	public int getExperience()
	{
		return experience;
	}
	
	
	
}
