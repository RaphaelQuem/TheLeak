package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.*;
import java.util.*;


public class Transform extends Rectangle
{
	private ListIterator<GameObject> objectIterator;
	private GameObject owner; 
	private float screenWidthPercentage;
	private float screenHeightPercentage;
	private float canvasWPct = 100f;
	private float canvasHPct = 100f;
	public GameObject getOwner()
	{
		return owner;
	}
	public void setOwner(GameObject _owner){
		this.owner = _owner;
	}
	
	public boolean IsColliding()
	{
		for(Transform t : GameResources.TransformInstances)
		{
			if(t != this && this.overlaps(t))
			{
				return true;
			}
		}
		return false;
	}
	public Transform(float _x, float _y, float widthPct, float heightPct, float _canvasWPct,float _canvasHPct){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = (GameResources.Camera.viewportWidth /100f*widthPct)/100f*_canvasWPct;
		this.height = (GameResources.Camera.viewportHeight/100f*heightPct)/100f*_canvasHPct;
		this.canvasWPct = _canvasWPct;
		this.canvasHPct = _canvasHPct;
		
		
		GameResources.TransformInstances.add(this);
	}

	public Transform(float _x, float _y, float widthPct, float heightPct){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;

		GameResources.TransformInstances.add(this);
	}
	public float getWidthPercentage() 
	{
		return this.screenWidthPercentage;
	}
	public float getHeightPercentage()
	{
		return this.screenHeightPercentage;
	}

	public Transform(){
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		
		GameResources.TransformInstances.add(this);
	}
	public Transform(float widthPct, float heightPct){
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;

		GameResources.TransformInstances.add(this);
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
			GameObject obj = objectIterator.next();
			if(this.owner != null && this.owner != obj && this.overlaps(obj.getTransform())
				&&
				(this.y >= obj.getTransform().y - 50f) && (this.y <= obj.getTransform().y + 50f)
				)
			{
				this.y = yprevious;
				this.x = xprevious;
			}
		}
	}
	public Transform getCanvas()
	{
		Transform ret = new Transform();

		ret.width = this.width / canvasWPct * 100f;
		ret.height = this.height / canvasHPct * 100f;
	
		ret.x = this.x - (ret.width - this.width )/2f;
		ret.y = this.y - (ret.height - this.height) /2f;
		
		return ret;
	}
}
