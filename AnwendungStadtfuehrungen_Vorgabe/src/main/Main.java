package main;
import guiAngebot.MobilitaetsangeboteControl;
import guiBahnhoefe.BahnhoefeAnwendungssystem;
import guiBahnhoefe.BahnhoefeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BahnhoefeControl(primaryStage);
		Stage fensterAngebote =  new  Stage();
		new  MobilitaetsangeboteControl(fensterAngebote);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
