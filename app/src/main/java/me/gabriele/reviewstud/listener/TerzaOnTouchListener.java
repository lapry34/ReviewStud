package me.gabriele.reviewstud.listener;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import me.gabriele.reviewstud.R;
import me.gabriele.reviewstud.Terza;

public class TerzaOnTouchListener implements View.OnTouchListener {

private final Terza terza;
private final EditText password;
private final EditText confermaPassword;

private boolean passwordVisibile = false;
private boolean confermaVisibile = false;


public TerzaOnTouchListener(Terza terza){
        super();
        this.terza=terza;
        password=terza.findViewById(R.id.editTextTextPassword);
        confermaPassword=terza.findViewById(R.id.ConfPasswordEditText);
        }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int textID = view.getId();
        final int right = 2;
        switch(textID) {
            case R.id.editTextTextPassword:
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= password.getRight() - password.getCompoundDrawables()[right].getBounds().width()) {
                        int selection = password.getSelectionEnd();
                        int sel = password.getSelectionStart();
                        if (passwordVisibile) {
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_off_24, 0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisibile = false;
                        } else {
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
                break;
            case R.id.ConfPasswordEditText:
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=confermaPassword.getRight()-confermaPassword.getCompoundDrawables()[right].getBounds().width()){
                        int selection=confermaPassword.getSelectionEnd();
                        int sel=confermaPassword.getSelectionStart();
                        if(confermaVisibile){
                            //set drawable image here
                            confermaPassword.setCompoundDrawablesRelativeWithIntrinsicBounds( R.drawable.baseline_lock_24,0,R.drawable.baseline_visibility_off_24,0);
                            //for hide password
                            confermaPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            confermaVisibile=false;
                        }else {
                            confermaPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_24, 0);
                            //for show password
                            confermaPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            confermaVisibile = true;
                        }
                        confermaPassword.setSelection(selection);
                        confermaPassword.setSelection(sel);
                        return true;
                    }
                }
                break;


        }
    return false;
    }
}