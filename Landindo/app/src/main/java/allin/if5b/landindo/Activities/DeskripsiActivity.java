package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import allin.if5b.landindo.R;
import allin.if5b.landindo.databinding.ActivityDeskripsiBinding;
import allin.if5b.landindo.models.Destinasi;

public class DeskripsiActivity extends AppCompatActivity {
    private ActivityDeskripsiBinding binding;
    String TAG = "landindo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeskripsiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Destinasi destinasi = getIntent().getParcelableExtra("destinasi");


        binding.tvJudul.setText(destinasi.getNama());
        binding.tvKota.setText(destinasi.getKota() + ", ");
        binding.tvProvinsi.setText(destinasi.getProvinsi());
        binding.tvDeskripsi.setText(destinasi.getDeskripsi());

        Glide.with(this)
                .load(destinasi.getGambar())
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivGambar);
    }

}