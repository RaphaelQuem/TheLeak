package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
public class InputHandler

{
	
	public static Vector2 OriginalTouch;
	public static Vector2 InputVector(){
		if(Gdx.input.isTouched())
		{
			if(InputHandler.OriginalTouch == null)
			{
				InputHandler.OriginalTouch = new Vector2(Gdx.input.getX(), Gdx.input.getY());
				return Vector2.Zero;
			}
			else
			{ 
				Vector2 vec =new Vector2(Gdx.input.getX(), Gdx.input.getY()).sub(InputHandler.OriginalTouch).nor();
				vec.y *= -1;
				return vec;
			}
		}
		else
		{
			InputHandler.OriginalTouch = null;
			return Vector2.Zero;
		}
	};
	
	
	
}
