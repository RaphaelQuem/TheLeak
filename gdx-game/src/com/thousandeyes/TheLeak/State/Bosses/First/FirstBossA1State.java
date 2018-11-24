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

	private Animation yupAnimation;
	private Animation ydownAnimation;
	private Animation attackAnimation;
	private String name;
	private float stateTime;
	private float animTime;
	private float yup;
	private float ydown;
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
		yup = 150f;
		ydown = 0;
		animTime = 0f;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-walking-spritesheet.png",5,2,0.1f);
		yupAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstbossyup.png",5,2,0.1f);
		ydownAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstbossydown.png",5,2,0.1f);
		
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{  

		animTime += Gdx.graphics.getDeltaTime();
	
		if (ydown <= 0f)
		{
			stateAnimation = ydownAnimation;
			float ybefore = this.gameObject.getTransform().y;
		
			this.gameObject.getTransform().AddTransform(Vectors.Up,7);
		
			float yafter = this.gameObject.getTransform().y;
	
			yup -= yafter - ybefore;
		
			if(yup<= 0f) 
			{
				ydown =50f;
				animTime = 0f;
			}
		}
		else
		{
			stateAnimation = yupAnimation;
			float ybefore = this.gameObject.getTransform().y;

			this.gameObject.getTransform().AddTransform(Vectors.Down,10);

			float yafter = this.gameObject.getTransform().y;

			ydown -=  ybefore - yafter;
		
			if(ydown<= 0f) 
			{
				animTime = 0f;
				new Saw(DirectionEnum.Left, this.getGameObject().getTransform());
				yup =150f;
			}
		}
			//this.gameObject.setState(new FirstBossWalkingState(this.gameObject));
		
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(animTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);



	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other));
	}
}
