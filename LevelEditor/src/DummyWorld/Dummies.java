package DummyWorld;

import Visualiser.Editor.*;

public class Dummies {
	
	public static void createDummy(World wor){
		int dim = wor.getDim();
		Maze maze = new Maze(dim);
		
		for(int num = 0; num < dim; num++){
			wor.getLevel().add(maze);
		}
		
		for(int hCoord = 0; hCoord < dim; hCoord++){
			wor.getLevel().get(hCoord).maze = new int[dim][dim];
			for(int iCoord = 0; iCoord < dim; iCoord++){
				for(int jCoord = 0; jCoord < dim; jCoord++){
					wor.getLevel().get(hCoord).setMazeCoord(iCoord, jCoord, 1);
				}
			}
		}
	}

}