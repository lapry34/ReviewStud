package manager;
import link.LinkScrive;

public final class ManagerScrive {
	private final LinkScrive link;
	
	private ManagerScrive(LinkScrive link) {
		this.link = link;
	}
	
	public LinkScrive getLink() {
		return this.link;
	}
	
	public static void add(LinkScrive link) {
		if(link !=  null) {
			ManagerScrive M = new ManagerScrive(link);
			link.getStudente().insManScrive(M);
			link.getRec().insManScrive(M);
		}
	}
	
	public static void remove(LinkScrive link) {
		if(link !=  null) {
			ManagerScrive M = new ManagerScrive(link);
			link.getStudente().rimManScrive(M);
			link.getRec().rimManScrive(M);
		}
	}
	
}
