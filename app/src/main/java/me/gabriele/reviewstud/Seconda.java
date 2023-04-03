package me.gabriele.reviewstud;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import me.gabriele.reviewstud.databinding.ActivitySecondaBinding;
import me.gabriele.reviewstud.listener.SecondaOnClickListener;
import me.gabriele.reviewstud.listener.SecondaOnTouchListener;

public class Seconda extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySecondaBinding binding;
    EditText password;
    EditText matricola;
    Button connetti;
    boolean passwordVisibile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        password=findViewById(R.id.editTextTextPassword);
        matricola=findViewById(R.id.editTextTextPersonName);
        connetti=(Button) findViewById(R.id.connetti);

        SecondaOnClickListener clickListener = new SecondaOnClickListener(this);
        SecondaOnTouchListener touchListener = new SecondaOnTouchListener(this);

        password.setOnTouchListener(touchListener);
        connetti.setOnClickListener(clickListener);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_prima);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}