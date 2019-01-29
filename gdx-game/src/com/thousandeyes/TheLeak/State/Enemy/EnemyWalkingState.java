package com.thousandeyes.TheLeak.State.Enemy;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.State.*;

public class EnemyWalkingState implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
	private float substateTime;
	private boolean offensive;
	@Override
	public Animation getStateAnimation()
	{
		return stateAnimation;
	}

	@Override
	public Transform getCollider()
	{
		return new Transform();
	}


	@Override
	public GameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	public EnemyWalkingState(GameObject _gameObject){
		gameObject = _gameObject; 
	
		if(!this.gameObject.getName().equals("firstboss"))
		{
			stateAnimation = AnimationHelper.GetAnimationFromSpritesheet(this.gameObject.getName() + "-walking-spritesheet.png",3,2,0.1f);
			name = this.getClass().getName();
		}
	}
	@Override
	public void Update()
	{
		
		substateTime -= Gdx.graphics.getDeltaTime();
		stateTime += Gdx.graphics.getDeltaTime(); 
	
		if(substateTime<= 0f)
		{
			substateTime = MathUtils.random(2f, 7f);
			offensive =!offensive;
		}
		
		Vector2 movVector = new Vector2(GameResources.Player.getTransform().x,GameResources.Player.getTransform().y).sub(new Vector2(this.gameObject.getTransform().x, this.gameObject.getTransform().y));
		if(Math.abs(movVector.x)<=200f && offensive)
			this.gameObject.setState(new EnemyAttackState(this.gameObject));
		
		if(!this.gameObject.getFlipped() && movVector.x < 0)
			this.gameObject.setFlipped(true);
		if(this.gameObject.getFlipped() && movVector.x > 0)
			this.gameObject.setFlipped(false);
		
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
			)
			flipFrame = true;
		
		this.getStateAnimation().getKeyFrame(stateTime, true).flip(flipFrame,false);
		
		if(offensive)
			this.gameObject.getTransform().AddTransform(movVector.nor(),2);
		else
		{
			if(Math.abs(this.gameObject.getTransform().x - GameResources.Player.getTransform().x) > 500f)
				this.gameObject.setState(new EnemyIdleState(this.gameObject));
				
			this.gameObject.getTransform().AddTransform(Vectors.Invert(movVector.nor()) ,2);
			
		}
		
			
		
		if(movVector.equals(Vector2.Zero))
			gameObject.setState(new EnemyIdleState(gameObject));
			
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
		
		
	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other.getOwner()));
	}
}
