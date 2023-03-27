package attori;
import java.util.HashSet;
import java.util.Set;

import _framework.EccezioneCardMin;
import link.LinkCV;
import link.LinkHa;
import link.LinkTiene;
import manager.ManagerCV;
import manager.ManagerHa;
import manager.ManagerTiene;

public class Corso {
	//CAMPI DATI PRIVATI
	private final String nome;
	private final String ssd;
	private final int cfu;
	private final int ID;
	
	//CAMPI ASSOCIAZIONE
	private LinkCV linkCV;
	private HashSet<LinkHa> cdl;
	private HashSet<LinkTiene> professori;

	//COSTRUTTORE
	public Corso(int ID, String nome, int cfu, String ssd) {
		this.nome = nome;
		this.cfu = cfu;
		this.ssd = ssd;
		this.ID = ID;		
		cdl = new HashSet<LinkHa>();
		professori = new HashSet<LinkTiene>();
	}
	
	//GETTER E SETTER
	
	public String getNome() {
		return nome;
	}

	public String getSsd() {
		return ssd;
	}
	
	public int getCFU() {
		return cfu;
	}
	
	//FUNZIONI PER CREARE E SETTARE I LINK
	//LINK HA 0..n

	public Set<LinkHa> getLinkHa(){
		return (HashSet<LinkHa>) cdl.clone();
	}
	
	public void insLinkHa(LinkHa l) {
		if(l != null && l.getCorso().equals(this)) {
			ManagerHa.add(l);
		}
	}
	
	public void rimLinkHa(LinkHa l) {
		if(l != null && l.getCorso().equals(this)) {
			ManagerHa.remove(l);
		}
	}
	
	public void insManHa(ManagerHa m) {
		if(m!=null) cdl.add(m.getLink());
	}

	public void rimManHa(ManagerHa m) {
		if(m!=null) cdl.remove(m.getLink());		
	}
	
	//LINK CV, N-ARIO
	public int quantiCV() {
		return linkCV ==  null ? 0 : 1;
	}

	public void insLinkCV(LinkCV link) {
		if(link !=  null && link.getCorso().equals(this)) {
			ManagerCV.add(link);
		}
	}
	
	public void rimLinkCV(LinkCV link) {
		if(link !=  null && link.getCorso().equals(this)) {
			ManagerCV.remove(link);
		}
	}
	
	public void insManCV(ManagerCV M) {
		if(M !=  null) {
			this.linkCV = M.getLink();
		}
	}	
	
	public void rimManCV(ManagerCV M) {
		if(M !=  null) {
			this.linkCV = null;
		}
	}
	
	public LinkCV getLinkCV() throws EccezioneCardMin {
		if(quantiCV() > 0) return linkCV;
		else throw new EccezioneCardMin();
	}

	//LINK TIENE 1..n
	public int quantiTiene() {
		return professori.size();
	}

	public Set<LinkTiene> getLinkTiene() throws EccezioneCardMin{
		if(quantiTiene() < 1) throw new EccezioneCardMin();
		return (HashSet<LinkTiene>) professori.clone();
	}
	
	public void insLinkTiene(LinkTiene l) {
		if(l != null && l.getCorso().equals(this)) {
			ManagerTiene.add(l);
		}
	}
	
	public void rimLinkTiene(LinkTiene l) {
		if(l != null && l.getCorso().equals(this)) {
			ManagerTiene.remove(l);
		}
	}
	
	public void insManTiene(ManagerTiene m) {
		if(m!=null) professori.add(m.getLink());
	}

	public void rimManTiene(ManagerTiene m) {
		if(m!=null) professori.remove(m.getLink());		
	}
	
	
	//TO STRING
	@Override
	public String toString() {
		String str = "Nome: " + this.nome +
				     " SSD: " + this.ssd +
				     " CFU: " + this.cfu;	
		return str;
	}

	public int getID() {
		return ID;
	}


	
}
