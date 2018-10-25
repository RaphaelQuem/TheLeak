package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.*;

public class Touchable extends Transform
{
	Texture texture;
	private String event;
	private String sprite;
	public Touchable(String _event, String _sprite, float _x, float _y, float widthPct, float heightPct)
	{
		
		this.event = _event;
		this.sprite = _sprite;
		this.texture = new Texture(Gdx.files.internal(_sprite+".png"));
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth /100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;

	}
	
	public void checkTouched()
	{
	
		GameResources.SpriteBatch.draw(this.texture, GameResources.getCameraLeft()+ this.x,this.y, this.width, this.height);
		
		
		Vector3 touchPoint = new Vector3();
		if(event == "") return;
		for (int i=0; i<5; i++){
			if (!Gdx.input.isTouched(i)) continue;
			GameResources.Camera.unproject(touchPoint.set(Gdx.input.getX(i) + GameResources.getCameraLeft(), Gdx.input.getY(i), 0));
			if (this.contains(touchPoint.x , touchPoint.y)){
				InputHandler.Touches += (InputHandler.Touches.equals("")?"":"|") + event;
			}
			else
			{
				InputHandler.Touches = InputHandler.Touches.replace("|" + event,"").replace(event,"");
			}
		}
	}
	
}
