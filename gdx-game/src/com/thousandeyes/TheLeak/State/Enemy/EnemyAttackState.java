package com.thousandeyes.TheLeak.State.Enemy;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import java.util.*;
import com.thousandeyes.TheLeak.State.*;

public class EnemyAttackState implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private float stateTime;
	private String name;
	private List<Transform> colliders;

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
		double i = Math.floor(stateAnimation.getKeyFrameIndex(stateTime)/(stateAnimation.getKeyFrames().length/colliders.size()));
		Transform collider = colliders.get((int)i);
		if(this.gameObject.getFlipped())
		{
			return new Transform(collider.x - collider.width - this.gameObject.getTransform().width, collider.y,collider.getWidthPercentage(), collider.getHeightPercentage(),true,"attack",1f);
		}
		return collider;
	}


	public EnemyAttackState(GameObject _gameObject){
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet(this.getGameObject().getName()+"-attack-spritesheet.png",6,1,0.1f);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName();
		colliders = new ArrayList<Transform>();
		colliders.add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 10f,10f,true));
		colliders.add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 20f,10f,true));
		

	}
	@Override
	public void Update()
	{
		stateTime  += Gdx.graphics.getDeltaTime();
		
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new EnemyIdleState(gameObject));
		}
	
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
	public void onTriggerEnter(Transform other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other.getOwner()));
	}
}
