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
		super.setColliders(new ArrayList<Transform>());
		super.getColliders().add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 10f,10f,true,"attack",1f));
		super.getColliders().add(new Transform(gameObject,gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y, 20f,10f,true,"attack",1f));
		

	}
	@Override
	public void Update()
	{
	
		super.Update();
		
		if(this.getStateAnimation().isAnimationFinished(super.getStateTime()))
		{
			gameObject.setState(new EnemyIdleState(gameObject));
		}
	
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
		)
			flipFrame = true;
		

		this.getStateAnimation().getKeyFrame(super.getStateTime(), true).flip(flipFrame,false);
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(super.getStateTime(), true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
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
