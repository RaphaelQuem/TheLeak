package com.thousandeyes.TheLeak.Base;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.thousandeyes.TheLeak.Entities.Enemies.*;

public class EnemyHelper
{
	public static Enemy newEnemy(EnemyEnum enemyType, float x, float y)
	{
		Enemy enemy = new Enemy();
		if(enemyType == EnemyEnum.DataScavenger)
		{
			enemy = new DataScavenger(new Transform(x, y,10f,30f,80f,80f));
			
		}
		else
			enemy = new Enemy(new Transform(x, y,10f,30f,80f,80f));
	
		GameResources.CreateObjects.add
		(
			enemy
		);
		return enemy;

	}
}
