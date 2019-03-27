package com.thousandeyes.TheLeak.State.Bosses.First;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.State.Enemy.*;

public class FirstBossA1State extends BaseState
{
	private Animation stateAnimation;
	private GameObject gameObject;  

	private Animation yupAnimation;
	private Animation ydownAnimation;
	private Animation attackAnimation;
	int jumps;
	private String name;
	private float stateTime;
	private float animTime;
	private float yup;
	private float ydown;
	private boolean bottom;
	private boolean launchSaw;
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

	public FirstBossA1State(GameObject _gameObject)
	{
		gameObject = _gameObject;
		yup = 150f;
		ydown = 0;
		animTime = 0f;
		jumps = 0;
		bottom = false;
		launchSaw = false;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-walking-spritesheet.png",5,2,0.1f);
		yupAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstbossyup.png",5,2,0.1f);
		ydownAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-attack-spritesheet.png",2,2,0.1f);
		attackAnimation = AnimationHelper.GetAnimationFromSpritesheet("datascavenger-attack-spritesheet.png",1,3,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{  
		
		animTime += Gdx.graphics.getDeltaTime();
		if(!launchSaw)
		{
			if(bottom)
			{
				if(jumps > 3 )
					this.gameObject.setState(new FirstBossWalkingState(this.gameObject));
	
				if (ydown <= 0f)
				{
					stateAnimation = yupAnimation;
					float ybefore = this.gameObject.getTransform().y;
		
					this.gameObject.getTransform().AddTransform(Vectors.Up,7);
		
					float yafter = this.gameObject.getTransform().y;
	
					yup -= yafter - ybefore;
			
					if(yup<= 0f) 
					{
						jumps++;
						ydown =50f;
						animTime = 0f;
					}
				}
				else
				{
					stateAnimation = ydownAnimation;
					float ybefore = this.gameObject.getTransform().y;

					this.gameObject.getTransform().AddTransform(Vectors.Down,2);

					float yafter = this.gameObject.getTransform().y;
	
					ydown -=  ybefore - yafter;
		
					if(ydown<= 0f) 
					{
						animTime = 0f;
						stateAnimation = attackAnimation;
						yup =150f;
						launchSaw = true;
					}
				}
				//this.gameObject.setState(new FirstBossWalkingState(this.gameObject));
			}
			else
			{
				this.gameObject.getTransform().AddTransform(Vectors.Down,5f);
				if(this.gameObject.getTransform().y <=  MathUtils.random(0,50))
				{
					new Saw(DirectionEnum.Left, this.getGameObject().getTransform());
				
					bottom = true;
				}
			}
		}
		else
		{
			if(stateAnimation.isAnimationFinished(animTime))
			{
				animTime = 0f;
				launchSaw = false;
				new Saw(DirectionEnum.Left, this.getGameObject().getTransform());
			}
			
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(animTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);



	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		this.gameObject.setState(new FirstBossHitState(this.gameObject, other.getOwner()));
	}
}
