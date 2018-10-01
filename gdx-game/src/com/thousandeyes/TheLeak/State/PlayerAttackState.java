package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;

public class PlayerAttackState implements IState
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
	public IGameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	public PlayerAttackState(IGameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-attack-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update(SpriteBatch batch, Float time)
	{
		if(InputHandler.InputVector() != null && !InputHandler.InputVector().equals(Vector2.Zero))
			gameObject.setState(new PlayerWalkingState(gameObject));

		batch.draw(this.getStateAnimation().getKeyFrame(time, true), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);

	}

}
