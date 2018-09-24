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
	private Animation[] animations;
	private float speed = 5;

	public Player(Rectangle transform){
		Transform = transform;
		State = new PlayerIdleState(this);
		
	}

	public void Update(SpriteBatch batch, Float time){
		
			Transform.y += InputHandler.InputVector().y * speed;
		    Transform.x += InputHandler.InputVector().x * speed;
			State.Update(batch,time);
			
	}
}
