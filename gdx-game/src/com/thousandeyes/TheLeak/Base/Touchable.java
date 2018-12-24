package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.*;

public class Touchable extends Transform
{
	Texture texture;
	private String event;
	private String sprite;
	Transform t;
	public Touchable(String _event, String _sprite, float _x, float _y, float widthPct, float heightPct)
	{
	
	
		this.event = _event;
		this.sprite = _sprite;
		this.texture = new Texture(Gdx.files.internal(_sprite+".png"));
		this.x = _x;
		this.y = _y;
		this.screenHeightPercentage = heightPct;
		this.screenWidthPercentage = widthPct;
		this.width = GameResources.Camera.viewportWidth/100f*widthPct;
		this.height = GameResources.Camera.viewportHeight/100f*heightPct;
		t = new Transform(this.x, this.y,this.getWidthPercentage(),this.getHeightPercentage());
		
	}

	public void setTexture(Texture texture)
	{
		this.texture = texture;
	}

	public Texture getTexture()
	{
		return texture;
	}
	
	public void checkTouched()
	{
		
		Rectangle rect = new Rectangle(this.x , this.y,this.width,this.height);
		GameResources.HudBatch.draw(this.texture, rect.x,rect.y, rect.width, rect.height);
		if(this.event == "strength")
		{
			String x=this.sprite;
			String y = this.event;
		}
		Vector3 touchPoint = new Vector3(); 
		if(event == "") return; 
			InputHandler.Touches = InputHandler.Touches.replace("|" + event,"").replace(event,"");
		int touched = 5;
		for (int i=0; i<5; i++){
			if (!Gdx.input.isTouched(i))
			{
				touched--;
				continue;
			}
			GameResources.Camera.unproject(touchPoint.set(Gdx.input.getX(i), Gdx.input.getY(i), 0));
			
			
			if (rect.contains(touchPoint.x , touchPoint.y)  ){
				if(!InputHandler.LastTouches.contains(event))
				{
					InputHandler.Touches += (InputHandler.Touches.equals("")?"":"|") + event;
				}		
			}
			else
			{
				InputHandler.LastTouches = InputHandler.LastTouches.replace("|" + event,"").replace(event,"");
				InputHandler.Touches = InputHandler.Touches.replace("|" + event,"").replace(event,"");
			}
		}
		if(touched== 0)
		{
			InputHandler.LastTouches = InputHandler.LastTouches.replace("|" + event,"").replace(event,"");
			InputHandler.Touches = InputHandler.Touches.replace("|" + event,"").replace(event,"");
			
		}
	}
	
	
}
