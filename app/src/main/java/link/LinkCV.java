package link;
import _framework.EccezionePrecondizioni;
import attori.Corso;
import attori.Valutazione;

public class LinkCV {
	
	private final Corso corso;
	private final Valutazione val;
	
	public LinkCV(Corso corso, Valutazione val) throws EccezionePrecondizioni {
		if(corso ==  null || val ==  null) throw new EccezionePrecondizioni();
		this.corso = corso;
		this.val = val;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkCV l = (LinkCV) o;
			return l.getCorso() ==  corso && l.getVal() ==  val;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return corso.hashCode() + val.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo è un link tra: " + corso.toString() + " e " + val.toString();
	}
	

	public Corso getCorso() {
		return corso;
	}

	public Valutazione getVal() {
		return val;
	}
	
}
