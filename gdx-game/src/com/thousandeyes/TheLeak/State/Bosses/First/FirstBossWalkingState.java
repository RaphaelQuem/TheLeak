package com.thousandeyes.TheLeak.State.Bosses.First;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.State.Enemy.*;

public class FirstBossWalkingState extends BaseState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
	private float a1cooldown; 
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

	public FirstBossWalkingState(GameObject _gameObject)
	{
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("firstboss-idle-spritesheet.png",2,1,0.1f);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{


		stateTime += Gdx.graphics.getDeltaTime();
		a1cooldown += Gdx.graphics.getDeltaTime();
		Vector2 movVector = new Vector2(GameResources.Player.getTransform().x,GameResources.Player.getTransform().y).sub(new Vector2(this.gameObject.getTransform().x, this.gameObject.getTransform().y));
		if(Math.abs(movVector.x)<=700f && a1cooldown > 3f)
		{
			
				a1cooldown =0;
				this.gameObject.setState(new FirstBossA1State(this.gameObject));
				//new Saw(DirectionEnum.Left, this.getGameObject().getTransform());
			
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
	public void onTriggerEnter(Transform other)
	{
		this.gameObject.setState(new FirstBossHitState(this.gameObject, other.getOwner()));
	}
}
