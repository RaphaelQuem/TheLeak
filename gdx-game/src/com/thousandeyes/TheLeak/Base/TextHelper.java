package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.Base.Enums.*;

public class TextHelper
{

	static Texture sheet = new Texture(Gdx.files.internal("numeral-spritesheet.png"));
	static TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / 12, sheet.getHeight() / 1);
	static TextureRegion[] frames = TextHelper.MatrixToVector(tmp);

	static TextureRegion[] MatrixToVector(TextureRegion[][] matrix)
	{
		TextureRegion[] vector = new TextureRegion[matrix.length * matrix[0].length];
		int index = 0;
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 12; j++)
			{
				vector[index++] = matrix[i][j];
			}
		}
		return vector;
	}
	public static void Show(String txt, Transform t, int cols, int rows)
	{
		int pos = 0;
		float charwidth = t.width / cols;
		for(char  c: txt.toCharArray())
		{
			int ix = TextEnum.valueOf(TextHelper.toSpritable(Character.toString(c))).ordinal();
			GameResources.SpriteBatch.draw(frames[ix],t.x + charwidth * pos,t.y,charwidth,t.height);
			pos++;
		}
	}
	public static String toSpritable(String value)
	{
		value = value.replace("+", "plus")
					 .replace("-","minus");
		return "value" + value;
	}
}
