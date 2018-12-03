package com.thousandeyes.TheLeak.Base;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.assets.*;
import com.thousandeyes.TheLeak.State.GameState.*;
public class AnimationHelper
{
	public static Animation GetAnimationFromSpritesheet(String path, int cols, int rows, float time){
		Texture sheet = AssetHelper.getTexture(path);

		TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / cols, sheet.getHeight() / rows);
		TextureRegion[] frames = new TextureRegion[cols * rows];
		int index = 0;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				frames[index++] = tmp[i][j];
			}
		}
		
		return new Animation(time, frames);
	}
	
}
