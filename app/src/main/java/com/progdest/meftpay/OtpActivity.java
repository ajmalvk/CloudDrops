package com.progdest.meftpay;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.progdest.meftpay.Utility.Api;
import com.progdest.meftpay.Utility.AppConfig;
import com.progdest.meftpay.Utility.AppConfigData;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtpActivity extends Activity  {
    ProgressDialog progress;
    String user_id,user_name,user_phone,reg_type;
    Boolean register=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);
        user_id=getIntent().getExtras().getString("user_id","");
        user_name=getIntent().getExtras().getString("user_name","");
        user_phone=getIntent().getExtras().getString("user_phone","");
        reg_type=getIntent().getExtras().getString("reg_type","");
        Button BT_submit_otp = findViewById(R.id.BT_submit_otp);
        final EditText ET_full_name=findViewById(R.id.ET_full_name);
        final EditText ET_otp=findViewById(R.id.ET_otp);
        progress = new ProgressDialog(this);
        if (reg_type.equals("registered")){
                ET_full_name.setVisibility(View.GONE);
                register=false;
            }
        BT_submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(OtpActivity.this,MainActivity.class));
                Boolean form_valid=true;
                if(ET_otp.getText().toString().equals("")){
                        form_valid=false;
                        Toast.makeText(getApplicationContext(),"Fill OTP",Toast.LENGTH_LONG).show();
                    }
                if(register && form_valid){
                        if(ET_full_name.getText().toString().equals("")){
                                form_valid=false;
                                Toast.makeText(getApplicationContext(),"Fill Full Name",Toast.LENGTH_LONG).show();
                            }
                    }
                if(form_valid){
                        login_verify_code(ET_otp.getText().toString(),user_id,ET_full_name.getText().toString(),"");
                    }
            }
        });
    }


    ///login verify code
    public void login_verify_code(String verify_code,String user_id,String name,String firebase_token){
        progress.setTitle("Loading");
        progress.setMessage("wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        String second_tokken="L!gMS5UP`eFD73P,s2r.5m7vL'#6+Ue89.yKjQu#gcC%+&T#6-";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfigData.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call = api.loginUserVerifyPhone(verify_code,user_id,name,firebase_token);
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
                            String tokken=obj.getString("access_tokken");
                            AppConfig.userTokken=tokken;
                            JSONObject user=obj.getJSONObject("user");
                            String user_id=user.getString("user_id");
                            SharedPreferences sharedpreferences = getBaseContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("user_id",user_id);
                            editor.putString("access_token",obj.getString("access_tokken"));
                            editor.putString("user_name",user.getString("user_name"));
                            editor.putString("user_phone",user.getString("user_phone"));
                            editor.commit();
                            Intent home = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(home);
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