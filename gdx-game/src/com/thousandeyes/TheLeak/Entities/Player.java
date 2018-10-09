package com.thousandeyes.TheLeak.Entities;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;

public class Player implements IGameObject
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
	public void setTransform (Transform _transform)
	{
		this.transform = _transform;
	}
	@Override
	public void setState (IState _state)
	{
		this.state = _state;
	}

	@Override
	public float getSpeed()
	{
		return 5f;
	}

	

	public Player(Transform _transform){
		transform = _transform;
		transform.setOwner(this);
		state = new PlayerIdleState(this);
		
	}
	@Override
	public void Update(Float time)
	{
			
			
			state.Update(time);
			
	}

	@Override
	public Transform getCollider()
	{
		return state.getCollider();
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
