package me.gabriele.reviewstud.listener;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import me.gabriele.reviewstud.Prima;
import me.gabriele.reviewstud.Quarta;
import me.gabriele.reviewstud.R;
import me.gabriele.reviewstud.Seconda;
import me.gabriele.reviewstud.Terza;

public class TerzaOnClickListener implements View.OnClickListener {

    private final Terza terza;

    public TerzaOnClickListener(Terza terza) {
        super();
        this.terza = terza;
    }

    @Override
    public void onClick(View view) {
        int ButtonID = view.getId();
        Intent intent = null;
        switch(ButtonID){
            case R.id.avanti3:
                if(terza.getNome().getText().toString().matches("")){
                    Toast.makeText(terza.getApplicationContext(),"Nome Assente!",Toast.LENGTH_LONG).show();
                } else if (terza.getCognome().getText().toString().matches("")) {
                    Toast.makeText(terza.getApplicationContext(),"Cognome Assente!",Toast.LENGTH_LONG).show();
                } else if (terza.getMatricola().getText().toString().matches("")) {
                    Toast.makeText(terza.getApplicationContext(),"Matricola Assente!",Toast.LENGTH_LONG).show();
                } else if (terza.getPassword().getText().toString().matches("")) {
                    Toast.makeText(terza.getApplicationContext(),"Password Assente!",Toast.LENGTH_LONG).show();
                } else if (!(terza.getPassword().getText().toString().equals(terza.getConfermaPassword().getText().toString()))) {
                    Toast.makeText(terza.getApplicationContext(),"Password non uguali!",Toast.LENGTH_LONG).show();
                } else if(terza.getPassword().getText().toString().equals(terza.getConfermaPassword().getText().toString()) && !(terza.getNome().getText().toString().matches("")) && !(terza.getCognome().getText().toString().matches("")) && !(terza.getMatricola().getText().toString().matches(""))){
                    intent= new Intent(terza, Quarta.class);
                    terza.startActivity(intent);
                } else{
                    Toast.makeText(terza.getApplicationContext(),"Errore generico contolla i campi dati",Toast.LENGTH_LONG).show();
                }
                break;
        }
        return;
    }
}
