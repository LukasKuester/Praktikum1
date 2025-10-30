package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BahnhoefeModel {

	public String[] lese() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));
			String[] zeile = ein.readLine().split(";");
			ein.close();
			return zeile;
	}

	public void schreibe(String gibBahnhofZurueck) throws IOException {
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
	aus.write(gibBahnhofZurueck);
	aus.close();
		
	}

}
