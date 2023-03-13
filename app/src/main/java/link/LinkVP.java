package link;
import _framework.EccezionePrecondizioni;
import attori.Professore;
import attori.Valutazione;

public class LinkVP {
	
	private final Valutazione val;
	private final Professore prof;
	
	public LinkVP(Valutazione val, Professore prof) throws EccezionePrecondizioni {
		if(val ==  null || prof ==  null) throw new EccezionePrecondizioni();
		this.val = val;
		this.prof = prof;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkVP l = (LinkVP) o;
			return l.prof ==  prof && l.val ==  val;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return prof.hashCode() + val.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo e' un link tra: " + val.toString() + " e " + prof.toString();
	}
	

	public Professore getProf() {
		return prof;
	}

	public Valutazione getVal() {
		return val;
	}
	
}
