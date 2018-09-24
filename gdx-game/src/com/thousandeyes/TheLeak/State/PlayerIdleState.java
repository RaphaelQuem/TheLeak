package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public class PlayerIdleState implements IState
{
	public PlayerIdleState(IGameObject gameObject){
		GameObject = gameObject;
		StateAnimation = AnimationHelper.GetAnimationFromSpritesheet("hero-idle-spritesheet.png",5,2,0.1f);
	}
	@Override
	public void Update(SpriteBatch batch, Float time)
	{
		batch.draw(StateAnimation.getKeyFrame(time, true), GameObject.Transform.x,GameObject.Transform.y, GameObject.Transform.width, GameObject.Transform.height);
		
	}

}
