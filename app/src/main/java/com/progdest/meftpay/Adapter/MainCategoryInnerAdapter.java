package com.progdest.meftpay.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.R;
import com.progdest.meftpay.Utility.AppConfigData;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

public class MainCategoryInnerAdapter extends RecyclerView.Adapter<MainCategoryInnerAdapter.ViewHolder> {

    ArrayList<MPCategory> types;
    Context context;
    public MainCategoryInnerAdapter(ArrayList<MPCategory> types, Context context) {
        this.types = types;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_category_inner, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.setData(position, types);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() {
        return types.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        ArrayList<MPCategory> types;
        Context context;
        TextView TV_category_name;
        ImageView IV_category_image;
        public ViewHolder(final View view) {
            super(view);
            view.setOnClickListener(this);
            context = view.getContext();
            TV_category_name = view.findViewById(R.id._sub_sub_category_name);
            IV_category_image = view.findViewById(R.id.sub_sub_category_image);


        }
        public void setData(final int position, final ArrayList<MPCategory> types) throws JSONException {
            this.types = types;

            TV_category_name.setText(types.get(position).getName());
            String image = AppConfigData.category_image_url+"/"+types.get(position).getImage();
            Log.d("dddd",""+image);
            Picasso.with(this.context)
                    .load(AppConfigData.category_image_url+"/"+types.get(position).getImage())
                    .into(IV_category_image);

        }
        @Override
        public void onClick(View v) {


        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}



