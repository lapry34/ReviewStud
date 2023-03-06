package _framework;

public  class EccezioneCardMin extends EccezioneCard {

    private static final long serialVersionUID = 1L;
    private String msg;

    public EccezioneCardMin(String msg) {
        super(msg);
    }

    public EccezioneCardMin(){
        super("Errore cardinalità minima");
    }

    @Override
    public String toString() {
        return this.msg;
    }

}
