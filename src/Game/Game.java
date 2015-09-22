package Game;

import java.awt.Point;
import java.io.File;

import Level.Level;
import Tiles.Tiles;
import Util.Constante;

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
		screen = new Screen();
		currentLevel = new Level(new File("lib/Level/lvl01.lvl"));

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
		if (Constante.leftPressed && Constante.hero.getHitbox().getCoordOrigin().getIntX() >= 0)
			Constante.hero.move(-1, 0);

		// If the player press the right key, make the hero move until it buck
		// against the boundaries
		if (Constante.rightPressed && Constante.hero.getHitbox().getCoordOrigin()
				.getIntX() <= (currentLevel.getXSIZE() * Tiles.TILE_SIZE - Constante.hero.getHitbox().getSizeX()))
			Constante.hero.move(1, 0);

		// If the player press the space bar, make the hero jumping
		if (Constante.upPressed && !Constante.isLimitJump) {
			// Constante.hero.jump();
		} else {
			// Constante.isLimitJump = true;
		}

		// Check and, if needed, apply the force of gravity
		// checkGravity();

		// Update the entity of the hero
		Constante.hero.updateEntity();
	}

	/**
	 * Check if a force of gravitation is needed for an entity
	 */
	// public void checkGravity() {
	// if (!checkCollisionLevel() && Constante.isLimitJump) {
	// applyGravity();
	// } else {
	// if (checkCollisionLevel() && Constante.isLimitJump) {
	// Constante.isLimitJump = false;
	// Constante.frameOnJump = 0;
	// }
	// Constante.frameOnFalling = 1;
	// }
	// }

	/**
	 * Check if the hero collide with a tiles
	 * 
	 * @return true if the hero collide, false otherwise
	 */
	// public boolean checkCollisionLevel() {
	// return currentLevel.getLvl()[((int)
	// Constante.hero.getCoordOrigin().getX() + 1)
	// / Tiles.TILE_SIZE][(int) Constante.hero.getCoordOrigin().getY() /
	// Tiles.TILE_SIZE] != null;
	// }

	/**
	 * Apply a force to the entity
	 */
	// public void applyGravity() {
	// Constante.hero.move((Constante.frameOnFalling * Constante.fallSpeedX),
	// 0);
	// Constante.frameOnFalling++;
	// }

	// Function Main :

	public static void main(String[] args) {
		new Game();
	}
}
