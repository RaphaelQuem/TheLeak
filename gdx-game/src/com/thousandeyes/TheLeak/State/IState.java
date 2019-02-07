package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;
import com.badlogic.gdx.*;

public class IState
{

	private float stateTime=0f;
	private List<Transform> colliders= new ArrayList<Transform>();
	private List<GameObject> triggeredObjects = new ArrayList<GameObject>();

	public void setColliders(List<Transform> colliders)
	{
		this.colliders = colliders;
	}

	public List<Transform> getColliders()
	{
		return colliders;
	}

	public void setStateTime(float stateTime)
	{
		this.stateTime = stateTime;
	}
	public void addStateTime(float stateTime)
	{
		this.stateTime += stateTime;
	}
	public float getStateTime()
	{
		return stateTime;
	}

	public void setTriggeredObjects(List<GameObject> triggeredObjects)
	{
		this.triggeredObjects = triggeredObjects;
	}

	public List<GameObject> getTriggeredObjects()
	{
		return triggeredObjects;
	}

	
	public String getName(){return "ISate";};
	public Animation getStateAnimation(){return null;};
	public GameObject getGameObject(){return null;};
	public void onTriggerEnter(Transform other){};
	public void Update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
	};

	

}
