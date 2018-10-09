package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.utils.reflect.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
public interface IGameObject
{
	public String getName();
	public IState getState();
	public float getSpeed();
	public Transform getTransform();
	public void setTransform(Transform _transform);
	public void setState(IState _state);
    public void Update (Float time);
	public Transform getCollider();
	public boolean getFlipped();
	public void setFlipped(boolean _flipped);
}
