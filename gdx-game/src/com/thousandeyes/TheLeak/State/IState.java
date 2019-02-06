package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;

public class IState
{
	private List<GameObject> triggeredObjects = new ArrayList<GameObject>();

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
	public Transform getCollider(){return null;};
	public void Update(){};
	

}
