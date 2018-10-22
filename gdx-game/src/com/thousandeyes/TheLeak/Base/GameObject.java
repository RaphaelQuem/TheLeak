package com.thousandeyes.TheLeak.Base;
import com.badlogic.gdx.utils.reflect.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.thousandeyes.TheLeak.State.*;
public abstract class GameObject implements Comparable<GameObject>
{
	// Attributes
	private Transform transform = new Transform();
	private IState state;
	private boolean flipped;
	private float speed;
	//
	
	// Getters
	public String getName()
	{
		return this.getClass().getSimpleName().toLowerCase();
	};
	
	public IState getState()
	{
		return this.state;
	};
	
	public Transform getTransform()
	{
		return this.transform;
	};
	

	public float getSpeed()
	{
		return this.speed;
	};
	
	public Transform getCollider()
	{
		return this.state.getCollider();
	};

	public boolean getFlipped()
	{
		return this.flipped;
	}
	// 

	//Setters
	public void setState (IState _state)
	{
		this.state = _state;
	};
	
	public void setFlipped(boolean _flipped)
	{
		this.flipped =_flipped;
	};

	public void setTransform(Transform _transform)
	{
		this.transform = _transform;
	};

	public void setSpeed(float _speed)
	{
		this.speed = _speed;
	};
	//
	
	//Methods
    public void Update()
	{
		state.Update();
	};
	
	@Override
	public int compareTo(GameObject other)
	{
		return Float.compare(other.getTransform().y,this.transform.y);
	}
	//


	
	private int health=100;
	private int strength = 3;
	private int dexterity=2;
	private int resistance=3;
	private int firePower=3;
	public void DecreaseHealthBy(int amount)
	{
		health-= amount;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int _health)
	{
		health = _health;
	}
	public int getStrength()
	{
		return strength;
	}
	public void setStrength(int _strength)
	{
		strength = _strength;
	}
	public int getDexterity()
	{
		return dexterity;
	}
	public void setDexterity(int _dexterity)
	{
		dexterity = _dexterity;
	}
	public int getResistance()
	{
		return resistance;
	}
	public void setResistance(int _resistance)
	{
		resistance = _resistance;
	}
	public int getFirePower()
	{
		return firePower;
	}
	public void setFirePower(int _firePower)
	{
		firePower = _firePower;
	}
}
