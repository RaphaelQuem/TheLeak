package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.State.GameState.*;

public class PlayerWalkingState extends BaseState
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

	public PlayerWalkingState(GameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-walking-spritesheet.png",3,3,0.1f,8);
		name = this.getClass().getName();
		stateTime = 0f;
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
		this.gameObject.getTransform().AddTransform(InputHandler.InputVector(),this.gameObject.getSpeed());
		boolean flipFrame = false;
		if(!this.gameObject.getFlipped() && InputHandler.InputVector().x < 0)
			this.gameObject.setFlipped(true);
		if(this.gameObject.getFlipped() && InputHandler.InputVector().x > 0)
			this.gameObject.setFlipped(false);
		
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(stateTime,true).isFlipX()
		)
			flipFrame = true;
			
		if(InputHandler.InputVector()==null || InputHandler.InputVector().equals(Vector2.Zero))
			gameObject.setState(new PlayerIdleState(gameObject));
		
		
		if(InputHandler.getTouched("LeftSwipeForward") )
			GameResources.Player.setState(new PlayerRunningState(GameResources.Player,false));

		if(InputHandler.getTouched("LeftSwipeBack")) 
			GameResources.Player.setState(new PlayerRunningState(GameResources.Player,true));
		
		if(InputHandler.getTouched("RightSwipeForward"))
			GameResources.CurrentGameState = new CharacterGameState(GameResources.CurrentGameState);
		
		this.getStateAnimation().getKeyFrame(stateTime, true).flip(flipFrame,false);
			
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		if(other.getTag() == "attack")
			this.gameObject.setState(new PlayerHitState(this.gameObject,other.getOwner()));
		
	}

	}