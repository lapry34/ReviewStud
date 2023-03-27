package me.gabriele.reviewstud.listener;

import android.content.Intent;
import android.view.View;

import me.gabriele.reviewstud.Prima;
import me.gabriele.reviewstud.R;
import me.gabriele.reviewstud.Seconda;
import me.gabriele.reviewstud.Terza;

public class PrimaOnClickListener implements View.OnClickListener {

    private final Prima prima;

    public PrimaOnClickListener(Prima prima) {
        super();
        this.prima = prima;
    }

    @Override
    public void onClick(View view) {
        int ButtonID = view.getId();
        Intent intent = null;
        switch(ButtonID){
            case R.id.connetti:
                intent = new Intent(prima, Seconda.class);
                break;
            case R.id.iscriviti:
                intent = new Intent(prima, Terza.class);
                break;
        }
        prima.startActivity(intent);
        return;
    }
}
