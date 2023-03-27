package me.gabriele.reviewstud.listener;

import android.content.Intent;
import android.view.View;

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
                intent = new Intent(terza, Quarta.class);
                break;
        }
        terza.startActivity(intent);
        return;
    }
}
