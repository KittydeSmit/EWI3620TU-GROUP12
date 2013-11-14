package Writer;

import Visualiser.Editor.*;
import java.io.*;

public class WriteWorld {
	
	public static void WorldWriter(World wor) throws IOException{
		int dim = wor.getDim();
		String name = wor.getName();
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(name + ".txt"));
		}
		catch(FileNotFoundException excepzione){
			System.out.println("File voor wegschrijven van " + name + " is niet gevonden, check");
		}
		
	}

}
