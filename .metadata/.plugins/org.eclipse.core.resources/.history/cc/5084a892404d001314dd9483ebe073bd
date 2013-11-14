package Visualiser.Editor;

import Visualiser.Editor.World;
import Visualiser.Editor.Maze;

/**
 * De klasse WorldLayer produceert mazes die de lagen van de wereld in elke dimensie en op elke positie 
 * kunnen voorstellen als het 2D vlak dat nodig is voor behoud van de vorm van de wereld als de pac-man
 * een "afslag" neemt en voor de eventuele mini-map die toegevoegd wordt aan het spel.
 * <p>
 * @author Gma-X
 *
 */
public class WorldLayer {
	
	private Maze maze;
	private World world;
	
	/**
	 * Maakt een maze aan die een vlak("laag") in de echte wereld  voorstelt
	 * <p>
	 * @param wor De wereld waarvan een laag wordt aangemaakt
	 */
	public WorldLayer(World wor){
		maze = new Maze(wor.getDim());
		world = wor;
	}
	
	/**
	 * Geeft de verticale laag terug op een vaste i-coordinaat van de wereld in de j- en h-richting
	 * <p>
	 * @param iCoord De i-coordinaat van de wereld waarvan de laag wordt opgevraagd
	 * @param wor De wereld waaruit de laag wordt opgevraagd
	 * @return Retourneert een maze die deze verticale laag van de wereld voorstelt
	 */
	public static WorldLayer getVerticalMazeI(int iCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		int dim = wor.getDim();
		Maze layer = new Maze(dim);
		for(int hCoord = 0; hCoord < dim; hCoord++){
			for(int jCoord = 0; jCoord < dim; jCoord++){
				layer.setMazeCoord(hCoord, jCoord, wor.getCoordValue(iCoord, jCoord, hCoord));
			}
		}
		layer.mirrorHorizontally();
		wl.maze = layer;
		
		return wl;
	}
	
	/**
	 * Geeft de verticale laag terug op een vaste j-coordinaat van de wereld in de i- en h-richting
	 * <p>
	 * @param jCoord De j-coordinaat van de wereld waarvan de laag wordt opgevraagd
	 * @param wor De wereld waaruit de laag wordt opgevraagd
	 * @return Retourneert een maze die deze verticale laag van de wereld voorstelt
	 */
	public static WorldLayer getVerticalMazeJ(int jCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		int dim = wor.getDim();
		Maze layer = new Maze(dim);
		for(int hCoord = 0; hCoord < dim; hCoord++){
			for(int iCoord = 0; iCoord < dim; iCoord++){
				layer.setMazeCoord(hCoord, iCoord, wor.getCoordValue(iCoord, jCoord, hCoord));
			}
		}
		layer.mirrorHorizontally();
		wl.maze = layer;
		
		return wl;
	}
	
	/**
	 * Geeft de horizontale laag terug op een vaste h-coordinaat van de wereld in de i- en j-richting
	 * <p>
	 * @param hCoord De h-coordinaat van de wereld waarvan de laag wordt opgevraagd
	 * @param wor De wereld waaruit de laag wordt opgevraagd
	 * @return Retourneert een maze die deze horizontale laag van de wereld voorstelt
	 */
	public static WorldLayer getHorizontalMazeH(int hCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		int dim = wor.getDim();
		Maze layer = new Maze(dim);
		for(int iCoord = 0; iCoord < dim; iCoord++){
			for(int jCoord = 0; jCoord < dim; jCoord++){
				layer.setMazeCoord(iCoord, jCoord, wor.getCoordValue(iCoord, jCoord, hCoord));
			}
		}
		layer.mirrorHorizontally();
		wl.maze = layer;
		
		return wl;
	}

}
