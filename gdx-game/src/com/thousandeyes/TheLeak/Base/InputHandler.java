package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
public class InputHandler

{
	public static Rectangle getActionBounds ()
	{
		float caneraLeft= GameResources.Camera.position.x - GameResources.Camera.viewportWidth/2f;
		return new Transform(caneraLeft + GameResources.Camera.viewportWidth /100f*85f, GameResources.Camera.viewportHeight/100f*15f, 15f, 15f);
	}
	
	public static Vector2 OriginalTouch;
	public static Vector2 InputVector(){
		if(Gdx.input.isTouched())
		{
			for (int i=0; i<5; i++)
			{ 
				
				if(InputHandler.OriginalTouch == null)
				{
					if(Gdx.input.getX(i)<= Gdx.graphics.getWidth() / 2)
					{
						InputHandler.OriginalTouch = new Vector2(Gdx.input.getX(i), Gdx.input.getY(i));
						return Vector2.Zero;
					}
					else
					{

						InputHandler.OriginalTouch = null;
						return Vector2.Zero;
					}
					
				}
				else
				{ 
					Vector2 vec =new Vector2(Gdx.input.getX(i), Gdx.input.getY(i)).sub(InputHandler.OriginalTouch);
					vec.y *= -1;
					if(Math.abs(vec.x) > 25f || Math.abs(vec.y) > 25f)
						return vec.nor();
					else
						return Vector2.Zero;
				}
				
			}
			
		}
		
		InputHandler.OriginalTouch = null;
		return Vector2.Zero;
	};
	private static Boolean actionPressed;
	public static void setActionPressed(Boolean _actionPressed)
	{
		actionPressed = _actionPressed;
	}
	public static Boolean getActionPressed() 
	{
		Vector3 touchPoint = new Vector3();

		for (int i=0; i<5; i++){
			if (!Gdx.input.isTouched(i)) continue;
			GameResources.Camera.unproject(touchPoint.set(Gdx.input.getX(i), Gdx.input.getY(i), 0));
			if (InputHandler.getActionBounds().contains(touchPoint.x, touchPoint.y)){
				return true;
			}
		}
		return false;
	}
	
}
