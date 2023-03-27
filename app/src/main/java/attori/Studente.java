package attori;
import java.util.HashSet;
import java.util.Set;

import _framework.EccezioneCardMax;
import _framework.EccezioneCardMin;
import link.LinkIscritto;
import link.LinkScrive;
import manager.ManagerIscritto;
import manager.ManagerScrive;

public class Studente {
	//CAMPI DATI PRIVATI
	private final String nome;
	private final String cognome;
	private final String matricola;
	private String email;
	private String password;

	//CAMPI ASSOCIAZIONE
	private HashSet<LinkScrive> recensioni;
	private HashSet<LinkIscritto> cdl;

	public Studente(String nome, String cognome, String matricola, String email, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.setEmail(email);
		this.setPassword(password);
		recensioni = new HashSet<LinkScrive>();
		cdl = new HashSet<LinkIscritto>();
	}

	//GETTER E SETTER
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//FUNZIONI PER CREARE E SETTARE I LINK
	//LINK ISCRITTO	1..2
	public int quantiIscritto() {
		return cdl.size();
	}

	public Set<LinkIscritto> getLinkIscritto() throws EccezioneCardMin{
		if(quantiIscritto() < 1) throw new EccezioneCardMin();
		return (HashSet<LinkIscritto>) cdl.clone();
	}

	public void insLinkIscritto(LinkIscritto l) {
		if(l != null && l.getStudente().equals(this)) {
			ManagerIscritto.add(l);
		}
	}

	public void rimLinkIscritto(LinkIscritto l) {
		if(l != null && l.getStudente().equals(this)) {
			ManagerIscritto.remove(l);
		}
	}

	public void insManIscritto(ManagerIscritto m) throws EccezioneCardMax {
		if(quantiIscritto() > 2) throw new EccezioneCardMax();
		if(m !=null) cdl.add(m.getLink());
	}

	public void rimManIscritto(ManagerIscritto m) {
		if(m !=null) cdl.remove(m.getLink());
	}


	//LINK SCRIVE 0..n

	public Set<LinkScrive> getLinkScrive() throws EccezioneCardMin{
		return (HashSet<LinkScrive>) recensioni.clone();
	}

	public void insLinkScrive(LinkScrive l) {
		if(l != null && l.getStudente().equals(this)) {
			ManagerScrive.add(l);
		}
	}

	public void rimLinkScrive(LinkScrive l) {
		if(l != null && l.getStudente().equals(this)) {
			ManagerScrive.remove(l);
		}
	}

	public void insManScrive(ManagerScrive m) {
		if(m!=null) recensioni.add(m.getLink());
	}

	public void rimManScrive(ManagerScrive m) {
		if(m!=null) recensioni.remove(m.getLink());
	}

	//TO STRING
	@Override
	public String toString() {
		String str = "Nome: " + this.nome +
				" Cognome: " + this.cognome +
				" Matricola: " + this.matricola;
		return str;
	}

}
