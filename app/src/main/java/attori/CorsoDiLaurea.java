package attori;
import java.util.HashSet;
import java.util.Set;

import _framework.EccezioneCardMax;
import _framework.EccezioneCardMin;
import link.LinkHa;
import link.LinkIscritto;
import manager.ManagerHa;
import manager.ManagerIscritto;

public class CorsoDiLaurea {
	//CAMPI DATI PRIVATI
	private final String nome;
	private final String ordinamento;
	private final boolean magistrale;
	private final int totCfu;
	
	//CAMPI ASSOCIAZIONE
	private HashSet<LinkIscritto> studenti;
	private HashSet<LinkHa> corsi;

	private final int ID;
	
	//COSTRUTTORE
	public CorsoDiLaurea(int ID, String nome, String ord, boolean mag) {
		this.ID = ID;
		this.nome = nome;
		this.ordinamento = ord;		
		this.magistrale = mag;
		totCfu = magistrale?120:180; 
		studenti = new HashSet<LinkIscritto>();
		corsi = new HashSet<LinkHa>();
	}
	
	//GETTER E SETTER	
	public String getNome() {
		return nome;
	}
	
	public String getOrd() {
		return ordinamento;
	}
	
	public int getCFU() {
		return totCfu;
	}
	
	public String getTipo() {
		return magistrale?"Laurea Magistrale":"Laurea Triennale";
	}
	
	//FUNZIONI PER CREARE E SETTARE I LINK
	//LINK ISCRITTO	0..n

	public Set<LinkIscritto> getLinkIscritto() throws EccezioneCardMin{
		return (HashSet<LinkIscritto>) studenti.clone();
	}
	
	public void insLinkIscritto(LinkIscritto l) {
		if(l != null && l.getCDL().equals(this)) {
			ManagerIscritto.add(l);
		}
	}
	
	public void rimLinkIscritto(LinkIscritto l) {
		if(l != null && l.getCDL().equals(this)) {
			ManagerIscritto.remove(l);
		}
	}

	public void insManIscritto(ManagerIscritto m) throws EccezioneCardMax {
		if(m !=null) studenti.add(m.getLink());
	}
	
	public void rimManIscritto(ManagerIscritto m) {
		if(m !=null) studenti.remove(m.getLink());
	}

	
	//LINK HA 1..n
	public int quantiHa() {
		return corsi.size();
	}
	
	public Set<LinkHa> getLinkHa() throws EccezioneCardMin{
		if(quantiHa() < 1) throw new EccezioneCardMin();
		return (HashSet<LinkHa>) corsi.clone();
	}
	
	public void insLinkHa(LinkHa l) {
		if(l != null && l.getCDL().equals(this)) {
			ManagerHa.add(l);
		}
	}
	
	public void rimLinkHa(LinkHa l) {
		if(l != null && l.getCDL().equals(this)) {
			ManagerHa.remove(l);
		}
	}
	
	public void insManHa(ManagerHa m) {
		if(m!=null) corsi.add(m.getLink());
	}

	public void rimManHa(ManagerHa m) {
		if(m!=null) corsi.remove(m.getLink());		
	}
	
	//TO STRING
	@Override
	public String toString() {
		String str = "Nome: " + this.nome +
				     " Ordinamento: " + this.ordinamento + (magistrale?", Laurea Magistrale":", Laurea Triennale") + 
				     " CFU totali: " + this.totCfu;	
		return str;
	}

	public int getID() {
		return ID;
	}
	
}
