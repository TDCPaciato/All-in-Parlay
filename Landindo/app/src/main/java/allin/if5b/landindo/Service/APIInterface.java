package allin.if5b.landindo.Service;

import java.util.ArrayList;

import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {


    @GET("destinasi")
    Call<ArrayList<Destinasi>> getDestinasi();

    @GET("destinasi")
    Call<ArrayList<Destinasi>> getPulau(@Query("pulau") String pulau);

}
