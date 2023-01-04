package allin.if5b.landindo.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    private static String BASE_URL = "https://apipcpart.000webhostapp.com/api/";
    private static Retrofit retrofit;

    public static APIInterface endpoint() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIInterface.class);
    }
}
