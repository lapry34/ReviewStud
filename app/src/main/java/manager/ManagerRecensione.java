package manager;

import _framework.EccezioneCardMin;
import link.LinkCV;
import link.LinkRV;
import link.LinkVP;

public final class ManagerRecensione {
    private ManagerRecensione() {}


    public static void add(LinkRV rv, LinkVP vp, LinkCV cv) {
        try {
            if( rv.getVal().equals(vp.getVal()) && vp.getVal().equals(cv.getVal()) && // hanno lo stesso val
                    vp.getProf().getLinkTiene().containsAll(cv.getCorso().getLinkTiene())){ //se il prof è associato al corso
                ManagerRV.add(rv);
                ManagerVP.add(vp);
                ManagerCV.add(cv);
            }
        } catch (EccezioneCardMin e) {
            e.printStackTrace();
        }
    }

    public static void remove(LinkRV rv, LinkVP vp, LinkCV cv) {
        try {
            if( rv.getVal().getLinkRV().equals(rv) && vp.getVal().getLinkVP().equals(vp) && cv.getVal().getLinkCV().equals(cv) &&
                    rv.getVal().equals(vp.getVal()) && vp.getVal().equals(cv.getVal()) &&
                    vp.getProf().getLinkTiene().containsAll(cv.getCorso().getLinkTiene())){ //se il prof è associato al corso
                ManagerRV.add(rv);
                ManagerVP.add(vp);
                ManagerCV.add(cv);
            }
        } catch (EccezioneCardMin e) {
            e.printStackTrace();
        }
    }

}
