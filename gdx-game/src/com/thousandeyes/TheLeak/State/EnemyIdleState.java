package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public class EnemyIdleState implements IState
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

	public EnemyIdleState(IGameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-walking-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update( Float time)
	{
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(time, true), getGameObject().getTransform().x,getGameObject().getTransform().y, getGameObject().getTransform().width, getGameObject().getTransform().height);

	}

}
