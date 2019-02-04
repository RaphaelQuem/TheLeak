package com.thousandeyes.TheLeak.State.Player;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.*;

public class PlayerAttack3State implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private float stateTime;
	private String name;
	private List<Transform> colliders;
	private List<GameObject> collisions;
	private boolean combo;
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
		double i = Math.floor(stateAnimation.getKeyFrameIndex(stateTime)/(stateAnimation.getKeyFrames().length/colliders.size()));
		Transform collider = colliders.get((int)i);
		if(this.gameObject.getFlipped())
		{
			return new Transform(collider.x - collider.width - this.gameObject.getTransform().width, collider.y,collider.getWidthPercentage(), collider.getHeightPercentage());
		}
		return collider;
	}


	public PlayerAttack3State(GameObject _gameObject){
		stateTime = 0f;
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-attack3-spritesheet.png",3,1,0.1f);
		stateAnimation.setPlayMode(Animation.PlayMode.NORMAL);
		name = this.getClass().getName(); 
		colliders = new ArrayList<Transform>();
		colliders.add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y + (gameObject.getTransform().height/ 100f * 65f), 1f,5f,true, "attack", 1f));
		colliders.add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y+ (gameObject.getTransform().height/ 100f * 65f), 3f,5f,true, "attack", 1f));
		colliders.add(new Transform(gameObject, gameObject.getTransform().x +gameObject.getTransform().width, gameObject.getTransform().y+ (gameObject.getTransform().height/ 100f * 65f), 6f,5f,true, "attack", 1f));
		collisions = new ArrayList<GameObject>();


	}
	@Override
	public void Update()
	{
		stateTime  += Gdx.graphics.getDeltaTime();
		

		if(this.getStateAnimation().isAnimationFinished(stateTime))
		{
			gameObject.setState(new PlayerIdleState(gameObject));
		}
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
		// TODO: Implement this method
	}
}
