package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.graphics.*;

public class TextureRegionHelper
{ 
	public static float getAspectRatio(String path, int cols, int rows)
	{
		Texture sheet = AssetHelper.getTexture(path);
		return (sheet.getWidth() / cols)/(sheet.getHeight() / rows);
	}
}
