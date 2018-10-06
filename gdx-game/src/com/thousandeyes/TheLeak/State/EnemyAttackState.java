package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import java.util.*;

public class EnemyAttackState implements IState
{
	private Animation stateAnimation;
	private IGameObject gameObject;
	private float stateTime;
	private String name;
	private List<Transform> colliders;
	@Override
	public Animation getStateAnimation()
	{
		return stateAnimation;
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

	@Override
	public Transform getCollider()
	{
		double i = Math.floor(stateAnimation.getKeyFrameIndex(stateTime)/(stateAnimation.getKeyFrames().length/colliders.size()));
		return colliders.get((int)i);
	}


	public EnemyAttackState(IGameObject _gameObject){
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-attack-spritesheet.png",5,2,0.1f);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName();
		colliders = new ArrayList<Transform>();
		colliders.add(new Transform(gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 10f,10f));
		colliders.add(new Transform(gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 20f,10f));

	}
	@Override
	public void Update( Float time)
	{
		stateTime  += Gdx.graphics.getDeltaTime();
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new EnemyIdleState(gameObject));
		}


		GameResources.SpriteBatch.draw(this.getStateAnimation().getKeyFrame(stateTime), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);

	}

	@Override
	public void onTriggerEnter()
	{
		// TODO: Implement this method
	}


}
