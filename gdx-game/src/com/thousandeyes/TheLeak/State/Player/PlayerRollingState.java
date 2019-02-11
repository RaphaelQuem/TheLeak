package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.State.GameState.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.State.Enemy.*;

public class PlayerRollingState extends BaseState
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

	public PlayerRollingState(GameObject _gameObject, boolean _left){
		
		gameObject = _gameObject;
		
		left = _left;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-rolling-spritesheet.png",3,3,0.05f,7);
		gameObject.getTransform().setTrigger(true);
		gameObject.getTransform().setTag("roll");
		
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
	
	
		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{		
			gameObject.getTransform().setTrigger(false);
			
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
	public void onTriggerEnter(Transform other)
	{
	
	}


}
