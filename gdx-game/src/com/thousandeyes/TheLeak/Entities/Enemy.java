package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Enemy implements IGameObject
{
	private Transform transform;
	private IState state;
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
	public void setState (IState _state)
	{
		this.state = _state;
	}
	@Override
	public void setTransform(Transform _transform)
	{
		// TODO: Implement this metho
		
	}

	

	public Enemy(Transform _transform){
		transform = _transform;
		transform.setOwner(this);
		state = new EnemyIdleState(this);

	}
	@Override
	public void Update(SpriteBatch batch, Float time){

	
		state.Update(batch,time);

	}
}
