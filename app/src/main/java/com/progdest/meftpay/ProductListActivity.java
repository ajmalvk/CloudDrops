package com.progdest.meftpay;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.GridView;

import com.progdest.meftpay.Adapter.FeaturedProductsAdapter;
import com.progdest.meftpay.Adapter.MainCategoryInnerAdapter;
import com.progdest.meftpay.Utility.AppConfigData;

public class ProductListActivity extends Activity  {

    Button next;
    RecyclerView categories;
    GridView products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);
        categories = findViewById(R.id.category_view);
        products = findViewById(R.id.grid_view);


        categories.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true);
        mLayoutManager.setReverseLayout(false);
        categories.setLayoutManager(mLayoutManager);
        MainCategoryInnerAdapter address_adapter = new MainCategoryInnerAdapter(AppConfigData.categories, this);
        categories.setAdapter(address_adapter);
        categories.smoothScrollToPosition(1);
        loadProducts();

       /*
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this,LoginActivity.class));
            }
        });*/
    }

    private void loadProducts() {

        FeaturedProductsAdapter booksAdapter = new FeaturedProductsAdapter( AppConfigData.featuredProducts_demo,this);
        products.setAdapter(booksAdapter);
    }
}