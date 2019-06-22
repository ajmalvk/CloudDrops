package com.progdest.meftpay;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.progdest.meftpay.Utility.Api;
import com.progdest.meftpay.Utility.AppConfigData;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends Activity  {
    ProgressDialog progress;
    EditText ET_phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ET_phone_number=findViewById(R.id.ET_phone_number);
        Button BT_submit_login = findViewById(R.id.BT_submit_login);
        progress = new ProgressDialog(this);
        BT_submit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoginActivity.this,OtpActivity.class));
                Boolean form_valid=true;
                if(ET_phone_number.getText().toString().equals("")){
                        form_valid=false;
                        Toast.makeText(getApplicationContext(),"Fill Phone Number",Toast.LENGTH_LONG).show();
                    }
                if(form_valid){
                        login_check_phone(ET_phone_number.getText().toString());
                    }

            }
        });

    }

    ///login check phone
    public void login_check_phone(String phone_number){
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        String second_tokken="L!gMS5UP`eFD73P,s2r.5m7vL'#6+Ue89.yKjQu#gcC%+&T#6-";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfigData.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call = api.loginUserCheckPhone(phone_number);
        ////
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progress.dismiss();
                JsonObject object=response.body();
                String jstr=object.toString();
                Log.d("alldata",jstr.toString());
                JSONObject obj=null;
                try {
                    obj=new JSONObject(jstr);
                    int status=obj.getInt("status");
                    if(status==1) {
                        ///login
                        JSONObject user=obj.getJSONObject("user");
                        Intent login_register = new Intent(LoginActivity.this, OtpActivity.class);
                        login_register.putExtra("reg_type",obj.getString("register_status"));
                        login_register.putExtra("user_id",obj.getString("user_id"));
                        login_register.putExtra("user_name",user.getString("name"));
                        login_register.putExtra("user_phone",user.getString("phone"));
                        startActivity(login_register);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progress.dismiss();
                Log.d("test",t.getMessage());
            }
        });
        ////
    }


}