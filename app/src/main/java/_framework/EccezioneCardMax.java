package _framework;

public  class EccezioneCardMax extends EccezioneCard {

    private static final long serialVersionUID = 1L;
    private String msg;

    public EccezioneCardMax(String msg) {
        super(msg);
    }

    public EccezioneCardMax(){
        super("Errore cardinalità massima");
    }

    @Override
    public String toString() {
        return this.msg;
    }

}
