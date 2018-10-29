package com.thousandeyes.TheLeak.Entities;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.Base.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;

public class Enemy extends GameObject
{
	 
	public Enemy() 
	{
		this.setTransform(new Transform());
		this.setState (new EnemyWalkingState(this));
		this.getTransform().setOwner(this);
	
	}
	

	public Enemy(Transform _transform){
		
		this.setTransform (_transform);
		this.getTransform().setOwner(this);
		this.setState (new EnemyWalkingState(this));
	}

	@Override
	public void Update()
	{
		Texture healthTex =new Texture(Gdx.files.internal("red.png"));
	
		float hpPct = Math.max(Float.parseFloat(String.valueOf(getHealth())) / Float.parseFloat(String.valueOf(getMaxHealth())),0f);
		
		GameResources.SpriteBatch.draw(healthTex, this.getTransform().getCanvas().x, this.getTransform().getCanvas().y + this.getTransform().getCanvas().height + 20f, this.getTransform().getCanvas().width * hpPct, 8f);
		
		this.getState().Update();
	}

	
}
