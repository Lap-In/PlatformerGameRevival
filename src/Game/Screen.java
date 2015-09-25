package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Level.Level;
import Tiles.Tiles;
import Util.Constante;
import Util.Coordinate2D;
import Util.Hitbox;

/**
 * Screen(Screen) :
 *
 * The class in which the game is displayed and who contained the gameLoop and
 * gameLogic
 * 
 * @TODO Separate the gameLoop and gameLogic from the Screen class
 * 
 * @author LapinZinski
 */
@SuppressWarnings("serial")
public class Screen extends Canvas implements KeyListener {

	// Variables :

	private JFrame frame; // The window of the program
	private Hitbox hitbox;
	private BufferStrategy strategy; // The strategy the buffer are currently on

	// Constructor :

	/**
	 * Constructor
	 */
	public Screen(Dimension sizeLevel) {
		// The instantiation of the window and canvas
		frame = new JFrame("TestEcran");

		hitbox = new Hitbox(new Coordinate2D(), 500, 500);
		setSize(hitbox.getDimension());

		frame.add(this);
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(510, 510));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// Disable the automatic repaint property of JFrame
		frame.setIgnoreRepaint(true);

		// Following of the instantiation
		frame.pack();
		frame.setVisible(true);

		// Ask the process to focus on this canvas
		requestFocus();

		// Add the KeyListener
		addKeyListener(this);

		// Create a double-buffered strategy
		createBufferStrategy(2);
		strategy = this.getBufferStrategy();
	}

	// Getters/Setters :

	/**
	 * Add the coordinate of the screen hitbox
	 * 
	 * @param coordToAdd
	 */
	public void addToCoordHitbox(int xCoordToAdd, int yCoordToAdd) {
		hitbox.getUpLeftPoint().add(xCoordToAdd, yCoordToAdd);
	}

	// Function Paint :

	/**
	 * Paint all the requirement of the level and entity
	 * 
	 * @param lvl
	 */
	public void paint(Level lvl, Point[] liste) {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();

		// White out the screen
		g.setColor(Color.white);
		g.fillRect(0, 0, hitbox.getSizeX() * Tiles.TILE_SIZE, hitbox.getSizeY() * Tiles.TILE_SIZE);

		// Paint all the component
		lvl.paint(g, hitbox);
		Constante.hero.paint(g, Color.blue);

		// Paint the trace of the hero
		g.setColor(Color.green);
		for (int i = 0; i < liste.length - 1; i++) {
			g.fillRect(liste[i].x, liste[i].y, 2, 2);
		}

		// Dispose of the Graphics2D and show the result
		g.dispose();
		strategy.show();
	}

	// Function of the KeListener

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Constante.leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Constante.rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Constante.upPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Constante.leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Constante.rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Constante.upPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
