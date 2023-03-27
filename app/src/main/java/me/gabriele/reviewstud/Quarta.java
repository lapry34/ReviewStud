package me.gabriele.reviewstud;

import android.content.Intent;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.textfield.TextInputLayout;

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

            RadioGroup rg= findViewById(R.id.radioGroup);
            TextView tc1= findViewById(R.id.corsolaurea);
            TextView tc2= findViewById(R.id.corsolaurea2);
            CheckBox c=findViewById(R.id.accetta_termini);
            Button m=findViewById(R.id.manda_email);
            AutoCompleteTextView a1=findViewById(R.id.menu_text1);
            AutoCompleteTextView a2=findViewById(R.id.menu_text2);
            TextInputLayout til1= findViewById(R.id.TendinaCorso1);
            TextInputLayout til2= findViewById(R.id.TendinaCorso2);

            tc1.setVisibility(View.INVISIBLE);
            tc2.setVisibility(View.INVISIBLE);
            a1.setVisibility(View.INVISIBLE);
            a2.setVisibility(View.INVISIBLE);
            c.setVisibility(View.INVISIBLE);
            m.setVisibility(View.INVISIBLE);
            til1.setVisibility(View.INVISIBLE);
            til2.setVisibility(View.INVISIBLE);

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                    boolean isChecked = checkedRadioButton.isChecked();
                    if(checkedId == R.id.radio_si) {
                        if (isChecked) {
                            tc1.setVisibility(View.VISIBLE);
                            //  mc1.setVisibility(View.VISIBLE);
                            tc2.setVisibility(View.VISIBLE);
                            //  mc2.setVisibility(View.VISIBLE);
                            a1.setVisibility(View.VISIBLE);
                            a2.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            m.setVisibility(View.VISIBLE);
                            til1.setVisibility(View.VISIBLE);
                            til2.setVisibility(View.VISIBLE);
                        }
                    }
                    else if(checkedId == R.id.radio_no){
                        if (isChecked) {
                            tc1.setVisibility(View.VISIBLE);
                            //   mc1.setVisibility(View.VISIBLE);
                            a1.setVisibility(View.VISIBLE);
                            c.setVisibility(View.VISIBLE);
                            m.setVisibility(View.VISIBLE);
                            til1.setVisibility(View.VISIBLE);
                            til2.setVisibility(View.INVISIBLE);
                            a2.setVisibility(View.INVISIBLE);
                            tc2.setVisibility(View.INVISIBLE);
                            }
                        }
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

