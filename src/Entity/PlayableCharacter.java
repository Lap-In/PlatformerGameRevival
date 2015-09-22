package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import Util.Constante;
import Util.Coordinate2D;

/**
 * PlayableCharacter :
 * 
 * The playable character who is an entity with special feature exclusive to it
 * 
 * @author LapinZinski
 */
public class PlayableCharacter extends Entity {

	// Variables :

	private int jumpMin = 5;
	private int jumpLimit = 200;

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
	public PlayableCharacter(String nom, int vie, Image sprEntity) {
		super(nom, vie, sprEntity);
		speed = 0.5f;
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
	public PlayableCharacter(String nom, int vie, Image sprEntity, Coordinate2D coordOrigin) {
		super(nom, vie, sprEntity, coordOrigin);
		speed = 0.5f;
	}

	// Function :

	/**
	 * Update the entity if needed
	 */
	@Override
	public void updateEntity() {
		// TODO Auto-generated method stub

	}

	// TODO Rewrite this function
	public void jump() {
		// TODO Auto-generated method stub
		if (Constante.upPressed && Constante.frameOnJump < jumpLimit) {
			if (Constante.frameOnJump <= 0)
				move(0, jumpMin * speed);
			else
				move(0, -2 * speed);

			Constante.frameOnJump++;
		} else if (Constante.frameOnJump >= jumpLimit)
			Constante.isLimitJump = true;
	}

	/**
	 * Function who paint the entity unto the screen
	 */
	@Override
	public void paint(Graphics2D g, Color color) {
		// TODO Auto-generated method stub
		hitbox.paint(g, color, true);
	}
}
