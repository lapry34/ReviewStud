package attori;

public class Risultato {
	
	public static enum Appello {
		PRIMO("Primo"), 
		SECONDO("Secondo");

		private final String label;
		
		Appello(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
		
	}
	public static enum Sessione {
		INVERNALE("Invernale"),
		ESTIVA("Estiva"),
		SETTEMBRE("Settembre"), 
		I_STRAORDINARIA("Primavera"),
		II_STRAORDINARIA("Autunno");
		
		private final String label;
		
		Sessione(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}
	
	private final int ID;
	private final Appello appello;
	private final Sessione sessione;
	private final boolean esonero;
	
	
	public Risultato(int ID, Appello appello, Sessione sessione, boolean esonero) {
		super();
		this.ID = ID;
		this.appello = appello;
		this.sessione = sessione;
		this.esonero = esonero;
	}


	public boolean isEsonero() {
		return esonero;
	}


	public Sessione getSessione() {
		return sessione;
	}


	public Appello getAppello() {
		return appello;
	}
	
	@Override
	public String toString() {
		String str = "Appello: " + appello.label + 
				   " Sessione: " + sessione.label +
				   " Esonero: " + (esonero ? "Si" : "No");
		return str;
	}


	public int getID() {
		return ID;
	}
	
}
