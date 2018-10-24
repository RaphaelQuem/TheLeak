package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;

public class Touchable extends Transform
{
	private String event = "action";
	public boolean getTouched()
	{
		Vector3 touchPoint = new Vector3();
		for (int i=0; i<5; i++){
			if (!Gdx.input.isTouched(i)) continue;
			GameResources.Camera.unproject(touchPoint.set(Gdx.input.getX(i), Gdx.input.getY(i), 0));
			if (InputHandler.getActionBounds().contains(touchPoint.x, touchPoint.y)){
				/*if(!lastActionVerification)
				{
					lastActionVerification =true; 
					return lastActionVerification;
				}*/
				return false;
			}
		}
		return false;
	}
	
}
