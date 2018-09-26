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
	} 
	@Override
	public void setTransform (Rectangle _transform)
	{
		this.transform = _transform;
	}
	private float speed = 5;

	public Player(Rectangle _transform){
		transform = _transform;
		state = new PlayerIdleState(this);
		
	}
	@Override
	public void Update(SpriteBatch batch, Float time)
	{
			
			
			this.transform.y += InputHandler.InputVector().y * speed;
		    this.transform.x += InputHandler.InputVector().x * speed;
		
			
			state.Update(batch,time);
			
	}
}
