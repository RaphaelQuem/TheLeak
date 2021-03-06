package com.thousandeyes.TheLeak.Entities.Enemies;
import com.thousandeyes.TheLeak.Entities.*;
import com.thousandeyes.TheLeak.Base.*;
import com.thousandeyes.TheLeak.State.*;
import com.badlogic.gdx.graphics.*;
import com.thousandeyes.TheLeak.State.Bosses.First.*;

public class FirstBoss extends Enemy
{
	public FirstBoss(Transform _transform)
	{
		this.setHealth(this.getHealth() + 200);
		this.setTransform (_transform);
		this.getTransform().setOwner(this);
		this.setState (new FirstBossWalkingState(this));

		super.healthTex = AssetHelper.getTexture("red.png");
	}
}
