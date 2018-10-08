package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public interface IState
{
	public boolean isFlipped();
	public String getName();
	public Animation getStateAnimation();
	public IGameObject getGameObject();
	public void onTriggerEnter();
	public Transform getCollider();
	public void Update(Float time);

}
