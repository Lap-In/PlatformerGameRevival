package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import Util.Coordinate2D;
import Util.Hitbox;

/**
 * Entity :
 * 
 * This class is a template for every "living" entity in the game, playable
 * character include.
 * 
 * @author LapinZinski
 */
public abstract class Entity {

	// Variables :

	protected String nom;

	protected int vie; // Life point of the entity
	protected float speed;
	protected Image sprEntity; // Sprite of the Entity

	protected Hitbox hitbox; // The hitbox of the Entity for collision check

	// Constructor :

	/**
	 * Basic constructor
	 * 
	 * @param nom
	 * @param vie
	 *            life point of the entity
	 * @param sprEntity
	 *            sprite of the entity
	 */
	public Entity(String nom, int vie, Image sprEntity) {
		this.nom = nom;
		this.vie = vie;
		this.sprEntity = sprEntity;
		this.hitbox = new Hitbox(new Coordinate2D(), 20, 30);
	}

	/**
	 * Constructor with a pre-created coordinate for the origin point
	 * 
	 * @param nom
	 * @param vie
	 *            life point of the entity
	 * @param sprEntity
	 *            sprite of the entity
	 * @param coordOrigin
	 *            coordinate of the origin point
	 */
	public Entity(String nom, int vie, Image sprEntity, Coordinate2D coordOrigin) {
		this.nom = nom;
		this.vie = vie;
		this.sprEntity = sprEntity;
		this.hitbox = new Hitbox(coordOrigin, 20, 30);
	}

	// Abstract Function :

	/**
	 * Will update the entity every time the logic will need it
	 */
	public abstract void updateEntity();

	/**
	 * Paint the entity unto the screen
	 * 
	 * @param g
	 *            the Graphics2D of the canvas
	 * @param color
	 *            The color in which the entity will be painted
	 */
	public abstract void paint(Graphics2D g, Color color);

	// Function :

	/**
	 * Move the entity with the speed he has
	 * 
	 * @param x
	 *            -1 if he go up, +1 if he go down
	 * @param y
	 *            -1 i he go left, +1 if he go right
	 */
	public void move(float x, float y) {
		hitbox.move(x * speed, y * speed);
	}

	// Getters/Setters :

	/**
	 * Get the name of the entity
	 * 
	 * @return name of the entity
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Set the name of the entity
	 * 
	 * @param nom
	 *            name of the entity
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Get the life point of the entity
	 * 
	 * @return life point of the entity
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Set the life point of the entity
	 * 
	 * @param vie
	 *            life point
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	/**
	 * Get the sprite of the entity
	 * 
	 * @return sprite of the entity
	 */
	public Image getSprEntity() {
		return sprEntity;
	}

	/**
	 * Get the hitbox of the entity
	 * 
	 * @return hitbox of the entity
	 */
	public Hitbox getHitbox() {
		return hitbox;
	}

	/**
	 * Get the speed in which the entity move
	 * 
	 * @return speed of the movement
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Set the speed in which the entity move
	 * 
	 * @param vie
	 *            speed of the movement
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
