package Writer;

import Visualiser.Editor.*;
import java.io.*;

public class WriteWorld {
	
	private World world;
	
	public void WorldWriter(World wor) throws IOException{
		int dim = wor.getDim();
		world = wor;
		String name = wor.getName();
		File level = new File(name + ".txt");
		BufferedWriter out = null;
		boolean itWorked = false;
		
		try{
			out = new BufferedWriter(new FileWriter(level));
			itWorked = true;
		}
		catch(FileNotFoundException excepzione){
			System.out.println("File voor wegschrijven van " + name + " is niet gevonden, check");
		}
		
		if(itWorked){
			out.write(Integer.toString(dim) + ";");
			out.newLine(); out.newLine();
			for(int height = 0; height < dim; height++){
				MazeWriter(out, height);
			}
		}
	}
	
	public void MazeWriter(BufferedWriter out, int height) throws IOException{
		try{
		out.write(world.getHoriLayerH(height, world).maze.toString());
		}
		catch(IOException excepzione){
			System.out.println("Unknown error at MazeWriter, pleas take a look at this method.");
		}
	}

}
