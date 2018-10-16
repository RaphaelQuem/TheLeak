package com.thousandeyes.TheLeak.Entities;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.math.*;

public class CameraHolder extends GameObject
{
	public CameraHolder()
	{
		
		GameResources.Camera = new OrthographicCamera(1280f, 720f);
		GameResources.Camera.position.set(1280f/2f,720f/2f,10f);
		GameResources.Camera.update();
		this.setState(new CameraState(this));
	}

	@Override
	public void Update()
	{ 
		float x;
		if(!GameResources.Player.getFlipped())
			x = GameResources.Player.getTransform().getVector().x+1280f/4f;
		else
			x = GameResources.Player.getTransform().getVector().x-1280f/4f;
	
		float camy= GameResources.Camera.position.y;
		float camx = GameResources.Camera.position.x;
	
		Vector2 vec = new Vector2(x,camy);
		Vector2 camvec = new Vector2(camx,camy);
		
		Vector2 cammov = vec.sub(camvec).nor();
			
		GameResources.Camera.position.set(camx + cammov.x * 10f,720f/2f,10f);
		GameResources.Camera.update();
	}
	
}
