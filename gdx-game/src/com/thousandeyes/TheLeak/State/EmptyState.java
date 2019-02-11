package com.thousandeyes.TheLeak.State;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;

public class EmptyState extends BaseState
{
	@Override
	public Animation getStateAnimation()
	{
		return null;
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

	public EmptyState(GameObject _gameObject)
	{
		GameResources.LockingObjects.remove(_gameObject);
	}
	@Override
	public void Update()
	{
	
	}

	@Override
	public void onTriggerEnter(Transform other)
	{
		
	}
}
