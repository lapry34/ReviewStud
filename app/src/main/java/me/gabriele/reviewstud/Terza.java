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
import me.gabriele.reviewstud.listener.TerzaOnClickListener;
import me.gabriele.reviewstud.listener.TerzaOnTouchListener;

public class Terza extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTerzaBinding binding;
    /**
     *
     */
    private EditText password;
    private EditText confermaPassword;
    private EditText nome;
    private EditText cognome;
    private EditText matricola;
    private Button avanti;
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

        TerzaOnClickListener clickListener = new TerzaOnClickListener(this);
        avanti.setOnClickListener(clickListener);

        TerzaOnTouchListener touchListener = new TerzaOnTouchListener(this);
        password.setOnTouchListener(touchListener);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_prima);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public EditText getPassword() {
        return password;
    }

    public EditText getConfermaPassword() {
        return confermaPassword;
    }

    public EditText getNome() {
        return nome;
    }

    public EditText getCognome() {
        return cognome;
    }

    public EditText getMatricola() {
        return matricola;
    }
}