package business;

public class Stadtfuehrung {
	

		
		// Titel der Stadtführung
	    private String titel;
	    // Identifikationsnummer
	    private String identnummer;
	    // Kurzbeschreibung
	    private String kurzbeschreibung;
	    // Startuhrzeit
	    private float startuhrzeit;
	    // Datum der Stadtführung
	    private String datum;
	    // Materialien, die für die Führung benötigt werden
	    private String[] materialien;

	    public Stadtfuehrung(String titel, String identnummer, String kurzbeschreibung, 
	    	float startuhrzeit, String datum, String[] materialien){
	   		this.titel = titel;
	  	    this.identnummer = identnummer;
	   	    this.kurzbeschreibung = kurzbeschreibung;
	   	    this.startuhrzeit = startuhrzeit;
	   	    this.datum = datum;
	   	    this.materialien = materialien;
	    }
	    
		public String getTitel() {
			return titel;
		}

		public void setTitel(String titel) {
			this.titel = titel;
		}

		public String getIdentnummer() {
			return identnummer;
		}

		public void setIdentnummer(String identnummer) {
			this.identnummer = identnummer;
		}

		public String getKurzbeschreibung() {
			return kurzbeschreibung;
		}

		public void setKurzbeschreibung(String kurzbeschreibung) {
			this.kurzbeschreibung = kurzbeschreibung;
		}

		public float getStartuhrzeit() {
			return startuhrzeit;
		}

		public void setStartuhrzeit(float startuhrzeit) {
			this.startuhrzeit = startuhrzeit;
		}

		public String getDatum() {
			return datum;
		}

		public void setDatum(String datum) {
			this.datum = datum;
		}

		public String[] getMaterialien() {
			return materialien;
		}

		public void setMaterialien(String[] materialien) {
			this.materialien = materialien;
		}
		
		public String getMaterialienAlsString(char trenner) {
			StringBuilder ergebnis = new StringBuilder();
			for (int i = 0; i < this.getMaterialien().length - 1; i++) {
				ergebnis.append(this.getMaterialien()[i]).append(trenner);
			}
			return ergebnis.append(this.getMaterialien()[this.getMaterialien().length - 1]).toString();
		}
		
		public String gibStadtfuehrungZurueck(char trenner){
	  		return this.getTitel() + trenner 
	  			+ this.getIdentnummer() + trenner
	  		    + this.getKurzbeschreibung() + trenner
	  		    + this.getStartuhrzeit() + trenner 
	  		    + this.getDatum() + trenner + "\n"
	  		    + this.getMaterialienAlsString(trenner) + "\n";
	  	}

}


