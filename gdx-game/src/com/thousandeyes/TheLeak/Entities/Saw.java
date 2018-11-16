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
		this.setTransform(new Transform(_transform.x - this.getTransform().width,_transform.y,10,10));
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
		
	}
	
}
