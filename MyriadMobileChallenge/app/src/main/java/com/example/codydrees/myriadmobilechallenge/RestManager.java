package com.example.codydrees.myriadmobilechallenge;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Cody Drees on 3/12/2016.
 */
public class RestManager {


    private KingdomService mKingdomService;

    public KingdomService getKingdomService(){
        if(mKingdomService == null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.HTTP.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            mKingdomService = retrofit.create(KingdomService.class);
        }

        return mKingdomService;
    }
}
