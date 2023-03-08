package manager;
import link.LinkTiene;

public final class ManagerTiene {
	private final LinkTiene link;
	
	private ManagerTiene(LinkTiene link) {
		this.link = link;
	}
	
	public LinkTiene getLink() {
		return this.link;
	}
	
	public static void add(LinkTiene link) {
		if(link !=  null) {
			ManagerTiene M = new ManagerTiene(link);
			link.getProf().insManTiene(M);
			link.getCorso().insManTiene(M);
		}
	}
	
	public static void remove(LinkTiene link) {
		if(link !=  null) {
			ManagerTiene M = new ManagerTiene(link);
			link.getProf().rimManTiene(M);
			link.getCorso().rimManTiene(M);
		}
	}
	
}
