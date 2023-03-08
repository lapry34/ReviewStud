package manager;
import _framework.EccezioneCardMax;
import link.LinkIscritto;

public final class ManagerIscritto {
	private final LinkIscritto link;
	
	private ManagerIscritto(LinkIscritto link) {
		this.link = link;
	}
	
	public LinkIscritto getLink() {
		return this.link;
	}
	
	public static void add(LinkIscritto link) {
		try {
			if(link !=  null) {
				ManagerIscritto M = new ManagerIscritto(link);
				link.getStudente().insManIscritto(M);
				link.getCDL().insManIscritto(M);
			}
		} catch (EccezioneCardMax e2) {
			e2.printStackTrace();
		}
	}
	
	public static void remove(LinkIscritto link) {
		if(link !=  null) {
			ManagerIscritto M = new ManagerIscritto(link);
			link.getStudente().rimManIscritto(M);
			link.getCDL().rimManIscritto(M);
		}
	}
	
}
