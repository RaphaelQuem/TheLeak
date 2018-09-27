package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;

public class Transform extends Rectangle
{
	public Transform(int widthPct, int heightPct){
		this.width = Gdx.graphics.getWidth() / 100 * widthPct;
		this.height = Gdx.graphics.getHeight() / 100 * heightPct;
	}
}
