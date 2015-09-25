package Level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Tiles.Tiles;
import Util.Constante;
import Util.Hitbox;

/**
 * Level :
 * 
 * This class stock in an array the tiles consisting the level.
 * 
 * @author LapinZinski
 */
public class Level {

	// Variables :

	private String name;
	private Tiles[][] lvl; // Array of tiles which represent the level

	private int XSIZE; // The size in the x axis of the level;
	private int YSIZE; // The size in the y axis of the level;

	// Constructor :

	/**
	 * Constructor of the level. Need a .lvl file in order to generate the level
	 * 
	 * @param lvlFile
	 */
	public Level(File lvlFile) {
		// Instantiate the name of the level
		name = "";

		try {

			// The object who are in charge to read the file
			FileReader fr = new FileReader(lvlFile);
			BufferedReader br = new BufferedReader(fr);

			// Take the parameter of the header
			headerReader(br);

			// Instantiate the grid of the level if the parameter coming from
			// the header
			lvl = new Tiles[YSIZE][XSIZE];

			// Generate the level
			levelReader(br);

			// Close the bufferesReader
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Function

	/**
	 * This function take the parameter in the header of the .lvl file
	 * 
	 * @param br
	 *            the BufferedReader
	 * @throws IOException
	 */
	private void headerReader(BufferedReader br) throws IOException {
		// Take the header line
		String header = br.readLine();

		// Switch for each parameter needed
		boolean title = false;
		boolean xBoolsize = false;
		boolean yBoolsize = false;

		// Part of the header line which contain the size's value
		String xStringsize = "";
		String yStringsize = "";

		// Read every char of the line
		for (int i = 0; i < header.length(); i++) {

			// If the char is the start of the title
			if (header.charAt(i) == '"' && !title)
				title = true;

			// If the char is the body of the title
			else if (header.charAt(i) != '"' && title)
				name += header.charAt(i);

			// If the char is the end of the title
			else if (header.charAt(i) == '"' && title)
				title = false;

			// If the char is the start of the first value
			if (header.charAt(i) == '{')
				xBoolsize = true;

			// If the char is the end of the first value and the start of the
			// second one
			if (xBoolsize && header.charAt(i) == ',') {
				xBoolsize = false;
				yBoolsize = true;
			}

			// If the char is the body of the first value
			if (xBoolsize && header.charAt(i) != '{')
				xStringsize += header.charAt(i);

			// If the char is the end of the second value
			if (yBoolsize && header.charAt(i) == '}')
				yBoolsize = false;

			// If the char is the body of the second value
			if (yBoolsize && header.charAt(i) != ',')
				yStringsize += header.charAt(i);
		}

		// Cast the 2 values in 2 int variable
		XSIZE = Integer.parseInt(xStringsize);
		YSIZE = Integer.parseInt(yStringsize);
	}

	/**
	 * This function generate the grid of the level with the body of .lvl file
	 * 
	 * @param br
	 *            the BufferedReader
	 * @throws IOException
	 */
	private void levelReader(BufferedReader br) throws IOException {
		// The coordinate of a tiles in the grid
		int column = 0, line = 0;

		// A line of the .lvl file's body
		String body;

		// Until the end of the file
		while ((body = br.readLine()) != null) {
			// Read every character of the line
			for (int i = 0; i < body.length(); i++) {
				// If one of the character is a code of a tile
				switch (body.charAt(i)) {

				// The code equals to an empty tile
				case ' ':
					line++;
					break;

				// The code equals to "tiles_01"
				case '1':
					lvl[column][line] = Constante.tileMap.getTiles("tiles_01");
					line++;
					break;

				case '2':
					lvl[column][line] = Constante.tileMap.getTiles("tiles_02");
					line++;
					break;
				case '3':
					lvl[column][line] = Constante.tileMap.getTiles("tiles_03");
					line++;
					break;
				}
			}

			// Reset the x axis and go to the next y point
			line = 0;
			column++;
		}
	}

	/**
	 * Function who paint all the tiles in the screen
	 * 
	 * @param g
	 *            the Graphics2D o the screen
	 */
	public void paint(Graphics2D g, Hitbox screen) {
		g.setColor(Color.black);

		int y0 = screen.getTilesUpLeftPoint().getIntY();
		int x0 = screen.getTilesUpLeftPoint().getIntX();

		for (int column = screen.getTilesUpLeftPoint().getIntY(); column < screen.getTilesSizeY(); column++) {
			for (int line = screen.getTilesUpLeftPoint().getIntX(); line < screen.getTilesSizeX(); line++) {
				if (lvl[column][line] != null) {
					lvl[column][line].paint(g, (line - y0) * Tiles.TILE_SIZE, (column - x0) * Tiles.TILE_SIZE,
							Color.BLACK);
				}
			}
		}
	}

	// Getters/Setters :

	/**
	 * Get the name of the level
	 * 
	 * @return name of the level
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the grid of the level
	 * 
	 * @return grid of the level
	 */
	public Tiles[][] getLvl() {
		return lvl;
	}

	/**
	 * Get the size in the x axis of the level
	 * 
	 * @return size in the x axis of the level
	 */
	public int getXSIZE() {
		return XSIZE;
	}

	/**
	 * Get the size in the y axis of the level
	 * 
	 * @return size in the y axis of the level
	 */
	public int getYSIZE() {
		return YSIZE;
	}
}