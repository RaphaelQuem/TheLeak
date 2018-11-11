package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import java.util.*;
import com.thousandeyes.TheLeak.Entities.Enemies.*;
import android.graphics.*;

public class SpawnTrigger extends GameObject
{
	private float localRightLimit;
	private float localLefLimit;
	private EnemySpawn[] spawns;
	
	public SpawnTrigger(int _x, float _tolerance, EnemySpawn... _spawns){
		this.setTransform (new Transform(_x,0,10f,100f,true));
		this.localRightLimit = _x + _tolerance + GameResources.Camera.viewportWidth / 2;
		this.localLefLimit = _x - _tolerance -  GameResources.Camera.viewportWidth / 2;
		this.spawns = _spawns;
		this.getTransform().setOwner(this);
		this.setState(new EmptyState(this));
		GameResources.Objects.add(this);
	}

	@Override
	public void Update()
	{
		if(this.getTransform().overlaps(GameResources.Player.getTransform()))
		{
			GameResources.LocalLeftLimit = localLefLimit;
			GameResources.LocalRightLimit = localRightLimit;
			GameResources.DeleteObjects.add(this);
			float y = 0f;
			for(EnemySpawn spawn : spawns)
			{
				for(int i = 0;i<spawn.getNumber();i++)
				{
					float x = spawn.getLeft()?GameResources.getCameraLeft():GameResources.getCameraLeft()+GameResources.Camera.viewportWidth;
					
					GameResources.LockingObjects.add(EnemyHelper.newEnemy(spawn.getType(),x,y));
					
					y += GameResources.Camera.viewportHeight/6;
					
				}
			}
				
		}
	}
	
	
}
