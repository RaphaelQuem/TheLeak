package com.thousandeyes.TheLeak.Entities.Enemies;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.thousandeyes.TheLeak.State.Enemy.*;
import com.badlogic.gdx.graphics.*;

public class DataScavenger extends Enemy
{ 
public DataScavenger(Transform _transform)
{
	this.setTransform (_transform);
	this.getTransform().setOwner(this);
	this.setState (new EnemyWalkingState(this));
	GameResources.CurrentGameState.Manager.load( "red.png", Texture.class);
	GameResources.CurrentGameState.Manager.finishLoading();

	super.healthTex =GameResources.CurrentGameState.Manager.get( "red.png");
	}
	
}
