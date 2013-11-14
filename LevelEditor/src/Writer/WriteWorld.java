package Writer;

import Visualiser.Editor.*;
import java.io.*;

/**
 * Deze klasse heeft de write methodes voor een World en een Maze, die in combinatie gebruikt worden om een
 * hele World, die in feite uit meerdere Mazes op elkaar bestaat, te kunnen documenteren in een .txt bestand
 * @author Gma-X
 *
 */
public class WriteWorld {
	
	private World world;
	
	/**
	 * De WorldWriter maakt de Writer aan die doorgegeven wordt aan MazeWriter en geeft de naam van de World
	 * ook aan de .txt file waarin uiteindelijk geschreven wordt. Na het schrijven van de dimensie van de
	 * World wordt de MazeWriter dimensie maal opgeroepen
	 * <p>
	 * @param wor De World die geschreven moet worden
	 * @throws IOException Een exception kan opgegooid worden als de naam van de .txt file niet gevonden kan worden
	 */
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
			out.write(Integer.toString(dim));
			out.newLine(); out.newLine();
			for(int height = 0; height < dim; height++){
				MazeWriter(out, height);
			}
		}
	}
	
	/**
	 * MazeWriter schrijft de string representaties van de Mazes, waaruit de World bestaat, naar de .txt file
	 * onder elkaar, gescheiden door een witregel
	 * <p>
	 * @param out De BufferedWriter die doorgegeven is door WorldWriter
	 * @param height Geeft aan welke Maze(op hoogte height in de World) geschreven moet worden naar de .txt file
	 * @throws IOException Gooit een exception op als er een schrijffout is
	 */
	public void MazeWriter(BufferedWriter out, int height) throws IOException{
		try{
		out.write(world.getHoriLayerH(height).maze.toString());
		out.newLine();
		}
		catch(IOException excepzione){
			System.out.println("Unknown error at MazeWriter, pleas take a look at this method.");
		}
	}

}
