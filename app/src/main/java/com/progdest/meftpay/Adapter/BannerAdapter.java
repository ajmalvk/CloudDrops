package com.progdest.meftpay.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.progdest.meftpay.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mohammednaseeb on 04/06/17.
 */

public class BannerAdapter extends PagerAdapter  {

    Context context;
    int[] image_arr;
    ArrayList<String> imageBanner;
    private  ViewPager viewPager;
    LayoutInflater layoutInflater;
    private int         mCurrentPosition;
    private int         mScrollState;

    public BannerAdapter(Context context, ArrayList<String> imageBanner, ViewPager viewPager) {
        this.imageBanner = imageBanner;
        this.context = context;
        this.viewPager = viewPager;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        final int pos = position;
        View itemView = layoutInflater.inflate(R.layout.card_item_banner, container, false);
        ImageView imageView =  itemView.findViewById(R.id.img);
        Log.d("gggggg",""+imageBanner.get(position));
        Picasso.with(this.context)
                .load(R.drawable.bann_one)
                .into(imageView);
        container.addView(itemView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (pos + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }


}
