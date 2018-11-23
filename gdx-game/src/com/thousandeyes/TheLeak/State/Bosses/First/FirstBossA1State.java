package com.thousandeyes.TheLeak.State.Bosses.First;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.State.Enemy.*;

public class FirstBossA1State implements IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
	private float yup;
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
	public GameObject getGameObject()
	{
		return gameObject;
	}
	@Override
	public String getName ()
	{
		return name;
	}

	public FirstBossA1State(GameObject _gameObject)
	{
		gameObject = _gameObject;
		yup = 300f;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-walking-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		
		float ybefore = this.gameObject.getTransform().y;
		
		this.gameObject.getTransform().AddTransform(Vectors.Up,3);
		
		float yafter = this.gameObject.getTransform().y;
	
		yup -= yafter - ybefore;
		
		if(yup<= 0f)
			this.gameObject.setState(new FirstBossWalkingState(this.gameObject));
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);



	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other));
	}
}
