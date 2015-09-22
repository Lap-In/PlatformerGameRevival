package Util;

/**
 * Coordinate2D :
 * 
 * This class allow to easily create and manipulate coordinate for all the
 * gameObject. The coordinate are absolute.
 * 
 * @author LapinZinski
 */
public class Coordinate2D {

	// Variables :

	private float x, y; // The value of the coordinate

	// Constructor :

	/**
	 * Standard Constructor
	 */
	public Coordinate2D() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}

	/**
	 * Constructor with int values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the x axis
	 */
	public Coordinate2D(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor with float values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the x axis
	 */
	public Coordinate2D(float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor with another one
	 * 
	 * @param bis
	 *            the coordinate to duplicate
	 */
	public Coordinate2D(Coordinate2D bis) {
		// TODO Auto-generated constructor stub
		x = bis.getFloatX();
		y = bis.getFloatY();
	}

	// Functions :

	/**
	 * Add the coordinate with another one
	 * 
	 * @param bis
	 *            the coordinate to add to this one
	 */
	public void add(Coordinate2D bis) {
		x += bis.getFloatX();
		y += bis.getFloatY();
	}

	/**
	 * Add the coordinate with values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the y axis
	 */
	public void add(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Add the coordinate with values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the y axis
	 */
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Translate the coordinate with another one
	 * 
	 * @param bis
	 *            the coordinate to add to this one
	 */
	public void translate(Coordinate2D bis) {
		x = bis.getFloatX();
		y = bis.getFloatY();
	}

	/**
	 * Translate the coordinate with int values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the y axis
	 */
	public void translate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Translate the coordinate with float values
	 * 
	 * @param x
	 *            value of the x axis
	 * @param y
	 *            value of the y axis
	 */
	public void translate(float x, float y) {
		this.x = x;
		this.y = y;
	}

	// Getters/Setters :

	/**
	 * Get the int value of the x axis
	 * 
	 * @return value of the x axis
	 */
	public int getIntX() {
		return (int) x;
	}

	/**
	 * Get the float value of the x axis
	 * 
	 * @return value of the x axis
	 */
	public float getFloatX() {
		return x;
	}

	/**
	 * Set the value of the x axis
	 * 
	 * @param x
	 *            value of the x axis
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Get the int value of the x axis
	 * 
	 * @return value of the x axis
	 */
	public int getIntY() {
		return (int) y;
	}

	/**
	 * Get the float value of the y axis
	 * 
	 * @return value of the y axis
	 */
	public float getFloatY() {
		return y;
	}

	/**
	 * Set the value of the y axis
	 * 
	 * @param y
	 *            value of the y axis
	 */
	public void setY(float y) {
		this.y = y;
	}

}
