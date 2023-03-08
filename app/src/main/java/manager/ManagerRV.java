package manager;
import _framework.EccezioneCardMin;
import link.LinkRV;

public final class ManagerRV {
	private final LinkRV link;
	private ManagerRV(LinkRV link) {
		this.link = link;
	}
	
	public LinkRV getLink() {
		return this.link;
	}
	
	public static void add(LinkRV link) {
		try {
			if(link !=  null && link.getRec().getLinkRV() ==  null && link.getVal().getLinkRV() ==  null) {
				ManagerRV M = new ManagerRV(link);
				link.getRec().insManRV(M);
				link.getVal().insManRV(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(LinkRV link) {
		try {
			if(link !=  null && link.getRec().getLinkRV().equals(link)) {
				ManagerRV M = new ManagerRV(link);
				link.getRec().rimManRV(M);
				link.getVal().rimManRV(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
}
