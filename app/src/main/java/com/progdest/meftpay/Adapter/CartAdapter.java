package com.progdest.meftpay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.ProductDetailsActivity;
import com.progdest.meftpay.R;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {

    ArrayList<FeaturedProduct> f_products;
    Context context;
    public CartAdapter(ArrayList<FeaturedProduct> f_products, Context c){
        this.context = c;
        this.f_products = f_products;
        Log.d("product_length_lenghtth",""+f_products.size());
    }

    @Override
    public int getCount() {
        return f_products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.card_product_inner, null);
            TextView f_product_name =  grid.findViewById(R.id.f_product_name);
            ImageView f_product_image =  grid.findViewById(R.id.f_product_image);
            TextView f_product_description =  grid.findViewById(R.id.f_product_description);
            TextView f_product_short_description =  grid.findViewById(R.id.f_product_description);
            TextView f_product_actual_price =  grid.findViewById(R.id.f_product_actual_price);
            TextView f_product_selling_cost =  grid.findViewById(R.id.f_product_selling_price);
            TextView f_product_offer =  grid.findViewById(R.id.f_product_offer);


            f_product_name.setText(f_products.get(position).getF_product_name());
            f_product_short_description.setText(f_products.get(position).getF_product_description1());
//          f_product_offer.setText(f_products.get(position).getF_product_discount());
           /* Picasso.with(this.context)
                    .load(R.drawable.place_holder_user)
                    .into(f_product_image);*/
            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent list_product = new Intent(context, ProductDetailsActivity.class);
                    context.startActivity(list_product);
                   /* Intent next_intent = new Intent(context, FeaturedProductDetailActivity.class);
                    next_intent.putParcelableArrayListExtra("f_product",  f_products);
                    next_intent.putExtra("position", position);
                    context.startActivity(next_intent);*/
                }
            });

        } else {
            grid =  convertView;
        }

        return grid;
    }
}
