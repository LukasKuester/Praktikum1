package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsKuester.ConcreteReaderCreator;
import fileCreatorsKuester.ReaderCreatorKuester;
import fileCreatorsKuester.ReaderProductKuester;

public class BahnhoefeModel {
	
	private Bahnhof bahnhof;

	public Bahnhof getBahnhof() {
		return bahnhof;
	}

	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}
	//lese aus csv/txt datei methode
	public void lese(String typ) throws IOException {
		ReaderCreatorKuester creator= new ConcreteReaderCreator();
		ReaderProductKuester reader= creator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		this.bahnhof = new Bahnhof(zeile[0],zeile[1],Integer.parseInt(zeile[2]),Integer.parseInt(zeile[3]),zeile[4].split("_"));
		reader.schliesseDatei();
		
		
	}
	
	

	public void schreibe(String gibBahnhofZurueck) throws IOException {
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
	aus.write(gibBahnhofZurueck);
	aus.close();
		
	}

}
