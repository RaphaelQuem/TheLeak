package com.thousandeyes.TheLeak.Entities;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.Base.*;


public class Level
{ 
	private float width;
	private float height;
	private Texture backgroud;
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
	private List<SpawnTrigger> spawnTriggers;

	public  void Load()
	{
		spawnTriggers = new ArrayList<SpawnTrigger>();
		GameResources.Objects.addAll(spawnTriggers);
		GameResources.Level = this;
		
	}
		
} 
