package allinparlay.if5b.landmarkindonesia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import allinparlay.if5b.landmarkindonesia.databinding.ActivityAkunBinding;

public class AkunActivity extends AppCompatActivity {
    private ActivityAkunBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAkunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}