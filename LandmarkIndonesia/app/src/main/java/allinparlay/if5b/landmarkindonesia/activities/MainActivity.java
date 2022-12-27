package allinparlay.if5b.landmarkindonesia.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import allinparlay.if5b.landmarkindonesia.R;
import allinparlay.if5b.landmarkindonesia.databinding.ActivityMainBinding;
import allinparlay.if5b.landmarkindonesia.fragment.HomeFragment;
import allinparlay.if5b.landmarkindonesia.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, homeFragment).commit();
        binding.navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navHome:getSupportFragmentManager().beginTransaction().replace(R.id.fl_home,homeFragment).commit();
                    return true;
                    case R.id.navSearch:getSupportFragmentManager().beginTransaction().replace(R.id.fl_home,searchFragment).commit();
                        return true;
                    case R.id.navAkun:startActivity(new Intent(getApplicationContext(), AkunActivity.class));
                        return true;
                }
                return false;
            }
        });
    }
}
