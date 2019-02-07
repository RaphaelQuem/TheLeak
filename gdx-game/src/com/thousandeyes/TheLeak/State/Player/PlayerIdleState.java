package com.thousandeyes.TheLeak.State.Player;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.*;
import android.hardware.input.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.State.GameState.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;

public class PlayerIdleState extends IState
{
	private Animation stateAnimation;
	private GameObject gameObject;
	private String name;
	private float stateTime;
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

	public PlayerIdleState(GameObject _gameObject){
		gameObject = _gameObject;
		stateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-idle-spritesheet.png",3,2,0.16f);

		//TextHelper.Show(String.valueOf(test),new Transform(0,0,10,10),3,3);
		name = this.getClass().getName();
	}
	@Override
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
		if(InputHandler.getTouched("action"))
			gameObject.setState(new PlayerAttackState(gameObject));
		
		if(InputHandler.InputVector() != null && !InputHandler.InputVector().equals(Vector2.Zero))
			gameObject.setState(new PlayerWalkingState(gameObject));
	
		if(InputHandler.getTouched("LeftSwipeForward") )
			GameResources.Player.setState(new PlayerRunningState(GameResources.Player,false));

		if(InputHandler.getTouched("LeftSwipeBack")) 
			GameResources.Player.setState(new PlayerRunningState(GameResources.Player,true));
	
		if(InputHandler.getTouched("RightSwipeForward"))
			GameResources.Player.setState(new PlayerRollingState(GameResources.Player,false));
		
		if(InputHandler.getTouched("RightSwipeBack"))
			GameResources.Player.setState(new PlayerRollingState(GameResources.Player,true));
		
		if(!this.gameObject.getFlipped() && InputHandler.InputVector().x < 0)
			this.gameObject.setFlipped(true);
		if(this.gameObject.getFlipped() && InputHandler.InputVector().x > 0)
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
		

		GameResources.SpriteBatch.draw(getStateAnimation().getKeyFrame(stateTime, true), getGameObject().getTransform().getCanvas().x,getGameObject().getTransform().getCanvas().y, getGameObject().getTransform().getCanvas().width, getGameObject().getTransform().getCanvas().height);
		
	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		
		if(other.getTag() == "attack")
		{
			GameResources.debugme--;
			this.gameObject.setState(new PlayerHitState(this.gameObject,other.getOwner()));
	}}
	

}
