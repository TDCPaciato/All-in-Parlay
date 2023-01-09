package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import allin.if5b.landindo.R;
import allin.if5b.landindo.databinding.ActivityDeskripsiBinding;

public class DeskripsiActivity extends AppCompatActivity {
    private ActivityDeskripsiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeskripsiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String nama = getIntent().getStringExtra("nama");
        String kota = getIntent().getStringExtra("kota");
        String provinsi = getIntent().getStringExtra("provinsi");
        String gambar = getIntent().getStringExtra("gambar");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String pulau = getIntent().getStringExtra("pulau");

        binding.tvJudul.setText(nama);
        binding.tvKota.setText(kota);
        binding.tvProvinsi.setText(provinsi);
        binding.tvDeskripsi.setText(deskripsi);

        Glide.with(this)
                .load(gambar)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivGambar);
    }

}