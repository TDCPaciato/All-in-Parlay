package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import allin.if5b.landindo.Adapter.AdapterPost;
import allin.if5b.landindo.Service.APIService;
import allin.if5b.landindo.databinding.ActivityPulauBinding;
import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PulauActivity extends AppCompatActivity {
    private ActivityPulauBinding binding;
    private AdapterPost adapterPost;
    public static final String TAG = "AllInParlay";
    String namaPulau;
    private List<Destinasi> destinasiResult = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPulauBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        namaPulau = getIntent().getExtras().getString("Nama Pulau");
        binding.title.setText(namaPulau);
        getDestiansi();

        binding.backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void getDestiansi() {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService.endpoint().getPulau(namaPulau).enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                if (response.code() == 200) {
                    destinasiResult = response.body();
                    LoadAdapter(destinasiResult);
                    binding.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }

    private void LoadAdapter(List<Destinasi> destinasiResult){
        adapterPost = new AdapterPost(PulauActivity.this);
        binding.rvPost.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPost.setAdapter(adapterPost);
        adapterPost.setResultData(destinasiResult);
    }
}