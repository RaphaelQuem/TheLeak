package com.thousandeyes.TheLeak.Base;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.Base.Enums.*;
import com.thousandeyes.TheLeak.Entities.Enemies.*;

public class EnemyHelper
{
	public static Enemy newEnemy(EnemyEnum enemyType, float x, float y)
	{
		Enemy enemy = null;
		if(enemyType == EnemyEnum.FirstBoss)
		{
			enemy = new FirstBoss(new Transform(x, y,25f,1f,80f,80f));

		}
		if(enemyType == EnemyEnum.DataScavenger)
		{
			enemy = new DataScavenger(new Transform(x, y,40f,1f,80f,80f));
			
		}
		if(enemy == null)
			enemy = new Enemy(new Transform(x, y,40f,1f,80f,80f));
	
		GameResources.CreateObjects.add
		(
			enemy
		);
		return enemy;

	}
}
