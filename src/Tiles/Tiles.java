package Tiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

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

	// Constructor :

	/**
	 * Basic constructor
	 * 
	 * @param nom
	 *            name of the tiles
	 * @param tileSpr
	 *            sprite of the tiles
	 */
	public Tiles(String nom, Image tileSpr) {
		this.nom = nom;
		this.tilesSpr = tileSpr;
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
