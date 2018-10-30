package com.thousandeyes.TheLeak.Entities;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.Base.*;


public class Level
{ 
	private SpawnTrigger[] spawnTriggers;
	private float leftLimit;
	private float rightLimit;
	private float width;
	private float height;
	private Texture backgroud;
	public void setLeftLimit(float _leftLimit)
	{
		this.leftLimit = _leftLimit;
	}
	public void setRightLimit(float _rightLimit)
	{
		this.rightLimit = _rightLimit;
	}
	public void setWidth(float _width)
	{
		 this.width = _width;
	}
	public void setHeight(float _height)
	{
		this.height = _height;
	}
	public void setBackground(Texture _background)
	{
		this.backgroud = _background;
	}
	public void setSpawnTriggers(SpawnTrigger... triggers)
	{
		this.spawnTriggers = triggers;
	}
	public float getLeftLimit()
	{
		return this.leftLimit;
	}
	public float getRightLimit()
	{
		return this.rightLimit;
	}
	public float getWidth()
	{
		return this.width;
	}
	public float getHeight()
	{
		return this.height;
	}
	public Texture getBackground()
	{
		return this.backgroud;
	}
	public SpawnTrigger[] getSpawnTriggers()
	{
		return this.spawnTriggers;
	}

	public  void Load()
	{
		//GameResources.Objects.addAll(ListArray(spawnTriggers));
		GameResources.Level = this;
		
	}
		
} 
