package link;
import _framework.EccezionePrecondizioni;
import attori.Corso;
import attori.CorsoDiLaurea;

public class LinkHa {

	//CAMPI DATI
	private final Corso corso;
	private final CorsoDiLaurea cdl;
	private final String annoCorso;		//STRINGA DEL TIPO 21-22 o 21/22
	
	//COSTRUTTORE
	public LinkHa(Corso corso, CorsoDiLaurea cdl, String anno) throws EccezionePrecondizioni {
		if(corso == null || cdl == null || anno == null) throw new EccezionePrecondizioni();
		this.corso = corso;
		this.cdl = cdl;
		this.annoCorso = anno;
	}
	
	//GETTER
	public String getAnno() {
		return annoCorso;
	}
	
	public Corso getCorso() {
		return corso;
	}
	
	public CorsoDiLaurea getCDL() {
		return cdl;
	}
	
	//FUNZIONI DI SERVIZIO
	@Override
	public boolean equals(Object o) {
		if(o !=  null && o.getClass().equals(this.getClass())) {
			LinkHa l = (LinkHa) o;
			return l.getCorso() ==  corso && l.getCDL() ==  cdl;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return corso.hashCode() + cdl.hashCode();
	}
	
	@Override
	public String toString() {
		return "Questo è un link tra: " + corso.toString() + " e " + cdl.toString() + ".\nAnno del Corso: " + annoCorso;
	}
	
}
