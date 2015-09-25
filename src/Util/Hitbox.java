package Util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import Tiles.Tiles;

/**
 * Hitbox :
 * 
 * This class represent the box in which a gameObject is closed in; it represent
 * his collision area with whom he interact with his Environment.
 * 
 * @author LapinZinski
 *
 */
public class Hitbox {

	// Variables :
	private Coordinate2D coordOrigin; // Origin of the hitbox
	private Coordinate2D up_leftPoint; // The up-left point
	private int sizeX, sizeY; // The length of the hitbox in the x and y axis

	// Constructor :

	/**
	 * Basic Constructor
	 * 
	 * @param point1
	 *            The up-left point of the hitbox
	 * @param sizeX
	 *            The length of the hitbox in the x axis
	 * @param sizeY
	 *            The length of the hitbox in the y axis
	 */
	public Hitbox(Coordinate2D point1, int sizeX, int sizeY) {
		this.up_leftPoint = point1;
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		coordOrigin = new Coordinate2D(point1.getFloatX() + (sizeX / 2), point1.getFloatY() + (sizeY / 2));
	}

	// Function :

	/**
	 * Move the hitbox of the gameObject and by extension, the gameObject itself
	 * 
	 * @param x
	 *            The vector x
	 * @param y
	 *            The vector y
	 */
	public void move(float x, float y) {
		coordOrigin.add(x, y);
		up_leftPoint.translate(coordOrigin.getFloatX() - (sizeX / 2), coordOrigin.getFloatY() - (sizeY / 2));
	}

	/**
	 * Is a hitbox colliding with this one
	 * 
	 * @param h
	 *            The hitbox with test with this one
	 * @return true if they collide, false otherwise
	 */
	public boolean collideWith(Hitbox h) {
		// Cond1. If A's left edge is to the right of the B's right edge, - then
		// A is Totally to right Of B
		// Cond2. If A's right edge is to the left of the B's left edge, - then
		// A is Totally to left Of B
		// Cond3. If A's top edge is below B's bottom edge, - then A is Totally
		// below B
		// Cond4. If A's bottom edge is above B's top edge, - then A is Totally
		// above B

		return (this.coordOrigin.getFloatX() < (h.coordOrigin.getFloatX() + h.sizeX)
				&& (this.coordOrigin.getFloatX() + this.sizeX) > h.coordOrigin.getFloatX()
				&& this.coordOrigin.getFloatY() < (h.coordOrigin.getFloatY() + h.sizeY)
				&& (this.coordOrigin.getFloatY() + this.sizeY) > h.coordOrigin.getFloatY());
	}

	// Getters/Setters :

	/**
	 * Get the origin point of the hitbox
	 * 
	 * @return the origin point of the hitbox
	 */
	public Coordinate2D getCoordOrigin() {
		return coordOrigin;
	}

	/**
	 * Get the up-left point of the hitbox
	 * 
	 * @return the up-left point of the hitbox
	 */
	public Coordinate2D getUpLeftPoint() {
		return up_leftPoint;
	}

	/**
	 * Get the up-left point of the hitbox tiles dependent
	 * 
	 * @return the up-left point of the hitbox tiles dependent
	 */
	public Coordinate2D getTilesUpLeftPoint() {
		return new Coordinate2D(up_leftPoint.getFloatX() / Tiles.TILE_SIZE, up_leftPoint.getFloatY() / Tiles.TILE_SIZE);
	}

	/**
	 * Get the length of the hitbox in the x axis
	 * 
	 * @return length of the hitbox in the x axis
	 */
	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Get the length of the hitbox in the x axis tiles dependent
	 * 
	 * @return length of the hitbox in the x axis tiles dependent
	 */
	public int getTilesSizeX() {
		return sizeX / Tiles.TILE_SIZE;
	}

	/**
	 * Get the length of the hitbox in the y axis
	 * 
	 * @return length of the hitbox in the y axis
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * Get the length of the hitbox in the y axis tiles dependent
	 * 
	 * @return length of the hitbox in the y axis tiles dependent
	 */
	public int getTilesSizeY() {
		return sizeY / Tiles.TILE_SIZE;
	}

	/**
	 * Get the dimension of the hitbox
	 * 
	 * @return the dimension of the hitbox
	 */
	public Dimension getDimension() {
		return new Dimension(sizeX, sizeY);
	}

	// The paint Function :

	/**
	 * Paint the hitbox in the screen
	 * 
	 * @param g
	 *            The Graphics2D of the Screen
	 * @param color
	 *            The color in which the hitbox need to be painted
	 * @param withBorder
	 *            true for a border, false without
	 */
	public void paint(Graphics2D g, Color color, boolean withBorder) {
		g.setColor(color);
		g.fillRect(up_leftPoint.getIntX(), up_leftPoint.getIntY(), sizeX, sizeY);

		// If a border has been asked
		if (withBorder) {
			g.setColor(Color.black);
			g.drawRect(up_leftPoint.getIntX(), up_leftPoint.getIntY(), sizeX, sizeY);
		}
	}
}
