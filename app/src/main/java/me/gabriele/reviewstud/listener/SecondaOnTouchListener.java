package me.gabriele.reviewstud.listener;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import me.gabriele.reviewstud.R;
import me.gabriele.reviewstud.Seconda;

public class SecondaOnTouchListener implements View.OnTouchListener {

    private final Seconda seconda;
    private final EditText password;
    boolean passwordVisibile;
    public SecondaOnTouchListener(Seconda seconda) {
        super();
        this.seconda = seconda;
        password = seconda.findViewById(R.id.editTextTextPassword);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int right=2;
        if(motionEvent.getAction()==MotionEvent.ACTION_UP){
            if(motionEvent.getRawX()>=password.getRight()-password.getCompoundDrawables()[right].getBounds().width()){
                int selection=password.getSelectionEnd();
                int sel=password.getSelectionStart();
                if(passwordVisibile){
                    //set drawable image here
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds( R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_off_24,0);
                    //for hide password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordVisibile=false;
                }else {
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_24, 0);
                    //for show password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordVisibile = true;
                }
                password.setSelection(selection);
                password.setSelection(sel);
                return true;
            }
        }
        return false;
    }
}
