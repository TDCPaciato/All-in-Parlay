package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import allin.if5b.landindo.Service.APIService;
import allin.if5b.landindo.databinding.ActivityPulauBinding;
import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PulauActivity extends AppCompatActivity {
    private ActivityPulauBinding binding;
    public static final String TAG = "AllInParlay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPulauBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String namaPulau = getIntent().getExtras().getString("Nama Pulau");
        getDestiansi();
    }

    private void getDestiansi() {
        APIService.endpoint().getDestinasi().enqueue(new Callback<ArrayList<Destinasi>>() {
            @Override
            public void onResponse(Call<ArrayList<Destinasi>> call, Response<ArrayList<Destinasi>> response) {
                String nama = response.body().get(0).getNama();
                Log.d(TAG, "Nama Destinasi : " + nama);
            }

            @Override
            public void onFailure(Call<ArrayList<Destinasi>> call, Throwable t) {

            }
        });
    }
}