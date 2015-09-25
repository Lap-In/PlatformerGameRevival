package Tiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import Entity.Entity;
import Util.Coordinate2D;
import Util.Hitbox;

/**
 * Tiles :
 * 
 * This object represent a piece of the interactive wall and/or other gameObject
 * 
 * @author LapinZinski
 */
public class Tiles {

	// Constants :

	public static final int TILE_SIZE = 20;

	// Variable :

	private String nom;
	private Image tilesSpr; // Sprite of the tiles
	public final boolean BLOCKED;

	// Constructor :

	/**
	 * Basic constructor
	 * 
	 * @param nom
	 *            name of the tiles
	 * @param tileSpr
	 *            sprite of the tiles
	 */
	public Tiles(String nom, Image tileSpr, boolean blocking) {
		this.nom = nom;
		this.tilesSpr = tileSpr;
		BLOCKED = blocking;
	}

	// Function :

	/**
	 * Test if the tiles blocked the entity
	 * 
	 * @param x
	 *            the coordinate of the tiles in the x axis (parent to the tiles
	 *            array)
	 * @param y
	 *            the coordinate of the tiles in the y axis (parent to the tiles
	 *            array)
	 * @param victim
	 *            the entity we are testing
	 * @return true if the tiles is blocking, false otherwise
	 */
	public boolean isBlocking(int x, int y, Entity victim) {
		return returnTilesHitbox(x, y).collideWith(victim.getHitbox());
	}

	/**
	 * Return a hitbox of the tiles allowing hitbox colliding check
	 * 
	 * @param x
	 *            the coordinate of the tiles in the x axis (parent to the tiles
	 *            array)
	 * @param y
	 *            the coordinate of the tiles in the y axis (parent to the tiles
	 *            array)
	 * @return the hitbox of the tiles
	 */
	public static Hitbox returnTilesHitbox(int x, int y) {
		return new Hitbox(new Coordinate2D(x * Tiles.TILE_SIZE, y * Tiles.TILE_SIZE), Tiles.TILE_SIZE, Tiles.TILE_SIZE);
	}

	// Getters/Setters :

	/**
	 * Get the name of the tiles
	 * 
	 * @return name of the tiles
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Get the sprite of the tiles
	 * 
	 * @return sprite of the tiles
	 */
	public Image getTilesSpr() {
		return tilesSpr;
	}

	// The paint Function :

	/**
	 * Paint the tiles at the specified coordinate
	 * 
	 * @param g
	 *            The Graphics2D of the Screen
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @param color
	 *            The color the tiles is colored in
	 */
	public void paint(Graphics2D g, int x, int y, Color color) {
		g.setColor(color);
		g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
	}
}
