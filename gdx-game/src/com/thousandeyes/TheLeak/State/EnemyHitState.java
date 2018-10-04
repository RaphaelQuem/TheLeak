package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;

public class EnemyHitState implements IState
{
	private Animation stateAnimation;
	private IGameObject gameObject;
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
	public IGameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	public EnemyHitState(IGameObject _gameObject){
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("enemy-hit-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update( Float time)
	{
		stateTime  += Gdx.graphics.getDeltaTime();
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new EnemyIdleState(gameObject));
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);

	}

	@Override
	public void onTriggerEnter()
	{
		// TODO: Implement this method
	}


}
