package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fileCreatorsKuester.ConcreteReaderCreator;
import fileCreatorsKuester.ReaderCreatorKuester;
import fileCreatorsKuester.ReaderProductKuester;
import ownUtil.Observable;
import ownUtil.Observer;

public class BahnhoefeModel implements Observable{
	
	private ArrayList<Bahnhof> bahnhoefe=new ArrayList<>();

	public ArrayList<Bahnhof> getBahnhof() {
		return bahnhoefe;
	}

	public void addBahnhof(Bahnhof bahnhof) {
		bahnhoefe.add(bahnhof);
		//Testfall:Dortmund oespel Dortmund 2 1993 rb s
		notifyObservers();
	}
	//lese aus csv/txt datei methode
	public void lese(String typ) throws IOException {
		ReaderCreatorKuester creator= new ConcreteReaderCreator();
		ReaderProductKuester reader= creator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		bahnhoefe.add(new Bahnhof(zeile[0],zeile[1],Integer.parseInt(zeile[2]),Integer.parseInt(zeile[3]),zeile[4].split("_")));
		reader.schliesseDatei();
		notifyObservers();
		
	}
	
	

	public void schreibe(String gibBahnhofZurueck) throws IOException {
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
	aus.write(gibBahnhofZurueck);
	aus.close();
		
	}
	
	private static BahnhoefeModel instance;
	private BahnhoefeModel() {}
	public static BahnhoefeModel getInstance() {
		if(instance==null) {
			instance= new BahnhoefeModel();
		}
		return instance;
	}

	private Vector<Observer> observers= new Vector<Observer>();
	@Override
	public void addObserver(Observer obs) {

		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++) {
			observers.elementAt(i).update();
		}
		
	}

}
