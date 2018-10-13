package com.thousandeyes.TheLeak.Base;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.thousandeyes.TheLeak.Entities.*;

public class GameResources
{
	public static OrthographicCamera Camera;
	public static List<Transform> TransformInstances = new ArrayList<Transform>();
	public static List<GameObject> Objects = new ArrayList<GameObject>();
	public static boolean Debug = true;
	public static Player Player;
	public static ShapeRenderer ShapeRenderer;
	public static SpriteBatch SpriteBatch;
	
}
