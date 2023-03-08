package manager;
import _framework.EccezioneCardMin;
import link.LinkVP;

public final class ManagerVP {
	private final LinkVP link;
	private ManagerVP(LinkVP link) {
		this.link = link;
	}
	
	public LinkVP getLink() {
		return this.link;
	}
	
	public static void add(LinkVP link) {
		try {
			if(link !=  null && link.getProf().getLinkVP() ==  null && link.getVal().getLinkVP() ==  null) {
				ManagerVP M = new ManagerVP(link);
				link.getProf().insManVP(M);
				link.getVal().insManVP(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(LinkVP link) {
		try {
			if(link !=  null && link.getProf().getLinkVP().equals(link)) {
				ManagerVP M = new ManagerVP(link);
				link.getProf().rimManVP(M);
				link.getVal().rimManVP(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
}
