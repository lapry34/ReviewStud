package me.gabriele.reviewstud;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import me.gabriele.reviewstud.databinding.ActivityQuartaBinding;
import me.gabriele.reviewstud.databinding.ActivityTerzaBinding;

public class Quarta extends AppCompatActivity {

        private AppBarConfiguration appBarConfiguration;
        private ActivityQuartaBinding binding;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityQuartaBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

        }

        @Override
        public boolean onSupportNavigateUp() {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_prima);
            return NavigationUI.navigateUp(navController, appBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    }

