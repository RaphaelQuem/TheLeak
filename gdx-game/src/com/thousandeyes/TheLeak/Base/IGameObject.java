package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.utils.reflect.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
public interface IGameObject
{
	public String getName();
	public IState getState();
	public Transform getTransform()
	public void setTransform(Transform _transform);
    public void Update(SpriteBatch batch, Float time);
}
