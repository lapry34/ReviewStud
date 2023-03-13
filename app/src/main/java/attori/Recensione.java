package attori;
import _framework.EccezioneCardMin;
import link.LinkRV;
import link.LinkScrive;
import manager.ManagerRV;
import manager.ManagerScrive;

public class Recensione {
	//CAMPI PRIVATI
	private final String testo;
	private final int voto;
	private final Risultato risultato;
	
	//CAMPI LINK
	private LinkRV linkRV;
	public static final int CARD_RV = 1;
	private LinkScrive studente;
	
	
	public Recensione(String testo, int voto, Risultato risultato) throws EccezioneCardMin {
		super();
		if(risultato ==  null) throw new EccezioneCardMin();
		this.linkRV = null;
		this.testo = testo;
		this.voto = voto;
		this.risultato = risultato;
	}

	//GETTER E SETTER
	public String getTesto() {
		return testo;
	}

	public int getVoto() {
		return voto;
	}

	public Risultato getRisultato() {
		return risultato;
	}
	
	//TO STRING
	@Override
	public String toString() {
		String str = "Testo: " + this.testo +
				     " Voto: " + this.voto +
				     " " + risultato.toString();
		
		return str;
	}
	
	//ASSOCIAZIONE R-V	1..1
	public int quantiRV() {
		return linkRV ==  null ? 0 : 1;
	}

	public void insLinkRV(LinkRV link) {
		if(link !=  null && link.getRec().equals(this)) {
			ManagerRV.add(link);
		}
	}
	
	public void rimLinkRV(LinkRV link) {
		if(link !=  null && link.getRec().equals(this)) {
			ManagerRV.remove(link);
		}
	}
	
	public void insManRV(ManagerRV M) {
		if(M !=  null) {
			this.linkRV = M.getLink();
		}
	}
	
	public void rimManRV(ManagerRV M) {
		if(M !=  null) {
			this.linkRV = null;
		}
	}
	
	public LinkRV getLinkRV() throws EccezioneCardMin {
		if(quantiRV() > 0) return linkRV;
		else throw new EccezioneCardMin();
	}
	
	//ASSOCIAZIONE Scritto	1..1
	public int quantiScrive() {
		return studente ==  null ? 0 : 1;	
	}

	public void insLinkScrive(LinkScrive link) {
		if(link !=  null && link.getRec().equals(this)) {
			ManagerScrive.add(link);
		}
	}
	
	public void rimLinkScrive(LinkScrive link) {
		if(link !=  null && link.getRec().equals(this)) {
			ManagerScrive.remove(link);
		}
	}
	
	public void insManScrive(ManagerScrive m) {
		if(m!= null) this.studente = m.getLink();
	}
	
	public void rimManScrive(ManagerScrive m) {
		if(m!= null) this.studente = null;
	}
	
	public LinkScrive getLinkScritto() throws EccezioneCardMin {
		if(quantiRV() > 0) return studente;
		else throw new EccezioneCardMin();
	}
}
