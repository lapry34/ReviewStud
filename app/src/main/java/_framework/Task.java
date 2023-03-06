package _framework;

public interface Task extends Runnable {

    //tutto deve essere synchronized

    //ritorna boolean eseguita
    public boolean estEseguita();

    @Override
    public void run();

    //si ritornano i risultati nel seguente modo

    /*
     * public synchronized TIPO getRIS(){
     * 		if(!eseguita) throw new RuntimeException("non eseguita");
     * 		return RIS;
     * }
     */

}
