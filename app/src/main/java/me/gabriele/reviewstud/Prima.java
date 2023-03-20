package me.gabriele.reviewstud;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import me.gabriele.reviewstud.databinding.ActivityPrimaBinding;

public class Prima extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPrimaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrimaBinding.inflate(getLayoutInflater());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(binding.getRoot());

       Button connetti=(Button) findViewById(R.id.connetti);
       Button iscriviti=(Button) findViewById(R.id.iscriviti);

       connetti.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                Intent intent= new Intent(Prima.this, Seconda.class);
                 startActivity(intent);
             }
         });





    iscriviti.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent= new Intent(Prima.this, Terza.class);
            startActivity(intent);
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