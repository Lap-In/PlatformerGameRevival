package Game;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;

import Level.Level;
import Tiles.Tiles;
import Util.Constante;
import Util.Coordinate2D;

/**
 * Game :
 * 
 * The main class which contained the gameLoop and the gameLogic
 * 
 * @author LapinZinski
 */
public class Game {

	// Variables :

	private Screen screen; // The screen of the game
	private Level currentLevel; // The level being played
	private Point[] listePoint = new Point[1250];
	int count = 1;

	// Constructor :

	/**
	 * Basic Constructor
	 */
	public Game() {
		// Instantiation of the main variables
		currentLevel = new Level(new File("lib/Level/lvl01.lvl"));
		screen = new Screen(
				new Dimension(currentLevel.getXSIZE() * Tiles.TILE_SIZE, currentLevel.getYSIZE() * Tiles.TILE_SIZE));

		for (int i = 0; i < listePoint.length; i++) {
			listePoint[i] = new Point(0, 0);
		}

		// Execute the gameLoop
		gameLoop();
	}

	// Function :

	/**
	 * The game loop who paint every states of the game
	 */
	public void gameLoop() {
		while (Constante.gameRunning) {
			if (count < listePoint.length - 1)
				count++;
			else
				count = 0;

			listePoint[count] = new Point((int) Constante.hero.getHitbox().getCoordOrigin().getIntX(),
					(int) Constante.hero.getHitbox().getCoordOrigin().getIntY());

			// Update the logic of the game
			gameLogic();

			// Paint once the gameLogic has been updated
			screen.paint(currentLevel, listePoint);
		}
	}

	/**
	 * Update the logic of the game and all the different entity and tiles
	 */
	public void gameLogic() {

		// If the player press the left key, make the hero move until it buck
		// against the boundaries
		if (Constante.leftPressed && Constante.hero.getHitbox().getCoordOrigin().getIntX() >= 0) {
			Constante.hero.move(-1, 0);
			screen.addToCoordHitbox(-1, 0);
		}

		// If the player press the right key, make the hero move until it buck
		// against the boundaries
		if (Constante.rightPressed && Constante.hero.getHitbox().getCoordOrigin()
				.getIntX() <= (currentLevel.getXSIZE() * Tiles.TILE_SIZE - Constante.hero.getHitbox().getSizeX())) {
			screen.addToCoordHitbox(+1, 0);
			Constante.hero.move(+1, 0);
		}

		// If the player press the space bar, make the hero jumping
		if (Constante.upPressed && !Constante.isLimitJump) {
			Constante.hero.jump();
		} else {
			Constante.isLimitJump = true;
		}

		// Check and, if needed, apply the force of gravity
		checkGravity();

		// Update the entity of the hero
		Constante.hero.updateEntity();
	}

	/**
	 * Check if a force of gravitation is needed for an entity
	 */
	public void checkGravity() {
		if (checkCollisionX() == 1 && Constante.isLimitJump) {
			applyGravity();
		} else {
			if (checkCollisionX() == 0 && Constante.isLimitJump) {
				Constante.isLimitJump = false;
				Constante.frameOnJump = 0;
			}
			Constante.frameOnFalling = 1;
		}
	}

	/**
	 * Check if the hero collide with a tiles
	 * 
	 * @return true if the hero collide, false otherwise
	 */
	public int checkCollisionX() {
		if (currentLevel.getLvl()[(Constante.hero.getFeetY() + 1) / Tiles.TILE_SIZE][Constante.hero.getFeetX()
				/ Tiles.TILE_SIZE] == null)
			return 1;
		else
			return 0;
	}

	/**
	 * Apply a force to the entity
	 */
	public void applyGravity() {
		Constante.hero.move(0, (Constante.frameOnFalling * Constante.fallSpeedX));
		Constante.frameOnFalling++;
	}

	// Function Main :

	public static void main(String[] args) {
		new Game();
	}
}
