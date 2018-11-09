package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.Enums.*;

public class EnemySpawn
{
	private int number;
	private EnemyEnum type;
	private boolean left;
	public int getNumber()
	{
		return number;
	}
	public EnemyEnum getType()
	{
		return type;
	};
	public boolean getLeft()
	{
		return left;
	}
	public EnemySpawn(int _number, EnemyEnum _type, boolean _left)
	{
		number = _number;
		type = _type;
		left = _left;
	}
}
