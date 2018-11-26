package com.thousandeyes.TheLeak.State.Enemy;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import java.util.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;

public class EnemyIdleState implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
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

	public EnemyIdleState(GameObject _gameObject)
	{
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet(this.getGameObject().getName() + "-idle-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
		if(stateTime >= 1f)
			this.gameObject.setState(new EnemyWalkingState(this.gameObject));
		
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
			)
			flipFrame = true;

		this.getStateAnimation().getKeyFrame(stateTime, true).flip(flipFrame,false);
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		
		this.gameObject.setState(new EnemyHitState(this.gameObject, other));
	}
}