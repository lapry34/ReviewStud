package _framework;

public class EccezionePrecondizioni extends Exception {

    private static final long serialVersionUID = 6581601659736518296L;
    private String msg;

    public EccezionePrecondizioni(String msg) {
        this.msg = msg;
    }

    public EccezionePrecondizioni(){
        super("Errore precondizioni");
    }

    @Override
    public String toString() {
        return this.msg;
    }

}
