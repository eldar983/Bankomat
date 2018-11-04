package zadaca;

import java.io.FileWriter;
import java.util.ArrayList;

public class ZapisnikRacuna {
	public static void store(ArrayList<KreirajRacun> racuni) throws Exception{
		String [] array = new String[racuni.size()];
		 FileWriter fw = new FileWriter("data.txt");
		for(int i=0;i<racuni.size();i++) {
			String line = racuni.get(i).getBrojRacuna()+
					" "+racuni.get(i).getStanjeRacuna()+
					" "+racuni.get(i).getImeKorisnika();
		
			array[i]=line;
		}

	    for (int i = 0; i < array.length; i++) {
	      fw.write(array[i] + "\n");
	    }
	    fw.close();
	  }

}
