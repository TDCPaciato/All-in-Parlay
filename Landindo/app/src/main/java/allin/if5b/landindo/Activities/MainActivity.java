package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import allin.if5b.landindo.Adapter.AdapterPost;
import allin.if5b.landindo.Service.APIService;
import allin.if5b.landindo.Service.Utilities;
import allin.if5b.landindo.databinding.ActivityMainBinding;
import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String TAG = "destiasi";
    private AdapterPost adapterPost;
    private List<Destinasi> destinasiResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();

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

    private void getData(){
        APIService.endpoint().getDestinasi()
                .enqueue(new Callback<ArrayList<Destinasi>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                        String nama = response.body().get(0).getNama();
                        Log.d(TAG, "Nama Destinasi" + nama);
                        LoadAdapter(response.body());

                        
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

                    }
                });
    }

    private void LoadAdapter(List<Destinasi> destinasiResult){
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostSumatera.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostJawa.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostKalimantan.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostSulawesi.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostPapua.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPost.setResultData(destinasiResult);
        binding.rvPostSumatera.setAdapter(adapterPost);
        binding.rvPostJawa.setAdapter(adapterPost);
        binding.rvPostKalimantan.setAdapter(adapterPost);
        binding.rvPostSulawesi.setAdapter(adapterPost);
        binding.rvPostPapua.setAdapter(adapterPost);
    }
}