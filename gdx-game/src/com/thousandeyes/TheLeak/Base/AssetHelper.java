package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;


public class AssetHelper
{
	public static AssetManager manager = new AssetManager();

	public static void DisposeAll()
	{
		manager.dispose();
	}
	public static Texture getTexture(String name)
	{
		if(!manager.isLoaded(name))
		{
			manager.load(name,Texture.class);
			manager.finishLoading();
		}
	
		return manager.get(name, Texture.class);
	}
}
