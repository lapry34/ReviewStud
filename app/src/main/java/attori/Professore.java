package attori;
import java.util.HashSet;
import java.util.Set;

import _framework.EccezioneCardMin;
import link.LinkTiene;
import link.LinkVP;
import manager.ManagerTiene;
import manager.ManagerVP;

public class Professore {
	//CAMPI PRIVATI
	private final String nome;
	private final String cognome;
	//CAMPI ASSOCIAZIONI
	private LinkVP linkVP;
	private HashSet<LinkTiene> corsi;
	
	private final int ID;
	
	public Professore(int ID, String nome, String cognome) {
		super();
		this.ID = ID;
		this.linkVP = null;
		this.nome = nome;
		this.cognome = cognome;
		corsi = new HashSet<LinkTiene>();
	}

	//GETTER
	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Prof. " + nome + " " + cognome;
	}
	
	//LINK VP
	public int quantiVP() {
		return linkVP ==  null ? 0 : 1;
	}

	public void insLinkVP(LinkVP link) {
		if(link !=  null && link.getProf().equals(this)) {
			ManagerVP.add(link);
		}
	}
	
	public void rimLinkVP(LinkVP link) {
		if(link !=  null && link.getProf().equals(this)) {
			ManagerVP.remove(link);
		}
	}
	
	public void insManVP(ManagerVP M) {
		if(M !=  null) {
			this.linkVP = M.getLink();
		}
	}
	
	public void rimManVP(ManagerVP M) {
		if(M !=  null) {
			this.linkVP = null;
		}
	}
	
	public LinkVP getLinkVP() throws EccezioneCardMin {
		if(quantiVP() > 0) return linkVP;
		else throw new EccezioneCardMin();
	}
	
	
	//LINK TIENE 1..n
	public int quantiTiene() {
		return corsi.size();
	}
	
	public Set<LinkTiene> getLinkTiene() throws EccezioneCardMin{
		if(quantiTiene() < 1) throw new EccezioneCardMin();
		return (HashSet<LinkTiene>) corsi.clone();
	}
	
	public void insLinkTiene(LinkTiene l) {
		if(l != null && l.getProf().equals(this)) {
			ManagerTiene.add(l);
		}
	}
	
	public void rimLinkTiene(LinkTiene l) {
		if(l != null && l.getProf().equals(this)) {
			ManagerTiene.remove(l);
		}
	}
	
	public void insManTiene(ManagerTiene m) {
		if(m!=null) corsi.add(m.getLink());
	}

	public void rimManTiene(ManagerTiene m) {
		if(m!=null) corsi.remove(m.getLink());		
	}

	public int getID() {
		return ID;
	}
		
}
