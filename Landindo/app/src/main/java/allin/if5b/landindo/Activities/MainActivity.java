package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import allin.if5b.landindo.R;
import allin.if5b.landindo.Service.Utilities;
import allin.if5b.landindo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(!Utilities.cekValue(MainActivity.this, "xEmail")){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        binding.btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        binding.civSumatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaPulau = "Sumatera";
                Intent intent = new Intent(MainActivity.this,PulauActivity.class);

                intent.putExtra("Nama Pulau", namaPulau);
                startActivity(intent);
            }
        });
        binding.civJawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaPulau = "Jawa";
                Intent intent = new Intent(MainActivity.this,PulauActivity.class);

                intent.putExtra("Nama Pulau", namaPulau);
                startActivity(intent);
            }
        });
        binding.civKalimantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaPulau = "Kalimantan";
                Intent intent = new Intent(MainActivity.this,PulauActivity.class);

                intent.putExtra("Nama Pulau", namaPulau);
                startActivity(intent);
            }
        });
        binding.civSulawesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaPulau = "Sulawesi";
                Intent intent = new Intent(MainActivity.this,PulauActivity.class);

                intent.putExtra("Nama Pulau", namaPulau);
                startActivity(intent);
            }
        });
        binding.civPapua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaPulau = "Papua";
                Intent intent = new Intent(MainActivity.this,PulauActivity.class);

                intent.putExtra("Nama Pulau", namaPulau);
                startActivity(intent);
            }
        });
    }
}