package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public class IState
{
	public String getName(){return "ISate";};
	public Animation getStateAnimation(){return null;};
	public GameObject getGameObject(){return null;};
	public void onTriggerEnter(Transform other){};
	public Transform getCollider(){return null;};
	public void Update(){};

}
