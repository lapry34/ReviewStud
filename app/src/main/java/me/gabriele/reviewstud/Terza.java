package me.gabriele.reviewstud;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import me.gabriele.reviewstud.databinding.ActivityTerzaBinding;

public class Terza extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTerzaBinding binding;
    EditText password;
    EditText confermaPassword;
    EditText nome;
    EditText cognome;
    EditText matricola;
    Button avanti;
    boolean passwordVisibile;
    boolean confermaVisibile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTerzaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        nome=findViewById(R.id.editTextTextPersonName);
        cognome=findViewById(R.id.CognomeEditText);
        matricola=findViewById(R.id.editTextTextPersonName2);
        password=findViewById(R.id.editTextTextPassword);
        confermaPassword=findViewById(R.id.ConfPasswordEditText);
        avanti = (Button) findViewById(R.id.avanti3);
        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(confermaPassword.getText().toString()) && !(nome.getText().toString().matches("")) && !(cognome.getText().toString().matches("")) && !(matricola.getText().toString().matches(""))){
                Intent intent= new Intent(Terza.this, Quarta.class);
                startActivity(intent);
                }else if(!(password.getText().toString().equals(confermaPassword.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Password non uguali PORCA MADONNA!",Toast.LENGTH_LONG).show();
                } else if (nome.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"NON HAI MESSO IL NOME COJONE",Toast.LENGTH_LONG).show();
                }else if (cognome.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"NON HAI MESSO IL COGNOME COJONE",Toast.LENGTH_LONG).show();
                }else if (matricola.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"AO LA MATRICOLA TESTA DI CAZZO",Toast.LENGTH_LONG).show();
                } else if (password.getText().toString().matches("")||confermaPassword.getText().toString().matches("")) {
                   Toast.makeText(getApplicationContext(),"LE PASSWORD BABBO DI MINCHIA",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "COMPLIMENTI SEI RITARDATO E NON HAI COMPILATO NIENTE", Toast.LENGTH_LONG).show();
                }
            }
        });

        password.setOnTouchListener(new View.OnTouchListener() {
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
        });
        confermaPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int right=2;
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
                return false;
            }

        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_prima);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}