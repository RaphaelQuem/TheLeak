package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Enemy implements IGameObject
{
	private Rectangle transform;
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
	public Rectangle getTransform(){
		return this.transform;
	};

	public Enemy(Rectangle _transform){
		transform = _transform;
		state = new EnemyIdleState(this);

	}
	@Override
	public void Update(SpriteBatch batch, Float time){

	
		state.Update(batch,time);

	}
}
