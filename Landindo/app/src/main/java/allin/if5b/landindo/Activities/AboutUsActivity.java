package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import allin.if5b.landindo.R;

public class AboutUsActivity extends AppCompatActivity {

    TextView tv_rizky, tv_stephen, tv_lipi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        tv_rizky = findViewById(R.id.tv_rizky);
        tv_stephen = findViewById(R.id.tv_stephen);
        tv_lipi = findViewById(R.id.tv_lipi);

        tv_rizky.setOnClickListener(new View.OnClickListener() {
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

        tv_stephen.setOnClickListener(new View.OnClickListener() {
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

        tv_lipi.setOnClickListener(new View.OnClickListener() {
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