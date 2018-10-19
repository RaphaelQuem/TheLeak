package com.thousandeyes.TheLeak.Base;
import com.thousandeyes.TheLeak.Entities.*;

public class EnemyHelper
{
	public static Enemy newEnemy()
	{
		Enemy enemy =new Enemy(new Transform(500f, 0f,10f,30f,80f,80f))
		{

		};
		GameResources.CreateObjects.add
		(
			enemy
		);
		return enemy;
	}
}
