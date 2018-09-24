package com.thousandeyes.TheLeak.State;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Base.*;

public interface IState
{
	public String Name;
	public Animation StateAnimation;
	public IGameObject GameObject;
	public void Update(SpriteBatch batch, Float time);
}
