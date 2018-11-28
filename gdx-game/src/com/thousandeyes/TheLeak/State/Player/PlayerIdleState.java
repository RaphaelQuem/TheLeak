package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;

public class PlayerIdleState implements IState
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
	
	public PlayerIdleState(GameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-idle-spritesheet.png",3,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
		if(InputHandler.getTouched("action"))
			gameObject.setState(new PlayerAttackState(gameObject));
		
		if(InputHandler.InputVector() != null && !InputHandler.InputVector().equals(Vector2.Zero))
			gameObject.setState(new PlayerWalkingState(gameObject));
		
	
		if(!this.gameObject.getFlipped() && InputHandler.InputVector().x < 0)
			this.gameObject.setFlipped(true);
		if(this.gameObject.getFlipped() && InputHandler.InputVector().x > 0)
			this.gameObject.setFlipped(false);
		
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
		this.gameObject.setState(new PlayerHitState(this.gameObject,other));
	}
	

}
