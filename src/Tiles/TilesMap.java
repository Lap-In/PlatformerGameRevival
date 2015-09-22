package Tiles;

import java.util.HashMap;

/**
 * TilesMap :
 * 
 * It's a list of the tiles of the games pre-loaded
 * 
 * @author LapinZinski
 */
public class TilesMap {

	// Variables :

	private HashMap<String, Tiles> tilesMap;

	// Constructor :

	/**
	 * Basic constructor
	 */
	public TilesMap() {
		// TODO Auto-generated constructor stub
		tilesMap = new HashMap<String, Tiles>();
		tilesMap.put("tiles_01", new Tiles("tiles_01", null));
		tilesMap.put("tiles_02", new Tiles("tiles_02", null));
		tilesMap.put("tiles_03", new Tiles("tiles_03", null));
	}

	// Getters/Setters :

	/**
	 * Get the tiles labeled as the name given in the parameter
	 * 
	 * @param name
	 *            the name of the researched tiles
	 * @return the tiles if it exist, null if not
	 */
	public Tiles getTiles(String name) {
		return tilesMap.get(name);
	}
}