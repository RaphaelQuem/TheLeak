package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Enemy extends GameObject
{
	public Enemy() 
	{
		this.setTransform(new Transform());
		this.getTransform().setOwner(this);
	}
	

	public Enemy(Transform _transform){
		this.setTransform (_transform);
		this.getTransform().setOwner(this);
		this.setState (new EnemyWalkingState(this));

	}
}
