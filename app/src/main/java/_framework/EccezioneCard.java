package _framework;

public  class EccezioneCard extends Exception {

    private static final long serialVersionUID = 1L;
    private String msg;

    public EccezioneCard(String msg) {
        this.msg = msg;
    }

    public EccezioneCard(){
        super("Errore cardinalità");
    }

    @Override
    public String toString() {
        return this.msg;
    }

}
