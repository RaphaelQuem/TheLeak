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
	private float cooldown;
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
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-walking-spritesheet.png",5,2,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{


		stateTime += Gdx.graphics.getDeltaTime();
		cooldown += Gdx.graphics.getDeltaTime();
		Vector2 movVector = new Vector2(GameResources.Player.getTransform().x,GameResources.Player.getTransform().y).sub(new Vector2(this.gameObject.getTransform().x, this.gameObject.getTransform().y));
		if(Math.abs(movVector.x)<=700f)
		{
			if(cooldown > 2.5f) 
			{
				cooldown =0;
				new Saw(DirectionEnum.Left, this.getGameObject().getTransform());
			}
		}
		else
		{
			if(!this.gameObject.getFlipped() && movVector.x < 0)
				this.gameObject.setFlipped(true);
			if(this.gameObject.getFlipped() && movVector.x > 0)
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


			this.gameObject.getTransform().AddTransform(movVector.nor(),2);
		}
		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);



	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		this.gameObject.setState(new EnemyHitState(this.gameObject, other));
	}
}
