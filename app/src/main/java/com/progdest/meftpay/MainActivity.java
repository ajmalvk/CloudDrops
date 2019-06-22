package com.progdest.meftpay;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;


import com.progdest.meftpay.Adapter.FeaturedProductsAdapter;
import com.progdest.meftpay.Adapter.MainCategoryAdapter;
import com.progdest.meftpay.Adapter.ProductAdapter;
import com.progdest.meftpay.Fragments.HomeFragment;
import com.progdest.meftpay.Fragments.ProfileFragment;
import com.progdest.meftpay.Model.CategoryModel;
import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.SubCategoryModel;
import com.progdest.meftpay.Model.SubSubCategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //BottomNavigationViewHelper.removeShiftMode(navigation);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home_nav:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.subscribe_nav:
                    selectedFragment = ProfileFragment.newInstance();
                    break;
                case R.id.track_order_nav:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.cart_na:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.account_nav:
                    selectedFragment = HomeFragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

}
