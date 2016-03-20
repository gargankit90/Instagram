package com.ankitgarg.instagram.api;

import com.ankitgarg.instagram.model.Popular;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class InstagramApi {
    private static InstagramApiInterface instagramService;
    private static final String INSTAGRAM_API_URL= "https://api.instagram.com/v1/";
    private static final String INSTAGRAM_CLIENT_ID = "e05c462ebd86446ea48a5af73769b602";

    public static InstagramApiInterface getInstagramApiClient() {
        if (instagramService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(INSTAGRAM_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instagramService = retrofit.create(InstagramApiInterface.class);
        }
        return instagramService;
    }


    public interface InstagramApiInterface {
        @GET("media/popular?client_id="+INSTAGRAM_CLIENT_ID)
        Call<Popular> getPopularMedia();
    }
}
