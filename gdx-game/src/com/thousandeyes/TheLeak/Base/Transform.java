package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.*;
import java.util.*;
import com.thousandeyes.TheLeak.State.*;


public class Transform extends Rectangle
{
	
	private GameObject owner; 
	private String tag;
	private float multiplier;
	public float screenWidthPercentage;
	public float screenHeightPercentage;
	private float canvasWPct = 100f;
	private float canvasHPct = 100f;
	private List<GameObject> collisions =  new ArrayList<GameObject>();
	private boolean trigger = false;


	public void setMultiplier(float multiplier)
	{
		this.multiplier = multiplier;
	}

	public float getMultiplier()
	{
		return multiplier;
	}

	public void setTag(String _tag)
	{
		this.tag = _tag;
	}

	public String getTag()
	{
		return this.tag;
	}

	public void setCollisions(List<GameObject> collisions)
	{
		this.collisions = collisions;
	}

	public List<GameObject> getCollisions()
	{
		return collisions;
	}
	public boolean getTrigger() {
		return trigger;
	}
	public void setTrigger(boolean _trigger)
	{
		trigger = _trigger;
	}
	public GameObject getOwner()
	{
		return owner;
	}
	public void setOwner(GameObject _owner){
		this.owner = _owner;
	}
	public Transform addX(float _x)
	{
		this.x += _x;
		return this;
	}
	
	
	public Transform(float _x, float _y, float heightPct,float ratio, float _canvasWPct,float _canvasHPct){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		
		
		this.height = (GameResources.Camera.viewportHeight/100f*heightPct)/100f*_canvasHPct;
		this.width = this.height * ratio;
	
		this.height = this.height/ 100f * _canvasHPct;
		this.width = this.width/100f*_canvasWPct;
		
		this.canvasWPct = _canvasWPct;
		this.canvasHPct = _canvasHPct;
		this.screenWidthPercentage = this.width/ GameResources.Camera.viewportWidth*100f;
		this.multiplier = 999;
		GameResources.TransformInstances.add(this);
	} 
	

	public Transform(float _x, float _y, float widthPct, float heightPct){
		
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		this.multiplier= 999;
		GameResources.TransformInstances.add(this);
	}
	public Transform(GameObject _owner,float _x, float _y, float widthPct, float heightPct){
		this.owner =_owner;
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;

		GameResources.TransformInstances.add(this);
	}
	
	public Transform(float _x, float _y, float widthPct, float heightPct, boolean _trigger){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		this.trigger = _trigger;

		GameResources.TransformInstances.add(this);
	}
	public Transform(float _x, float _y, float widthPct, float heightPct, boolean _trigger, String _tag, float _multiplier){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		this.trigger = _trigger;
		this.tag =_tag;
		this.multiplier = _multiplier;

		GameResources.TransformInstances.add(this);
	}
	public Transform(GameObject _owner, float _x, float _y, float widthPct, float heightPct, boolean _trigger, String _tag, float _multiplier){
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		this.trigger = _trigger;
		this.tag =_tag; 
		this.multiplier = _multiplier;
		this.owner =_owner;

		GameResources.TransformInstances.add(this);
	}
	public Transform(GameObject _owner,float _x, float _y, float widthPct, float heightPct, boolean _trigger){
		this.owner =_owner;
		this.x = _x;
		this.y = _y; 
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		this.trigger = _trigger;

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
		
	}
	public Vector3 getVector()
	{
		return new Vector3(this.x, this.y, 0f);
	}
	public Transform(float widthPct, float heightPct){
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;

	}
	public Transform AddTransform(Vector2 transform, float multiplier)
	{
		float xprevious = this.x;
		float yprevious = this.y;
		
		this.y += transform.y * multiplier;
		this.x += transform.x * multiplier;
		
	
		//implementaçao do limite do level q tem q ser mudada
		if(this.owner != null && this.owner.equals(GameResources.Player))
		{
			if( 
				this.x < GameResources.Level.getLeftLimit()
				|| this.x + this.width > GameResources.Level.getRightLimit()
				|| this.y < 0
				|| this.y + this.height > GameResources.Camera.viewportHeight
				|| this.x < GameResources.LocalLeftLimit && GameResources.LockingObjects.size()> 0
				|| this.x + this.width > GameResources.LocalRightLimit && GameResources.LockingObjects.size() > 0
				
			)
			{
				this.y = yprevious;
				this.x = xprevious;
				return this;
			}
		}
	
		return this;
	}
	public Transform Copy()
	{
		return new Transform
		(
			this.x,
			this.y,
			this.getWidthPercentage(),
			this.getHeightPercentage()
		);
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
