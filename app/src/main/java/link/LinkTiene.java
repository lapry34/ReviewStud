package link;
import _framework.EccezionePrecondizioni;
import attori.Corso;
import attori.Professore;

public class LinkTiene {

	//CAMPI DATI
	private final Professore prof;
	private final Corso corso;
	
	//COSTRUTTORE
	public LinkTiene(Professore prof, Corso corso) throws EccezionePrecondizioni {
		if(prof == null || corso == null) throw new EccezionePrecondizioni();
		this.prof = prof;
		this.corso = corso;
	}
	
	//GETTER
	public Professore getProf() {
		return prof;
	}
	
	public Corso getCorso() {
		return corso;
	}
	
	//FUNZIONI DI SERVIZIO
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkTiene l = (LinkTiene) o;
			return l.getProf() ==  prof && l.getCorso() ==  corso;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return prof.hashCode() + corso.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo e' un link tra: " + prof.toString() + " e " + corso.toString();
	}
	
}
