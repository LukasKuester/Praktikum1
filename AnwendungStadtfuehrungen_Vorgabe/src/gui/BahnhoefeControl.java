package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.BahnhoefeModel;
import business.Bahnhof;
import javafx.stage.Stage;

public class BahnhoefeControl {

	public BahnhoefeControl(Stage primaryStage) {
		this.model = new BahnhoefeModel();
		this.view = new BahnhoefeView(primaryStage,model,this);
	}

	private BahnhoefeModel model;
	private BahnhoefeView view;
	//private Bahnhof bahnhof;
	
	public void nehmeBahnhofAuf(String name, String ort,int anzGleise,int letzteRenovierung, String[] zugarten ) {
		try{ 
    		model.setBahnhof( new Bahnhof(name, ort, anzGleise, letzteRenovierung,zugarten));
    		view.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
		
	}

	public void zeigeBahnhoefeAn() {
		if(model.getBahnhof() != null){
    		view.setText(
    			model.getBahnhof().gibBahnhofZurueck(' '));
    	}
    	else{
    		view.zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
    	}
    }    
		
	

	public void leseAusDatei(String typ) {
		try {
      		if("csv".equals(typ)){
      			String[] zeile = model.lese();
      			
      			model.setBahnhof(new Bahnhof(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_")));
      	  			view.zeigeInformationsfensterAn(
      	  	   			"Der Bahnhof wurde gelesen!");
      		}
       		else{
	   			view.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	

	public void schreibeBahnhoefeInCsvDatei() {
		try {
			model.schreibe(model.getBahnhof().gibBahnhofZurueck(';'));
			
   			view.zeigeInformationsfensterAn(
	   			"Die Bahnhoefe wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
		
	}
	
	
}
