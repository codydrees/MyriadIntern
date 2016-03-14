package com.example.codydrees.myriadmobilechallenge;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Cody Drees on 3/12/2016.
 */
public interface KingdomService {
    @GET("/api/v1/kingdoms/")
    Call<List<Kingdom>> getAllKingdoms();



}
