package com.thousandeyes.TheLeak.Base;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Entities.*;
import com.badlogic.gdx.*;
import com.thousandeyes.TheLeak.State.GameState.*;

public class GameResources
{
	public static OrthographicCamera Camera;
	public static List<Transform> TransformInstances = new ArrayList<Transform>();
	public static List<GameObject> Objects = new ArrayList<GameObject>();
	public static List<GameObject> CreateObjects = new ArrayList<GameObject>();
	public static List<GameObject> DeleteObjects = new ArrayList<GameObject>();
	public static List<GameObject> LockingObjects = new ArrayList<GameObject>();
	public static boolean Debug = true;
	public static Player Player;
	public static float LocalRightLimit=0f;
	public static float LocalLeftLimit=0f;
	public static ShapeRenderer ShapeRenderer;
	public static SpriteBatch SpriteBatch;
	public static GameState CurrentGameState;
	public static Level Level;
	public static Level Level1()
	{
		Level level = new Level(); 
		level.setBackground( new Texture(Gdx.files.internal("map-1.png")));
		level.setWidth(GameResources.Camera.viewportWidth*3);
		level.setHeight(GameResources.Camera.viewportHeight);
		level.setLeftLimit(0f);
		level.setRightLimit(3000f);
		GameResources.Objects.add(new SpawnTrigger(new Transform(1500f,0f,10f,100f)));
		
		return level;
	};
	
}
