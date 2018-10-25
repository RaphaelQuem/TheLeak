package com.thousandeyes.TheLeak.State.GameState;
import com.thousandeyes.TheLeak.Base.*;
import java.util.*;


public class GameState
{ 
	public void Update(){ }
	public List<Touchable> Touchables;
	public void UpdateUi()
	{
		for(Touchable touchable : this.Touchables)
		{
			touchable.checkTouched();
		}
	}
}
