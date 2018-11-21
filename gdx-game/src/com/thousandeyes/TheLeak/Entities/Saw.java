package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.badlogic.gdx.math.*;

public class Saw extends GameObject
{
	private DirectionEnum direction;
	public Saw(DirectionEnum _direction, Transform _transform)
	{
		this.direction = _direction;
		this.setState(new EmptyState(this));
		this.setTransform(new Transform(_transform.x,_transform.y,10f,10f));
		this.getTransform().x -= this.getTransform().width + 1f;
		this.setStrength(7);
		GameResources.CreateObjects.add(this); 
	}

	@Override
	public void Update()
	{
		this.getTransform().AddTransform(Vectors.Left,2);
	
		if(this.getTransform().x + this.getTransform().width < GameResources.getCameraLeft() || this.getTransform().x > GameResources.getCameraRight()) 
		{
			GameResources.DeleteObjects.add(this);
		}
		
		for(GameObject objy : GameResources.Objects)
		{ 
			if(this != objy )
			{
				if(this.getTransform().overlaps(objy.getTransform()))
				{
					objy.getState().onTriggerEnter(this);
				}
			}
		}
	}
	
}
