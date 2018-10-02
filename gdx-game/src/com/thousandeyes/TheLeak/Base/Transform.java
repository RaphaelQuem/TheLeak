package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.*;
import java.util.*;


public class Transform extends Rectangle
{
	private ListIterator<IGameObject> objectIterator;
	private IGameObject owner;
	public IGameObject getOwner()
	{
		return owner;
	}
	public void setOwner(IGameObject _owner){
		this.owner = _owner;
	}
	public Transform(float _x, float _y, float widthPct, float heightPct){
		this.x = _x;
		this.y = _y;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
	}

	public Transform(){
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}
	public Transform(float widthPct, float heightPct){
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
	}
	public void AddTransform(Vector2 transform, float multiplier)
	{
		float xprevious = this.x;
		float yprevious = this.y;
		
		this.y += transform.y * multiplier;
		this.x += transform.x * multiplier;
	
		objectIterator = GameResources.Objects.listIterator();
		while(objectIterator.hasNext())
		{
			IGameObject obj = objectIterator.next();
			if(this.owner != null && this.owner != obj && this.overlaps(obj.getTransform()))
			{
				this.y = yprevious;
				this.x = xprevious;
			}
		}
	}
}
