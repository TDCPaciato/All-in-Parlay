package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import allin.if5b.landindo.databinding.ActivityDeskripsiBinding;

public class DeskripsiActivity extends AppCompatActivity {
    private ActivityDeskripsiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeskripsiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}