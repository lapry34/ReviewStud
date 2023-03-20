package attori;
import _framework.EccezioneCardMin;
import link.LinkCV;
import link.LinkRV;
import link.LinkVP;
import manager.ManagerCV;
import manager.ManagerRV;
import manager.ManagerVP;

public final class Valutazione {
	LinkRV linkRV;
	LinkVP linkVP;
	LinkCV linkCV;
	
	private final int ID;
	public static final int MOLT = 1;
	
	public Valutazione(int ID) {
		super();
		this.ID = ID;
		linkRV = null;
		linkVP = null;
	}
	
	// ASSOCIAZIONI
	//RV
	public int quantiRV() {
		return linkRV ==  null ? 0 : 1;
	}

	public void insLinkRV(LinkRV link) {
		if(link !=  null && link.getVal().equals(this)) {
			ManagerRV.add(link);
		}
	}
	
	public void rimLinkRV(LinkRV link) {
		if(link !=  null && link.getVal().equals(this)) {
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
	
	//VP
	public int quantiVP() {
		return linkVP ==  null ? 0 : 1;
	}

	public void insLinkVP(LinkVP link) {
		if(link !=  null && link.getVal().equals(this)) {
			ManagerVP.add(link);
		}
	}
	
	public void rimLinkVP(LinkVP link) {
		if(link !=  null && link.getVal().equals(this)) {
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

	//CV
	public int quantiCV() {
		return linkRV ==  null ? 0 : 1;
	}

	public void insLinkCV(LinkCV link) {
		if(link !=  null && link.getVal().equals(this)) {
			ManagerCV.add(link);
		}
	}
	
	public void rimLinkCV(LinkCV link) {
		if(link !=  null && link.getVal().equals(this)) {
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

	public int getID() {
		return ID;
	}
	
}
