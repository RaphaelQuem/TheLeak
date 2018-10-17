package com.thousandeyes.TheLeak.State;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class CameraState implements IState
{
	@Override
	public Animation getStateAnimation()
	{
		return null;
	}

	@Override
	public Transform getCollider()
	{
		return new Transform();
	}


	@Override
	public GameObject getGameObject()
	{
		return null;
	}
	@Override
	public String getName ()
	{
		return this.getClass().getName();
	}

	public CameraState(GameObject _gameObject)
	{
		
	}
	@Override
	public void Update()
	{
	
	}

	@Override
	public void onTriggerEnter(GameObject other)
	{
		
	}
}
