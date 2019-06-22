package com.progdest.meftpay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.progdest.meftpay.Model.DayModel;
import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.ProductListActivity;
import com.progdest.meftpay.R;
import com.progdest.meftpay.Utility.AppConfigData;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ViewHolder> {

    ArrayList<DayModel> types;
    Context context;
    public DaysAdapter(ArrayList<DayModel> types, Context context) {
        this.types = types;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_day_selection, viewGroup, false);
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
        ArrayList<DayModel> types;
        Context context;
        TextView da_name;
        LinearLayout card_bg;
        CardView card_back;
        ImageView IV_category_image;
        public ViewHolder(final View view) {
            super(view);
            view.setOnClickListener(this);
            context = view.getContext();
            da_name = view.findViewById(R.id.da_name);
            card_bg = view.findViewById(R.id.card_bg_liniear);
            card_back = view.findViewById(R.id.card_bg);
            // IV_category_image = view.findViewById(R.id.IV_category_image);
        }
        public void setData(final int position, final ArrayList<DayModel> types) throws JSONException {
            this.types = types;

            if (types.get(position).getDay_selected().equals(true)){
                card_bg.setBackground(context.getResources().getDrawable(R.drawable.curved_primary_bg));
                card_back.setRadius(10);
                card_back.setPreventCornerOverlap(false);
            }else {
                card_bg.setBackground(context.getResources().getDrawable(R.drawable.curved_white_bg));
                card_back.setRadius(10);
                card_back.setPreventCornerOverlap(false);
            }
            da_name.setText(types.get(position).getDay_name());
        }
        @Override
        public void onClick(View v) {

            if(types.get(getAdapterPosition()).getDay_selected().equals(true)){
                types.get(getAdapterPosition()).setDay_selected(false);
            }else {
                types.get(getAdapterPosition()).setDay_selected(true);
            }
            //   ((FinancialAsseActivity)context).assteTypeSelected(getAdapterPosition());
            notifyDataSetChanged();
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}


