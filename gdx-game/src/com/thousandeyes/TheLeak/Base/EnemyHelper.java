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
			enemy = new FirstBoss(new Transform(x, y,45f,1f,30f,100f));

		}
		if(enemyType == EnemyEnum.DataScavenger)
		{
			enemy = new DataScavenger(new Transform(x, y,45f,1f,30f,100f));
			
		}
		if(enemy == null)
			enemy = new Enemy(new Transform(x, y,45f,1f,30f,100f));
	
		GameResources.CreateObjects.add
		(
			enemy
		);
		return enemy;

	}
}
