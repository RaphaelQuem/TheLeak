package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;

public class TextHelper
{
	static Texture sheet = new Texture(Gdx.files.internal("numeral-spritesheet.png"));
	static TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / 12, sheet.getHeight() / 1);
	static TextureRegion[] frames = new TextureRegion[1 * 1];
	
	public static void Show(String txt, Transform t)
	{
		int index = 0;
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 1; j++)
			{
				frames[index++] = tmp[i][j];
			}
		}
		GameResources.SpriteBatch.draw(frames[0],t.x,t.y,t.width,t.height);
	}
}
