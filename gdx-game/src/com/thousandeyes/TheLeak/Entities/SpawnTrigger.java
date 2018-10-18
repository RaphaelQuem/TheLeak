package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;

public class SpawnTrigger extends GameObject
{
	
	public SpawnTrigger(Transform _transform){
		this.setTransform (_transform);
		this.getTransform().setOwner(this);
		this.setState(new EmptyState(this));
	}

	@Override
	public void Update()
	{
		if(this.getTransform().overlaps(GameResources.Player.getTransform()))
		{
			GameResources.DeleteObjects.add(this);
			EnemyHelper.newEnemy();
		}
	}
	
	
}
