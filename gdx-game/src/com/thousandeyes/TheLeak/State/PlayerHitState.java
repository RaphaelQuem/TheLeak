package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;

public class PlayerHitState implements IState
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
	public GameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	@Override
	public Transform getCollider()
	{
		return new Transform();
	}

	public PlayerHitState(GameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("enemy-hit-spritesheet.png",5,1,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		Vector2 pushback = new Vector2(3f,0f);
		if(!this.gameObject.getFlipped())
			pushback.x *= -1f;
		this.gameObject.getTransform().AddTransform(pushback,1f);
		stateTime  += Gdx.graphics.getDeltaTime();
		
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new PlayerIdleState(gameObject));
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);
		
	}

	@Override
	public void onTriggerEnter()
	{
		// TODO: Implement this method
	}


}
