package allinparlay.if5b.landmarkindonesia.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import allinparlay.if5b.landmarkindonesia.R;
import allinparlay.if5b.landmarkindonesia.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.navHome:
                    replaceFragment(new HomeActivity());
                    break;
                case R.id.navSearch:
                    break;
                case R.id.navAkun:
                    break;
            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();


    }
}