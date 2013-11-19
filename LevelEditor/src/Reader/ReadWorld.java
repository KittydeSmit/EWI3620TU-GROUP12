package Reader;

import Visualiser.Editor.*;
import DummyWorld.Dummies;
import java.io.*;
import java.util.*;

public class ReadWorld {
	
	private static World world;
	
	public static MissionPack readMissionPack(Scanner read) throws IOException{
		int aantal = 0;
		MissionPack mp = new MissionPack();
		
		try{
			aantal = read.nextInt();
		}catch(NumberFormatException excepzione){
			System.out.println("The amount of worlds in the file is not represented by an integer!");
			return null;
		}
		for(int num = 0; num < aantal; num++){
			mp.addWorld(World.read(read));
		}
		return mp;
	}
	
	public static World readWorld(Scanner read) throws IOException{
		int dim = 0;
		String name = "";
		
		try{
			name = read.next();
			dim = read.nextInt();
		}catch(NumberFormatException excepzione){
			System.out.println("The dimension of the level in the file is not represented by a number.");
			return null;
		}
		world = new World(dim, name);
		Dummies.createDummy(world);
		
		for(int i = 0; i < world.getDim(); i++){
			setLayers(world, read);
		}
		
		return world;
	}
	
	public static void setLayers(World world, Scanner read) throws IOException{
		int dim = world.getDim();
		
		try{
			for(int hCoord = 0; hCoord < dim; hCoord++){
				for(int iCoord = 0; iCoord < dim; iCoord++){
					for(int jCoord = 0; jCoord < dim; jCoord++){
						world.getLevel().get(hCoord).setMazeCoord(iCoord, jCoord, read.nextInt());
					}
				}
			}
		}catch(NumberFormatException excepzione){
			System.out.println("One or more of the entries in the maze part of your file is not a 1 or 0.");
			return;
		}
	}

}