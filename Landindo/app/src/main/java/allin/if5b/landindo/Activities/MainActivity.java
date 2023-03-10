package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import allin.if5b.landindo.Adapter.AdapterPost;
import allin.if5b.landindo.R;
import allin.if5b.landindo.Service.APIService;
import allin.if5b.landindo.Service.Utilities;
import allin.if5b.landindo.databinding.ActivityMainBinding;
import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<SlideModel> imageslide = new ArrayList<>();
    private ActivityMainBinding binding;
    private static final String TAG = "destiasi";
    private AdapterPost adapterPost;
    private List<Destinasi> sumatera = new ArrayList<>();
    private List<Destinasi> jawa = new ArrayList<>();
    private List<Destinasi> kalimantan = new ArrayList<>();
    private List<Destinasi> sulawesi = new ArrayList<>();
    private List<Destinasi> papua = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageslide.add(new SlideModel(R.drawable.jam_gadang,  ScaleTypes.CENTER_CROP));
        imageslide.add(new SlideModel(R.drawable.jembatan_amanat_penderitaan_rakyat,  ScaleTypes.CENTER_CROP));
        imageslide.add(new SlideModel(R.drawable.monumen_nasional,  ScaleTypes.CENTER_CROP));
        imageslide.add(new SlideModel(R.drawable.menara_siger,  ScaleTypes.CENTER_CROP));
        imageslide.add(new SlideModel(R.drawable.monumen_kapsul_waktu,  ScaleTypes.CENTER_CROP));
        imageslide.add(new SlideModel(R.drawable.candi_borobudur,  ScaleTypes.CENTER_CROP));

        binding.carousel.setImageList(imageslide);

        getSumatera();
        getjawa();
        getKalimantan();
        getSulawesi();
        getPapua();

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

        binding.btnAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AkunActivity.class));
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

    private void getSumatera(){
        APIService.endpoint().getPulau("sumatera").enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    sumatera = response.body();
                    loadAdapterSumatera(sumatera);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void getjawa(){
        APIService.endpoint().getPulau("Jawa").enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    jawa = response.body();
                    loadAdapterJawa(jawa);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void getKalimantan(){
        APIService.endpoint().getPulau("kalimantan").enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    kalimantan = response.body();
                    loadAdapterKalimantan(kalimantan);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void getSulawesi(){
        APIService.endpoint().getPulau("sulawesi").enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    sulawesi = response.body();
                    loadAdapterSulawesi(sulawesi);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void getPapua(){
        APIService.endpoint().getPulau("papua").enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    papua = response.body();
                    loadAdapterPapua(papua);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void loadAdapterPapua(List<Destinasi> papua) {
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostPapua.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostPapua.setAdapter(adapterPost);
        adapterPost.setResultData(papua);
        adapterPost.setOnClickListener(new AdapterPost.OnClickListener() {
            @Override
            public void onDetail(Destinasi result) {
                goDetail(result);
            }
        });
    }

    private void loadAdapterSulawesi(List<Destinasi> sulawesi) {
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostSulawesi.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostSulawesi.setAdapter(adapterPost);
        adapterPost.setResultData(sulawesi);
        adapterPost.setOnClickListener(new AdapterPost.OnClickListener() {
            @Override
            public void onDetail(Destinasi result) {
                goDetail(result);
            }
        });
    }

    private void loadAdapterKalimantan(List<Destinasi> kalimantan) {
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostKalimantan.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostKalimantan.setAdapter(adapterPost);
        adapterPost.setResultData(kalimantan);
        adapterPost.setOnClickListener(new AdapterPost.OnClickListener() {
            @Override
            public void onDetail(Destinasi result) {
                goDetail(result);
            }
        });
    }

    private void loadAdapterJawa(List<Destinasi> jawa) {
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostJawa.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostJawa.setAdapter(adapterPost);
        adapterPost.setResultData(jawa);
        adapterPost.setOnClickListener(new AdapterPost.OnClickListener() {
            @Override
            public void onDetail(Destinasi result) {
                goDetail(result);
            }
        });
    }

    private void loadAdapterSumatera(List<Destinasi> sumatera) {
        adapterPost = new AdapterPost(MainActivity.this);
        binding.rvPostSumatera.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPostSumatera.setAdapter(adapterPost);
        adapterPost.setResultData(sumatera);
        adapterPost.setOnClickListener(new AdapterPost.OnClickListener() {
            @Override
            public void onDetail(Destinasi result) {
                goDetail(result);
            }
        });
    }

    private void goDetail(Destinasi destinasi) {
        Intent intent = new Intent(MainActivity.this, DeskripsiActivity.class);
        intent.putExtra("nama", destinasi.getNama());
        intent.putExtra("kota", destinasi.getKota());
        intent.putExtra("provinsi", destinasi.getProvinsi());
        intent.putExtra("gambar", destinasi.getGambar());
        intent.putExtra("deskripsi", destinasi.getDeskripsi());
        intent.putExtra("pulau", destinasi.getPulau());
    }


//        List<Data> list = new ArrayList<>();
//        for (Data data: listAPI){
//            if(data.getPulau().equals("sumatera")){
//                list.add(data);
//            }
//        }
}