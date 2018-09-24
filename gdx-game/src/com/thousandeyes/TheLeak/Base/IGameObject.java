package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.utils.reflect.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
public interface IGameObject
{
	public String Name;
	public IState State;
	public Rectangle Transform;
    public void Update(SpriteBatch batch, Float time);
}
