package manager;
import _framework.EccezioneCardMin;
import link.LinkCV;

public final class ManagerCV {
	private final LinkCV link;
	private ManagerCV(LinkCV link) {
		this.link = link;
	}
	
	public LinkCV getLink() {
		return this.link;
	}
	
	public static void add(LinkCV link) {
		try {
			if(link !=  null && link.getCorso().getLinkCV() ==  null && link.getVal().getLinkRV() ==  null) {
				ManagerCV M = new ManagerCV(link);
				link.getCorso().insManCV(M);
				link.getVal().insManCV(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(LinkCV link) {
		try {
			if(link !=  null && link.getCorso().getLinkCV().equals(link)) {
				ManagerCV M = new ManagerCV(link);
				link.getCorso().rimManCV(M);
				link.getVal().rimManCV(M);
			}
		} catch (EccezioneCardMin e) {
			e.printStackTrace();
		}
	}
	
}
