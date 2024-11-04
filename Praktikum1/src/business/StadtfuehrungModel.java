package business;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import gui.StadtfuehrungControl;
import gui.StadtfuehrungView;

public class StadtfuehrungModel {

	
	
	
		private StadtfuehrungView view;
		private StadtfuehrungControl control;
	    private Stadtfuehrung stadtfuehrung;
	    
	    public StadtfuehrungModel(StadtfuehrungControl control) {
	    	this.setControl(control);
		}

		public void schreibeStadtfuehrungInCsvDatei() throws IOException{
			BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", false));
			aus.write(stadtfuehrung.gibStadtfuehrungZurueck(';'));
			aus.close();
			view.zeigeInformationsfensterAn("Die Stadtführung wurde gespeichert!");
			System.out.println(stadtfuehrung.gibStadtfuehrungZurueck(';'));
		}
		
		public void leseAusDatei(String typ) throws IOException{
	  		if("csv".equals(typ)){
	  			BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
	  			String[] zeile = ein.readLine().split(";");
	  			this.stadtfuehrung = new Stadtfuehrung(
	  				zeile[0], zeile[1], zeile[2],
	  				Float.parseFloat(zeile[3]), zeile[4],
	  				zeile[5].split("_"));
	  				ein.close();
	  	  			view.zeigeInformationsfensterAn("Die Stadtführung wurde gelesen!");
	  		}
	   		else{
	   			view.zeigeInformationsfensterAn("Noch nicht implementiert!");
	   		}
		}

		public Stadtfuehrung getStadtfuehrung() {
			return this.stadtfuehrung;
		}

		public void setStadtfuehrung(Stadtfuehrung stadtfuehrung) {
			this.stadtfuehrung = stadtfuehrung;
		}

		public StadtfuehrungControl getControl() {
			return control;
		}

		public void setControl(StadtfuehrungControl control) {
			this.control = control;
		}
	}

	

