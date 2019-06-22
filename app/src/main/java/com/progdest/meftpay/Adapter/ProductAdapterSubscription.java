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

public class ProductAdapterSubscription extends RecyclerView.Adapter<ProductAdapterSubscription.ViewHolder> {

    ArrayList<FeaturedProduct> products;
    Context context;
    public ProductAdapterSubscription(ArrayList<FeaturedProduct> products, Context context) {
        this.products = products;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_product_view_subscription, viewGroup, false);
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
        ImageView visibility_image;
        public ViewHolder(final View view) {
            super(view);
            view.setOnClickListener(this);
            context = view.getContext();
            TextView f_product_name =  view.findViewById(R.id.f_product_name);
            ImageView f_product_image =  view.findViewById(R.id.f_product_image);
            TextView f_product_description =  view.findViewById(R.id.f_product_description);
            TextView f_product_short_description =  view.findViewById(R.id.f_product_description);
            TextView f_product_actual_price =  view.findViewById(R.id.f_product_actual_price);
            TextView f_product_selling_cost =  view.findViewById(R.id.f_product_selling_price);
            visibility_image =  view.findViewById(R.id.visibility_image);

            TextView off_percent =  view.findViewById(R.id.off_percent);

         /*   Picasso.with(this.context)
                    .load(R.drawable.bann_one)
                    .into(imageView);*/
            visibility_image.bringToFront();
            f_product_name.setText("Product Name");
            f_product_description.setText("Product Description");
            f_product_short_description.setText("Product Description");
            f_product_actual_price.setText("50");
            f_product_selling_cost.setText("120");
            off_percent.setText("20% OFF");


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



