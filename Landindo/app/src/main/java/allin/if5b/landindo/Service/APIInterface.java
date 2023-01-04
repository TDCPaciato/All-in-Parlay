package allin.if5b.landindo.Service;

import java.util.ArrayList;

import allin.if5b.landindo.models.Destinasi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    //End Point Laptop
    @GET("destinasi")
    Call<ArrayList<Destinasi>> getDestinasi();

}
