package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import allin.if5b.landindo.R;
import allin.if5b.landindo.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.tvRizky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Intent.ACTION_SENDTO);
                send.putExtra(Intent.EXTRA_EMAIL, "rizky.kurniawan@mhs.mdp.ac.id");
                send.setData(Uri.parse("mailto:"));
                send.setPackage("com.google.android.gm");
                startActivity(send);
                finish();
            }
        });

        binding.tvStephen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Intent.ACTION_SENDTO);
                send.putExtra(Intent.EXTRA_EMAIL, "stephens12@mhs.mdp.ac.id");
                send.setData(Uri.parse("mailto:"));
                send.setPackage("com.google.android.gm");
                startActivity(send);
                finish();
            }
        });

        binding.tvLipi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Intent.ACTION_SENDTO);
                send.putExtra(Intent.EXTRA_EMAIL, "lipiamanda23@mhs.mdp.ac.id");
                send.setData(Uri.parse("mailto:"));
                send.setPackage("com.google.android.gm");
                startActivity(send);
                finish();
            }
        });
    }
}