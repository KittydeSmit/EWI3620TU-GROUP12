package Visualiser.Editor;

import Visualiser.Editor.World;
import Visualiser.Editor.Maze;

public class WorldLayer {
	
	private Maze maze;
	private World world;
	
	public WorldLayer(World wor){
		maze = new Maze(wor.getDim(), wor.getDim());
		world = wor;
	}
	
	public static WorldLayer getVerticalMazeJ(int iCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		Maze layer = new Maze(wor.getDim(), wor.getDim());
		for(int jCoord = 0; jCoord < wor.getDim(); jCoord++){
			for(int hCoord = 0; hCoord < wor.getDim(); hCoord++){
				layer.setMazeCoord(jCoord, hCoord, wor.getCoordValue(iCoord, jCoord, hCoord));
			}
		}
		wl.maze = layer;
		
		return wl;
	}
	
	public static WorldLayer getVerticalMazeI(int jCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		Maze layer = new Maze(wor.getDim(), wor.getDim());
		for(int iCoord = 0; iCoord < wor.getDim(); iCoord++){
			for(int hCoord = 0; hCoord < wor.getDim(); hCoord++){
				layer.setMazeCoord(iCoord, hCoord, wor.getCoordValue(iCoord, jCoord, hCoord));
			}
		}
		wl.maze = layer;
		
		return wl;
	}

}
