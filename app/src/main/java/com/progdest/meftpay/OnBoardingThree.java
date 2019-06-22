package com.progdest.meftpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class OnBoardingThree extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_three_activity);
        Button next = findViewById(R.id.BT_onboarding_three);
        SharedPreferences sharedpreferences = getBaseContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("is_first_time","No");
        editor.commit();
        String ss=getBaseContext().getSharedPreferences("MyPreferences",Context.MODE_PRIVATE).getString("is_first_time","default");
        Log.d("first",ss);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingThree.this,LoginActivity.class));
            }
        });
    }


}