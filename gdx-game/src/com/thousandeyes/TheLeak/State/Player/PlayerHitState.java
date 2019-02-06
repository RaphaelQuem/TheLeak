package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;

public class PlayerHitState extends IState
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

	public PlayerHitState(GameObject _gameObject, GameObject _hitter){
		this.gameObject = _gameObject;
		this.hitter = _hitter;
		this.gameObject.DecreaseHealthBy(MathUtils.random(hitter.getStrength(),hitter.getStrength()*5));
		
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("enemy-hit-spritesheet.png",5,1,0.1f);
		name = this.getClass().getName();
		
	}
	@Override
	public void Update()
	{
		if(this.gameObject.getHealth() <= 0)
		{
			gameObject.setState(new EmptyState(this.gameObject));
			return;
		}
		
		Vector2 pushback = new Vector2(3f,0f);
		if(!this.gameObject.getFlipped())
			pushback.x *= -1f;
		this.gameObject.getTransform().AddTransform(pushback,1f);
		stateTime  += Gdx.graphics.getDeltaTime();
		
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new PlayerIdleState(gameObject));
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		// TODO: Implement this method
	}


}
