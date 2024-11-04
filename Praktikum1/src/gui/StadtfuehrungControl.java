package gui;

import java.io.IOException;

import business.Stadtfuehrung;
import business.StadtfuehrungModel;
import javafx.stage.Stage;

public class StadtfuehrungControl {

	
	private StadtfuehrungView view;
	private StadtfuehrungModel model;
	
    public StadtfuehrungControl(Stage stage) {
		super();
		this.model = new StadtfuehrungModel(this);
		this.view = new StadtfuehrungView(stage, this, model);
	}
    
	public void nehmeStadtfuehrungAuf(){
    	try {
    		model.setStadtfuehrung(new Stadtfuehrung(
    			view.getTxtTitel().getText(), 
   	            view.getTxtIdentnummer().getText(),
   	            view.getTxtKurzbeschreibung().getText(),
    		    Float.parseFloat(view.getTxtStartuhrzeit().getText()),
    		    view.getTxtDatum().getText(),
    		    view.getTxtMaterialien().getText().split(";")));
    		view.zeigeInformationsfensterAn("Die Stadtführung wurde aufgenommen!");
       	} catch (Exception exc) {
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }

    public void schreibeStadtfuehrungInDatei() {
    	try {
			model.schreibeStadtfuehrungInCsvDatei();
		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			System.out.println(exc);
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
    }
    
    public void leseAusDateien(String typ) {
    	try {
			model.leseAusDatei(typ);
		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
    }

}
