package link;
import _framework.EccezionePrecondizioni;
import attori.Recensione;
import attori.Studente;

public class LinkScrive {

	public final Studente stud;
	public final Recensione rec;
	
	public LinkScrive(Studente stud, Recensione rec) throws EccezionePrecondizioni {
		if(stud == null || rec == null) throw new EccezionePrecondizioni();
		this.stud = stud;
		this.rec = rec;
	}
	
	
	public Studente getStudente() {
		return stud;
	}
	
	public Recensione getRec() {
		return rec;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkScrive l = (LinkScrive) o;
			return l.getStudente() ==  stud && l.getRec() ==  rec;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return stud.hashCode() + rec.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo e' un link tra: " + stud.toString() + " e " + rec.toString();
	}
	
}
