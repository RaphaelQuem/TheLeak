package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public interface IState
{
	public String getName();
	public Animation getStateAnimation();
	public GameObject getGameObject();
	public void onTriggerEnter(GameObject other);
	public Transform getCollider();
	public void Update();

}
