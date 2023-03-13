package link;
import _framework.EccezionePrecondizioni;
import attori.Recensione;
import attori.Valutazione;

public class LinkRV {
	
	private final Recensione rec;
	private final Valutazione val;
	
	public LinkRV(Recensione rec, Valutazione val) throws EccezionePrecondizioni {
		if(rec ==  null || val ==  null) throw new EccezionePrecondizioni();
		this.rec = rec;
		this.val = val;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkRV l = (LinkRV) o;
			return l.rec ==  rec && l.val ==  val;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return rec.hashCode() + val.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo e' un link tra: " + rec.toString() + " e " + val.toString();
	}
	

	public Recensione getRec() {
		return rec;
	}

	public Valutazione getVal() {
		return val;
	}
	
}
