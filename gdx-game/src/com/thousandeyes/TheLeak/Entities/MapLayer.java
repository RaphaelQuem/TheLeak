package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.graphics.*;
public class MapLayer
{
	private float paralaxSpeed;
	private Texture texture;
	private float positionX;

	public void setPositionX(float positionX)
	{
		this.positionX = positionX;
	}

	public float getPositionX()
	{
		return positionX;
	}
	
	public void setParalaxSpeed(float paralaxSpeed)
	{
		this.paralaxSpeed = paralaxSpeed;
	}

	public float getParalaxSpeed()
	{
		return paralaxSpeed;
	}

	public void setTexture(Texture texture)
	{
		this.texture = texture;
	}

	public Texture getTexture()
	{
		return texture;
	}}
