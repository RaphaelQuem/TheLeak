package com.thousandeyes.TheLeak.State.Player;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.*;

public class PlayerAttack3State extends BaseState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private float stateTime;
	private String name;
	private List<GameObject> collisions;
	private int rows=1;
	private int cols =4;
	private float frameTime =0.1f;
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

	public PlayerAttack3State(GameObject _gameObject){
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-attack3-spritesheet.png",cols,rows,frameTime);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName(); 
		super.setColliders(new ArrayList<Transform>());
		super.getColliders().add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y + (gameObject.getTransform().height/ 100f * 5f), 7f,35f,true, "attack", 5f));
		collisions = new ArrayList<GameObject>();


	}
	@Override
	public void Update()
	{
		super.Update();
		
		float capTime = (rows*cols*frameTime)-frameTime;
		capTime= Math.min(super.getStateTime(),capTime);
		
		if(this.getStateAnimation().isAnimationFinished(super.getStateTime()))
		{
			gameObject.setState(new PlayerIdleState(gameObject));
		}
		boolean flipFrame = false;
		if
		(
			this.gameObject.getFlipped() && !this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
			||
			!this.gameObject.getFlipped() && this.getStateAnimation().getKeyFrame(super.getStateTime(),true).isFlipX()
		)
			flipFrame = true;
		
		

		this.getStateAnimation().getKeyFrame(capTime, true).flip(flipFrame,false);

		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(capTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);


	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		// TODO: Implement this method
	}
}
