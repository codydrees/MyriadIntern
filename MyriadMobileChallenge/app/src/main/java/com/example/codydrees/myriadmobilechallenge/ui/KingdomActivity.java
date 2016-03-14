package com.example.codydrees.myriadmobilechallenge.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.codydrees.myriadmobilechallenge.Constants;
import com.example.codydrees.myriadmobilechallenge.Kingdom;
import com.example.codydrees.myriadmobilechallenge.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Cody Drees on 3/12/2016.
 */
public class KingdomActivity extends AppCompatActivity {
    private ImageView mImage;
    private TextView mName, mID, mDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.kingdom_activity);
        Intent intent = getIntent();

        Kingdom kingdom = (Kingdom) intent.getSerializableExtra(Constants.REFERENCE.KINGDOM);

        configView();

        mID.setText(kingdom.getId());
        mName.setText(kingdom.getName());
        mDescription.setText(kingdom.getDescription());



        Picasso.with(getApplicationContext()).load(kingdom.getImage()).into(mImage);
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
    private void configView() {
        mImage = (ImageView) findViewById(R.id.kingdomImage);
        mID = (TextView) findViewById(R.id.kingID);
        mName = (TextView) findViewById(R.id.kingName);
        mDescription = (TextView) findViewById(R.id.kingDescription);




    }
}

