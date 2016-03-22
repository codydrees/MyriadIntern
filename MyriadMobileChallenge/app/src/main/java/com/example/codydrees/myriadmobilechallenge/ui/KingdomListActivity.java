package com.example.codydrees.myriadmobilechallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.codydrees.myriadmobilechallenge.Constants;
import com.example.codydrees.myriadmobilechallenge.Kingdom;
import com.example.codydrees.myriadmobilechallenge.KingdomAdapter;
import com.example.codydrees.myriadmobilechallenge.R;
import com.example.codydrees.myriadmobilechallenge.RestManager;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
/**
 * Created by Cody Drees on 3/13/2016.
 */
public class KingdomListActivity extends AppCompatActivity implements KingdomAdapter.KingdomClickListener{

    private RestManager mManager;
    private RecyclerView mRecyclerView;
    private KingdomAdapter mKingdomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mManager = new RestManager();
        Call<List<Kingdom>> listCall = mManager.getKingdomService().getAllKingdoms();
        listCall.enqueue(new Callback<List<Kingdom>>() {
            @Override
            public void onResponse(Response<List<Kingdom>> response, Retrofit retrofit) {

                if(response.isSuccess()){
                    List<Kingdom> kingdomList = response.body();

                    for(int i = 0; i< kingdomList.size(); i++){
                        Kingdom kingdom = kingdomList.get(i);
                        mKingdomAdapter.addKingdom(kingdom);
                    }
                }
                else{
                    int sc = response.code();
                    switch (sc){

                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void configViews(){
        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mKingdomAdapter = new KingdomAdapter(this);
        mRecyclerView.setAdapter(mKingdomAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onClick(int position){
        Kingdom selectedKingdom = mKingdomAdapter.getSelectedKingdom(position);
        Intent intent = new Intent(KingdomListActivity.this, KingdomActivity.class);
        intent.putExtra(Constants.REFERENCE.KINGDOM, selectedKingdom);
        startActivity(intent);
    }

}