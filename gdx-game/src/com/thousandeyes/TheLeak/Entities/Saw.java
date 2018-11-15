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
		this.setTransform(_transform.AddTransform(new Vector2(250,100),5f));
		GameResources.CreateObjects.add(this);
	}

	@Override
	public void Update()
	{
		
	}
	
}
