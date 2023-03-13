package manager;
import link.LinkHa;

public final class ManagerHa {
	private final LinkHa link;
	
	private ManagerHa(LinkHa link) {
		this.link = link;
	}
	
	public LinkHa getLink() {
		return this.link;
	}
	
	public static void add(LinkHa link) {
		if(link !=  null) {
			ManagerHa M = new ManagerHa(link);
			link.getCorso().insManHa(M);
			link.getCDL().insManHa(M);
		}
	}
	
	public static void remove(LinkHa link) {
		if(link !=  null) {
			ManagerHa M = new ManagerHa(link);
			link.getCorso().rimManHa(M);
			link.getCDL().insManHa(M);
		}
	}
	
}
