package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Enemy implements IGameObject
{
	private Transform transform;
	private IState state;
	private boolean flipped;
	@Override
	public String getName(){
		return this.getClass().getName();
	};
	@Override
	public IState getState(){
		return this.state;
	};
	@Override
	public Transform getTransform(){
		return this.transform;
	}

	@Override
	public float getSpeed()
	{
		return 0;
	}

	
	@Override
	public void setState (IState _state)
	{
		this.state = _state;
	}

	@Override
	public Transform getCollider()
	{
		// TODO: Implement this method
		return state.getCollider();
	}

	
	@Override
	public void setTransform(Transform _transform)
	{
		// TODO: Implement this metho
		
	}
	public Enemy() 
	{
		transform = new Transform();
		transform.setOwner(this);
	}
	

	public Enemy(Transform _transform){
		transform = _transform;
		transform.setOwner(this);
		state = new EnemyWalkingState(this);

	}
	@Override
	public void Update(Float time){

	
		state.Update(time);

	}

	@Override
	public boolean getFlipped()
	{
		return flipped;
	}

	@Override
	public void setFlipped(boolean _flipped)
	{
		flipped =_flipped;
	}


	
}
