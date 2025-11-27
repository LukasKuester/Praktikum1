package guiAngebot;

import business.BahnhoefeModel;
import javafx.stage.Stage;
import ownUtil.Observer;
public class MobilitaetsangeboteControl implements Observer{	
	private MobilitaetsangeboteView
 		mobilitaetsangeboteView;
	private BahnhoefeModel bahnhoefeModel;
	public MobilitaetsangeboteControl(Stage primaryStage){
 		this.bahnhoefeModel = BahnhoefeModel.getInstance();		
		this.mobilitaetsangeboteView 
		 	= new MobilitaetsangeboteView(this, primaryStage,
			bahnhoefeModel);
		bahnhoefeModel.addObserver(this);
	}
	@Override
	public void update() {
		mobilitaetsangeboteView.zeigeBahnhoefeAn();
		
	}
}
