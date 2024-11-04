package gui;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

/*public class StadtfuehrungAnwendersystem {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblStadtname				= new Label("Stadtname:");
    private Label lblWohnraum				= new Label("Wohnraum:");
    private Label lblStil					= new Label("Stil:");
    private Label lblPreis					= new Label("Preis:");
    private Label lblMaterialien			= new Label("Materialien:");
    private TextField txtStadtname			= new TextField();
    private TextField txtWohnraum			= new TextField();
    private TextField txtStil				= new TextField();
    private TextField txtPreis				= new TextField();
    private TextField txtMaterialien			= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Stadtfuehrung
    private Stadtfuehrung stadtfuehrung;
    
    public StadtfuehrungAnwendersystem(Stage primaryStage) {
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Stadtführungen");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten() {
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblStadtname.setLayoutX(20);
    	lblStadtname.setLayoutY(90);
    	lblWohnraum.setLayoutX(20);
    	lblWohnraum.setLayoutY(130);
    	lblStil.setLayoutX(20);
    	lblStil.setLayoutY(170);
    	lblPreis.setLayoutX(20);
    	lblPreis.setLayoutY(210);
    	lblMaterialien.setLayoutX(20);
    	lblMaterialien.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblStadtname, lblWohnraum, lblStil,
       		lblPreis, lblMaterialien);
    
    	// Textfelder
     	txtStadtname.setLayoutX(170);
    	txtStadtname.setLayoutY(90);
    	txtStadtname.setPrefWidth(200);
    	txtWohnraum.setLayoutX(170);
    	txtWohnraum.setLayoutY(130);
    	txtWohnraum.setPrefWidth(200);
    	txtStil.setLayoutX(170);
    	txtStil.setLayoutY(170);
    	txtStil.setPrefWidth(200);
      	txtPreis.setLayoutX(170);
    	txtPreis.setLayoutY(210);
    	txtPreis.setPrefWidth(200);
    	txtMaterialien.setLayoutX(170);
    	txtMaterialien.setLayoutY(250);
    	txtMaterialien.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtStadtname, txtWohnraum, txtStil,
     		txtPreis, txtMaterialien);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menü
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeStadtfuehrungAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeStadtfuehrungAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeStadtfuehrungInCsvDatei();
			}	
	    });
    }
    
    private void nehmeStadtfuehrungAuf() {
    	try {
    		this.stadtfuehrung = new Stadtfuehrung(
    			txtStadtname.getText(), 
   	            txtWohnraum.getText(),
   	            txtStil.getText(),
    		    Float.parseFloat(txtPreis.getText()),
    		    txtMaterialien.getText().split(";"));
    		zeigeInformationsfensterAn("Die Stadtführung wurde aufgenommen!");
       	}
       	catch(Exception exc) {
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeStadtfuehrungAn() {
    	if(this.stadtfuehrung != null) {
    		txtAnzeige.setText(
    			this.stadtfuehrung.gibStadtfuehrungZurueck(' '));
    	} else {
    		zeigeInformationsfensterAn("Bisher wurde keine Stadtführung aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ) {
    	try {
      		if("csv".equals(typ)) {
      			BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.stadtfuehrung = new Stadtfuehrung(zeile[0], 
      				zeile[1], 
      				zeile[2], 
      				Float.parseFloat(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn("Die Stadtführungen wurden gelesen!");
      		} else {
	   			zeigeInformationsfensterAn("Noch nicht implementiert!");
	   		}
		} catch(IOException exc) {
			zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch(Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}
		
    private void schreibeStadtfuehrungInCsvDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true));
			aus.write(stadtfuehrung.gibStadtfuehrungZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Stadtführungen wurden gespeichert!");
		} catch(IOException exc) {
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		} catch(Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
    private void zeigeInformationsfensterAn(String meldung) {
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	

    void zeigeFehlermeldungsfensterAn(String meldung) {
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
}  */
				
