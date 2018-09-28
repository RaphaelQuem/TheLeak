package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;


public class Transform extends Rectangle
{
	public Transform(float widthPct, float heightPct){
		this.width = Gdx.graphics.getWidth()/100f*widthPct;
		this.height = Gdx.graphics.getHeight()/100f*heightPct;
	}
}
