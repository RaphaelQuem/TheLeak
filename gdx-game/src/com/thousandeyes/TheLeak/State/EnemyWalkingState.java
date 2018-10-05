package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;

public class EnemyWalkingState implements IState
{
	private Animation stateAnimation;
	private IGameObject gameObject;
	private String name;
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
	public IGameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	public EnemyWalkingState(IGameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-walking-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update( Float time)
	{
		
		Vector2 movVector = new Vector2(GameResources.Player.getTransform().x,GameResources.Player.getTransform().y).sub(new Vector2(this.gameObject.getTransform().x, this.gameObject.getTransform().y));
		this.gameObject.getTransform().AddTransform(movVector.nor(),2);
		
		if(!movVector.equals(Vector2.Zero))
			gameObject.setState(new PlayerIdleState(gameObject));

		GameResources.SpriteBatch.draw(this.getStateAnimation().getKeyFrame(time, true), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);

	}

	@Override
	public void onTriggerEnter()
	{
		// TODO: Implement this method
	}



}
