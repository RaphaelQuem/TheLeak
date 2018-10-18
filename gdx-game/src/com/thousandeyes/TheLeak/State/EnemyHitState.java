package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;

public class EnemyHitState implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private GameObject hitter;
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

	public EnemyHitState(GameObject _gameObject, GameObject _hitter){
		stateTime = 0f;
		this.gameObject = _gameObject;
		this.hitter = _hitter;
		this.gameObject.DecreaseHealthBy(MathUtils.random(hitter.getStrength(),hitter.getStrength()*5));
		
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
			if(this.gameObject.getHealth() <= 0)
			{
				gameObject.setState(new EmptyState(this.gameObject));
				return;
			}
			gameObject.setState(new EnemyIdleState(this.gameObject));
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other));
		
	}

	

	

}
