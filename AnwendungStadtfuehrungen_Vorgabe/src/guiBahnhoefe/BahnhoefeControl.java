package guiBahnhoefe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.BahnhoefeModel;
import business.Bahnhof;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BahnhoefeControl implements Observer{

	public BahnhoefeControl(Stage primaryStage) {
		this.model =  BahnhoefeModel.getInstance();
		this.view = new BahnhoefeView(primaryStage,model,this);
		model.addObserver(this);
	}

	
	private BahnhoefeModel model;
	private BahnhoefeView view;
	//private Bahnhof bahnhof;
	
	public void nehmeBahnhofAuf(String name, String ort,int anzGleise,int letzteRenovierung, String[] zugarten ) {
		try{ 
    		model.addBahnhof( new Bahnhof(name, ort, anzGleise, letzteRenovierung,zugarten));
    		view.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
		
	}

	public void zeigeBahnhoefeAn() {
		
		if(model.getBahnhof().size()>0){
			StringBuffer  text = new StringBuffer();
			for(Bahnhof bahnhof:model.getBahnhof()) {
				text.append(bahnhof.gibBahnhofZurueck(' '));
			}
			
    		view.setText(text.toString());
    	}
    	else{
    		view.zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
    	}
    }    
		
	

	public void leseAusDatei(String typ) {
		try {
      		model.lese(typ);
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
			exc.printStackTrace();
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
			exc.printStackTrace();
		}
	}
		
	

	public void schreibeBahnhoefeInCsvDatei() {
		try {
			if(model.getBahnhof().size()>0){
				StringBuffer  text = new StringBuffer();
				for(Bahnhof bahnhof:model.getBahnhof()) {
					text.append(bahnhof.gibBahnhofZurueck(';'));
				}
				model.schreibe(text.toString());
	    	}
			
   			view.zeigeInformationsfensterAn(
	   			"Die Bahnhoefe wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
			exc.printStackTrace();
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		}
		
	}

	@Override
	public void update() {
		zeigeBahnhoefeAn();
		
	}
	
	
}
