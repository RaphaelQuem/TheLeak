package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.Enums.*;

public class EnemySpawn
{
	private int number;
	private EnemyEnum type;
	public int getNumber()
	{
		return number;
	}
	public EnemyEnum getType()
	{
		return type;
	};
	public EnemySpawn(int _number, EnemyEnum _type)
	{
		number = _number;
		type = _type;
	}
}
