package com.progdest.meftpay.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.progdest.meftpay.Adapter.BannerAdapter;
import com.progdest.meftpay.Adapter.DeliveryAddressAdapter;
import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.UserAddressmodel;
import com.progdest.meftpay.R;
import com.progdest.meftpay.Utility.AppConfigData;

import java.util.ArrayList;


public class ProfileFragment extends android.support.v4.app.Fragment {


    ViewPager viewPager;
    BannerAdapter banner_dapter;
    RecyclerView RV_address;
    private LinearLayoutManager mLayoutManager;
    ArrayList<FeaturedProduct> featuredProducts_list;
    ArrayList<String> imageBanner=new ArrayList<String>();
    public static ProfileFragment newInstance(){
        ProfileFragment fragment=new ProfileFragment();
        return fragment;
    }
    ProgressDialog progress;
    String tokken;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View home_fragment;
        home_fragment = inflater.inflate(R.layout.profile_fragment, container, false);
        RV_address = home_fragment.findViewById(R.id.RV_address);

        loadAddress();



        return  home_fragment;
    }


    private void loadAddress(){
        ArrayList<UserAddressmodel> address;
        address = new ArrayList<>();
        UserAddressmodel four = new UserAddressmodel("","Home","Naseeb vp","Chunhgam"
                ,"Vattiparambath house"," vengoor","Vengoor","679325","Perinthalmanna"
                ,"Malappuram","MEA","+919995768540","4.345","345.234"
                ,true,false,true,false,"ewr","wer"
                );

        AppConfigData.address = address;

        address = new ArrayList<>();
        address.add(four);
      /*  address.add(four);
        address.add(four);
        address.add(four);*/
        LinearLayoutManager mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        RV_address.setLayoutManager(mManager);
        DeliveryAddressAdapter oAdapter = new DeliveryAddressAdapter(address, getActivity());
        RV_address.setAdapter(oAdapter);

    }


}