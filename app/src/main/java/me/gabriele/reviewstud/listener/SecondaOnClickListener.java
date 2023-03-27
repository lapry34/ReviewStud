package me.gabriele.reviewstud.listener;

import android.content.Intent;
import android.view.View;

import me.gabriele.reviewstud.Seconda;
import me.gabriele.reviewstud.Terza;

public class SecondaOnClickListener implements View.OnClickListener {

    private final Seconda seconda;

    public SecondaOnClickListener(Seconda seconda) {
        super();
        this.seconda = seconda;
    }

    @Override
    public void onClick(View view) {
        int ButtonID = view.getId();
        Intent intent = null;
        switch(ButtonID){
            default:
                intent = new Intent(seconda, Terza.class);
                break;
        }
        seconda.startActivity(intent);
        return;
    }
}
