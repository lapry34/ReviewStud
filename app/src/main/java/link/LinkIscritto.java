package link;
import _framework.EccezionePrecondizioni;
import attori.CorsoDiLaurea;
import attori.Studente;

public class LinkIscritto {

	//CAMPI DATI
	private final Studente stud;
	private final CorsoDiLaurea cdl;
	private final int annoIscrizione;
	private final int ID;
	
	//COSTRUTTORE
	public LinkIscritto(int ID, Studente stud, CorsoDiLaurea cdl, int anno) throws EccezionePrecondizioni {
		if(stud == null || cdl == null || anno == 0) throw new EccezionePrecondizioni();
		this.ID = ID;
		this.stud = stud;
		this.cdl = cdl;
		this.annoIscrizione = anno;
	}
	
	//GETTER
	public int getAnno() {
		return annoIscrizione;
	}
	
	public Studente getStudente() {
		return stud;
	}
	
	public CorsoDiLaurea getCDL() {
		return cdl;
	}
	
	//FUNZIONI DI SERVIZIO
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkIscritto l = (LinkIscritto) o;
			return l.getStudente() ==  stud && l.getCDL() ==  cdl;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return stud.hashCode() + cdl.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo è un link tra: " + stud.toString() + " e " + cdl.toString() + ". Anno di iscrizione: " + annoIscrizione;
	}

	public int getID() {
		return ID;
	}
	
}
