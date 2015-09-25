package Game;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;

import Entity.Entity;
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

		// Update the scrolling of the level
		updateScrolling();

		// Update the hero's position
		updateHeroMovement();

		// If the player press the space bar, make the hero jumping
		if (Constante.upPressed && !Constante.isLimitJump) {
			Constante.hero.jump();
		} else {
			Constante.isLimitJump = true;
		}

		// Check and, if needed, apply the force of gravity
		checkGravity(Constante.hero);

		// Update the entity of the hero
		Constante.hero.updateEntity();
	}

	/**
	 * Update the scrolling of the level
	 */
	public void updateScrolling() {
		// If the player press the left key, make the screen scrolls to the left
		// until it bucks against the level boundaries
		if (Constante.leftPressed && screen.getHitbox().getUpLeftPoint().getFloatX() > 0
				&& Constante.hero.getHitbox().getCoordOrigin().getFloatX() + 1 < 100) {
			screen.addToCoordHitbox(-1, 0);
			Constante.noHeroMovement = true;
		}

		// If the player press the right key, make the screen scrolls to the
		// right until it bucks against the level boundaries
		else if (Constante.rightPressed
				&& (screen.getHitbox().getUpLeftPoint().getIntX()
						+ screen.getHitbox().getSizeX()) < (currentLevel.getXSIZE() * Tiles.TILE_SIZE)
				&& Constante.hero.getHitbox().getCoordOrigin().getFloatX() + 1 > 400) {
			screen.addToCoordHitbox(+1, 0);
			Constante.noHeroMovement = true;
		}

		// If no scrolling needed
		else
			Constante.noHeroMovement = false;
	}

	/**
	 * Update the player's position according to his movement
	 */
	public void updateHeroMovement() {
		// If the player press the left key, make the hero move until it buck
		// against the boundaries of the screen
		if (!Constante.noHeroMovement && Constante.leftPressed
				&& Constante.hero.getHitbox().getCoordOrigin().getIntX() >= Constante.hero.getHitbox().getSizeX() / 2) {
			Constante.hero.move(-1, 0);
		}

		// If the player press the right key, make the hero move until it buck
		// against the boundaries of the screen
		if (!Constante.noHeroMovement && Constante.rightPressed && Constante.hero.getHitbox().getCoordOrigin()
				.getIntX() <= (screen.getHitbox().getSizeX() - (Constante.hero.getHitbox().getSizeX() / 2))) {
			Constante.hero.move(+1, 0);
		}
	}

	/**
	 * Check if a force of gravitation is needed for an entity
	 */
	public void checkGravity(Entity entity) {
		if (checkCollision(entity) && Constante.isLimitJump) {
			applyGravity();
		} else {
			if (!checkCollision(entity) && Constante.isLimitJump) {
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
	public boolean checkCollision(Entity entity) {
		// If entity is in the void
		if (currentLevel.getLvl()[(entity.getFeetY() + 1)
				/ Tiles.TILE_SIZE][(screen.getHitbox().getUpLeftPoint().getIntX() + entity.getFeetX() - 2)
						/ Tiles.TILE_SIZE] == null)
			return true;

		// If the entity collide with a tiles
		else if (currentLevel.getLvl()[(entity.getFeetY() + 1)
				/ Tiles.TILE_SIZE][(screen.getHitbox().getUpLeftPoint().getIntX() + entity.getFeetX() - 2)
						/ Tiles.TILE_SIZE].isBlocking((entity.getFeetY() + 1) / Tiles.TILE_SIZE,
								(screen.getHitbox().getUpLeftPoint().getIntX() + entity.getFeetX() - 2)
										/ Tiles.TILE_SIZE,
								entity))
			return true;
		else
			return false;
	}

	/**
	 * Apply a force to the entity
	 */
	public void applyGravity() {
		Constante.hero.move(0, (Constante.frameOnFalling * Constante.fallSpeedX));
		Constante.frameOnFalling++;
	}
}
