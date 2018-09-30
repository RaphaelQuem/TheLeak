package com.thousandeyes.TheLeak.Base;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;

public class Touchable implements IGameObject
{
	private Texture texture;
	private Transform transform;
	private IState state;
	@Override
	public String getName(){
		return this.getClass().getName();
	};
	@Override
	public IState getState(){
		return this.state;
	};
	@Override
	public Transform getTransform(){
		return this.transform;
	} 
	@Override
	public void setTransform (Transform _transform)
	{
		this.transform = _transform;
	}
	@Override
	public void setState (IState _state)
	{
		this.state = _state;
	}
	public Touchable()
	{
		this.transform = new Transform(15f,15f);
		this.transform.setX(GameResources.Camera.viewportWidth*0.85f);
		this.transform.setY(GameResources.Camera.viewportHeight*0.15f);
		texture = new Texture(Gdx.files.internal("bbutton.png"));
	}
	@Override
	public void Update(SpriteBatch batch, Float time)
	{
		if(Gdx.input.isTouched())
		{
			InputHandler.setActionPressed(transform.contains(Gdx.input.getX(),Gdx.input.getY()));
		}
		else
		{
			InputHandler.setActionPressed(false);
			batch.draw(texture, this.transform.x, this.transform.y,this.transform.width,this.transform.height);
			
		}
		
		
		
	}


	
}
