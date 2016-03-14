package com.example.codydrees.myriadmobilechallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codydrees.myriadmobilechallenge.Constants;
import com.example.codydrees.myriadmobilechallenge.Kingdom;
import com.example.codydrees.myriadmobilechallenge.KingdomAdapter;
import com.example.codydrees.myriadmobilechallenge.R;
import com.example.codydrees.myriadmobilechallenge.RestManager;
import com.example.codydrees.myriadmobilechallenge.User;
import com.example.codydrees.myriadmobilechallenge.UserLocalStore;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bSubmit;
    EditText etName,etEmail;
    String strEmailAddress;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        bSubmit = (Button) findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }
   String regEx=  "[0-9A-Za-z._-]+@[a-z]+\\.+[a-z]+";
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bSubmit:

                strEmailAddress = etEmail.getText().toString().trim();

                Matcher matcherObj = Pattern.compile(regEx).matcher(strEmailAddress);

                if (matcherObj.matches()) {
                    startActivity(new Intent(this, SignUpActivity.class));
                    String name = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    User user = new User(null,null);
                    userLocalStore.storeUserData(user);
                    userLocalStore.setUserLoggedIn(true);


                } else {
                    Toast.makeText(v.getContext(), strEmailAddress+" Email Address is invalid", Toast.LENGTH_SHORT).show();
                }
                break;
        }


        }
    }


