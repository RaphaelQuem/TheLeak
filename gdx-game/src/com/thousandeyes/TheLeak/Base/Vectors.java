package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;

public class Vectors
{
	public static Vector2 Left = new Vector2(-1,0);
	public static Vector2 Right = new Vector2(1,0);
	public static Vector2 Up = new Vector2(0,1);
	public static Vector2 Down = new Vector2(0,-1);
	public static Vector2 Invert(Vector2 vec)
	{
		return new Vector2(vec.x*-1,vec.y*-1);
	};
}
