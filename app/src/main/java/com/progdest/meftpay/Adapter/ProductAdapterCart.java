package com.progdest.meftpay.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.R;

import org.json.JSONException;

import java.util.ArrayList;

public class ProductAdapterCart extends RecyclerView.Adapter<ProductAdapterCart.ViewHolder> {

    ArrayList<FeaturedProduct> products;
    Context context;
    public ProductAdapterCart(ArrayList<FeaturedProduct> products, Context context) {
        this.products = products;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_product_cart, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.setData(position, products);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        ArrayList<FeaturedProduct> products;
        Context context;
        public ViewHolder(final View view) {
            super(view);
            view.setOnClickListener(this);
            context = view.getContext();
            TextView f_product_name =  view.findViewById(R.id.product_title);
          //  ImageView f_product_image =  view.findViewById(R.id.f_product_image);
            TextView f_product_quantitty =  view.findViewById(R.id.product_quantity);


            TextView off_percent =  view.findViewById(R.id.off_percent);

         /*   Picasso.with(this.context)
                    .load(R.drawable.bann_one)
                    .into(imageView);*/
            f_product_name.setText("2L Bisleri water woth full of nutrients");
            f_product_quantitty.setText("2");



        }
        public void setData(final int position, final ArrayList<FeaturedProduct> products) throws JSONException {
            this.products = products;
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



