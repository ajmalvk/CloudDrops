package com.progdest.meftpay.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.progdest.meftpay.Model.UserAddressmodel;
import com.progdest.meftpay.R;

import java.util.ArrayList;

/**
 * Created by Mohammed Naseeb vp on 13-04-2018.
 */

public class DeliveryAddressAdapterCart extends RecyclerView.Adapter<DeliveryAddressAdapterCart.ViewHolder> {

    private ArrayList<UserAddressmodel> addresses;
    Context context;
    ProgressDialog dialog;
    ImageView selected_addr,selected_addresso;
    int current_position;
    public DeliveryAddressAdapterCart(ArrayList<UserAddressmodel> addresses, Context context) {
        this.addresses = addresses;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_address_cart, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position,addresses);
    }
    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView delivery_address, delivery_name,delivery_phone;
        ArrayList<UserAddressmodel> addresses;
        ImageView selected_address,selected_addresso;
        Context context;

        public ViewHolder(final View view) {
            super(view);
            context = view.getContext();
            delivery_address =  view.findViewById(R.id.delivery_address);
            delivery_name =  view.findViewById(R.id.delivery_person);
            delivery_phone =  view.findViewById(R.id.delivery_phone);
            //selected_address =  view.findViewById(R.id.selected_address);
          //  selected_addr = selected_address;

           /* selected_address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_position = getAdapterPosition();
                    check_availabilityByDistance();
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_position = getAdapterPosition();
                    check_availabilityByDistance();
                }
            });*/
        }
        public void setData(final int position, final ArrayList<UserAddressmodel> addresses)
        {
            this.addresses = addresses;
            delivery_name.setText(addresses.get(position).getName());
            delivery_address.setText(
                    addresses.get(position).getAddress_line1()+""+
                    addresses.get(position).getAddress_line2()+"\n"+
                    addresses.get(position).getArea());

          /*  if(addresses.get(getAdapterPosition()).getAddress_is_selected().toString().equals("yes")) {
                selected_address.setBackground(context.getResources().getDrawable(R.drawable.ic_radio_tick));
            }else {
                selected_address.requestLayout();
                selected_address.getLayoutParams().height = 50;
                selected_address.getLayoutParams().width = 50;
                selected_address.setBackground(context.getResources().getDrawable(R.drawable.box_tick_mark_greydark));
            }*/
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    /*public void check_availabilityByDistance() {
        dialog = ProgressDialog.show(context, "",
                "Checking availability..", true);
        dialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call = api.checkLocality(new Preferences().readAccessToken(context).replace("\"",""),
                addresses.get(current_position).getAddress_latitude(),
                addresses.get(current_position).getAddress_longitude());
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                dialog.dismiss();
                if(response.body().get("status").toString().equals("1")){
                    if(addresses.get(current_position).getAddress_is_selected().toString().equals("no") ) {
                        addresses.get(current_position).setAddress_is_selected("yes");
                       // listener.setShippingChare(response.body().get("shipping_charge").toString());
                        listener.onAddressSelected(addresses.get(current_position).getAddress_id(),
                                addresses.get(current_position).getAddress_latitude(),
                                addresses.get(current_position).getAddress_longitude());

                        for(int i=0;i<addresses.size();i++){
                            if(!(i == current_position)) {
                                selected_addr.requestLayout();
                                selected_addr.getLayoutParams().height = 50;
                                selected_addr.getLayoutParams().width = 50;
                                addresses.get(i).setAddress_is_selected("no");
                            } }
                        notifyDataSetChanged();
                    }else {
                        listener.onAddressSelected("not_selected","default","default");
                        addresses.get(current_position).setAddress_is_selected("no");
                        notifyDataSetChanged();
                    }
                }else {
                    for(int i=0;i<addresses.size();i++){
                        selected_addr.requestLayout();
                        selected_addr.getLayoutParams().height = 50;
                        selected_addr.getLayoutParams().width = 50;
                        addresses.get(i).setAddress_is_selected("no");
                    }
                    listener.onAddressSelected("not_selected","default","default");
                    addresses.get(current_position).setAddress_is_selected("no");
                    Toast.makeText(context,
                            "  Delivery is not available  ",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context,"  Failed  ",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }*/
}