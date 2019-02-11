package com.thousandeyes.TheLeak.State.Enemy;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import java.util.*;
import com.thousandeyes.TheLeak.State.*;

public class EnemyAttackState extends BaseState
{
	private Animation stateAnimation;
	private GameObject gameObject;
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

	public EnemyAttackState(GameObject _gameObject){
		
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet(this.getGameObject().getName()+"-attack-spritesheet.png",6,1,0.1f);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName();
		colliders = new ArrayList<Transform>();
		colliders.add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 10f,10f,true,"attack",1f));
		colliders.add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 20f,10f,true,"attack",1f));
		

	}
	@Override
	public void Update()
	{
	
		super.Update();
		
		if(this.getStateAnimation().isAnimationFinished(super.stateTime))
		{
			gameObject.setState(new EnemyIdleState(gameObject));
		}
	
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(super.stateTime,true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(super.stateTime,true).isFlipX()
		)
			flipFrame = true;
		

		this.getStateAnimation().getKeyFrame(super.stateTime, true).flip(flipFrame,false);
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(super.stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(Transform other)
	{

		if(other.getTag() == "roll")
			this.gameObject.setState(new EnemyConfusedState(this.gameObject));
		
		if(other.getTag() == "attack")
			this.gameObject.setState(new EnemyHitState(this.gameObject, other.getOwner()));
	}
}
