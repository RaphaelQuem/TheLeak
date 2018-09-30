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
				Vector2 vec =new Vector2(Gdx.input.getX(), Gdx.input.getY()).sub(InputHandler.OriginalTouch);
				vec.y *= -1;
				if(Math.abs(vec.x) > 25f || Math.abs(vec.y) > 25f)
					return vec.nor();
				else
					return Vector2.Zero;
			}
		}
		else
		{
			InputHandler.OriginalTouch = null;
			return Vector2.Zero;
		}
	};
	private static Boolean actionPressed;
	public static void setActionPressed(Boolean _actionPressed)
	{
		actionPressed = _actionPressed;
	}
	public static Boolean getActionPressed() 
	{
		return actionPressed;
	}
	
}
