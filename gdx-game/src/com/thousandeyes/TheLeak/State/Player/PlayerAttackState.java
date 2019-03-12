package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import java.util.*;
import com.thousandeyes.TheLeak.State.*;

public class PlayerAttackState extends BaseState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private boolean combo;
	private int cols=2;
	private int rows=2;
	private float frameTime=0.1f;
	
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

	
	public PlayerAttackState(GameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-attack-spritesheet.png",rows,cols,frameTime);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName(); 
		super.setColliders(new ArrayList<Transform>());
		super.getColliders().add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y + (gameObject.getTransform().height/ 100f * 65f), 1f,5f,true, "attack", 1f));
		super.getColliders().add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y+ (gameObject.getTransform().height/ 100f * 65f), 3f,5f,true, "attack", 1f));
		super.getColliders().add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y+ (gameObject.getTransform().height/ 100f * 65f), 6f,5f,true, "attack", 1f));
		
	}
	
	
	public void Update()
	{
		super.Update();
		
		if(InputHandler.getTouched("action"))
			combo = true;
			
		float capTime = (rows*cols*frameTime)-frameTime;
		capTime= Math.min(super.getStateTime(),capTime);
		
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
		)
			flipFrame = true;
		
		
		this.getStateAnimation().getKeyFrame(super.getStateTime(), true).flip(flipFrame,false);
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(capTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		if(this.getStateAnimation().isAnimationFinished(super.getStateTime()))
		{
			if(combo)
				gameObject.setState(new PlayerAttack2State(gameObject));
			else
				gameObject.setState(new PlayerIdleState(gameObject));

		}
	}
	@Override
	public void onTriggerEnter(Transform other)
	{
		// TODO: Implement this method
	}
	
}
