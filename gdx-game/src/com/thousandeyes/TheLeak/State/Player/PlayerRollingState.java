package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.State.GameState.*;

public class PlayerRollingState implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
	private boolean left;
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

	public PlayerRollingState(GameObject _gameObject, boolean _left){
		gameObject = _gameObject;
		left = _left;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-running-spritesheet.png",3,3,0.09f,8);


		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
	
	
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{		
			gameObject.setState(new PlayerIdleState(gameObject));
		}
	
		
		
		this.gameObject.getTransform().AddTransform(new Vector2(5*(left?-1:1),0),this.gameObject.getSpeed());
		

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
	
	}


}