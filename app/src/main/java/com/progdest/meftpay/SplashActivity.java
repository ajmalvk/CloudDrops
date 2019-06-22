package com.progdest.meftpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.progdest.meftpay.Utility.Api;
import com.progdest.meftpay.Utility.AppConfigData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends Activity  {


    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread background = new Thread() {
            public void run() {

                try {
                    sleep(1*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(getBaseContext().getSharedPreferences("MyPreferences",Context.MODE_PRIVATE).getString("is_first_time","default").equals("default")){
                        Intent login_register = new Intent(SplashActivity.this, OnBoardingOne.class);
                        startActivity(login_register);
                        finish();
                    }
                else{
                        String tokken=getBaseContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE).getString("access_token","default_tokken");
                        if(tokken.equals("default_tokken")){
                            Intent login_register = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(login_register);
                            finish();
                        }
                        else{
                            check_login(tokken);
                        }
                    }


                   /* SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                    if (prefs.getString("is_first_time", "Default").equals("Default")){

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("is_first_time","No");
                        editor.apply();
                        editor.commit();
                        i =new Intent(getBaseContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }else {
                        if(new Preferences().readLoginStatus(getApplicationContext()).equals("logged_in"))
                        {
                            Intent home_activity = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(home_activity);
                            finish();
                        }
                        else {
                            Intent login_register = new Intent(SplashActivity.this, RegisterAndLoginActivity.class);
                            startActivity(login_register);
                            finish();
                        }
                    }*/


            }
        };
        background.start();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    ///check login
    public void check_login(final String tokken){
        Log.d("tokken",tokken);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfigData.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call = api.checkLogin(tokken);
        ////
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject object=response.body();
                String jstr=object.toString();
                Log.d("alldata",jstr.toString());
                JSONObject obj=null;
                try {
                    obj=new JSONObject(jstr);
                    int status=obj.getInt("status");
                    if(status==1) {
                        AppConfigData.userTokken=tokken;
                        Intent home = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(home);
                        finish();
                    }
                    else{
                        Intent login_register = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(login_register);
                        finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("test",t.getMessage());
            }
        });
        ////
    }
}