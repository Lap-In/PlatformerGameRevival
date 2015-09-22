package Util;

import Entity.PlayableCharacter;
import Tiles.TilesMap;

/**
 * Constant :
 * 
 * This static class stock all the variable use through all of the process of
 * the program
 * 
 * @author LapinZinski
 */
public class Constante {

	// The list of all the tiles of the game
	public static final TilesMap tileMap = new TilesMap();

	// The gameLoop condition
	public static boolean gameRunning = true;
	
	// Speed of the movement of the scrolling
	public static float speedScreen = 0.5f;

	// The hero of the game
	public static PlayableCharacter hero = new PlayableCharacter("James", 2, null, new Coordinate2D(25, 430));
	
	// If the left key is pressed
	public static boolean leftPressed = false;
	
	// If the right key is pressed
	public static boolean rightPressed = false;
	
	// If the up key is pressed
	public static boolean upPressed = false;
	
	// Is the jump limit of the hero has been meet ?
	public static boolean isLimitJump = true;
	
	// Number of frame the hero has jump
	public static int frameOnJump = 0;
	
	// Number of frames the hero is falling
	public static int frameOnFalling = 0;
	
	// Speed of the fall in the x axis
	public static float fallSpeedX = 0.01f;
}
