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
	private int skillPoints;
	private int level = 1;
	private int threshold = 200;
	public Player(Transform _transform){
		this.setSpeed(5f);
		this.setTransform ( _transform);
		this.getTransform().setOwner(this);
		this.setState( new PlayerIdleState(this));
		
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getLevel()
	{
		return level;
	}

	public void setThreshold(int threshold)
	{
		this.threshold = threshold;
	}

	public int getThreshold()
	{
		return threshold;
	}

	public void setSkillPoints(int abilityPoints)
	{
		this.skillPoints = abilityPoints;
	}

	public int getSkillPoints()
	{
		return skillPoints;
	}

	public void increaseExperience(int experience)
	{
		this.experience += experience;
	
		if(this.experience > this.threshold)
		{
			this.skillPoints++;
			this.experience -= this.threshold;
			this.threshold = (int) (this.threshold*1.5f);
			this.level++;
		}
		
	}

	public int getExperience()
	{
		return experience;
	}
	
	
	
}
