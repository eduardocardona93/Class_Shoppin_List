package com.example.class_shoppin_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cartItemAdapter extends BaseAdapter {
    ArrayList<cartItem> cartItems=new ArrayList<>();
    private LayoutInflater inflater;
    @Override
    public int getCount() { return cartItems.size(); }

    @Override
    public Object getItem(int position)  { return cartItems.get(position);}

    @Override
    public long getItemId(int position) { return position; }

    //constructor
    public cartItemAdapter(Context context, ArrayList<cartItem> cartItems){
        this.cartItems=cartItems;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.cart_row, null);
            holder = new ViewHolder();
            holder.cartItemName = convertView.findViewById(R.id.cartItemName);
            holder.cartItemPrice = convertView.findViewById(R.id.cartItemPrice);
            holder.cartItemQty = convertView.findViewById(R.id.cartItemQty);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.cartItemName.setText(cartItems.get(position).getName());
        holder.cartItemPrice.setText(String.valueOf(cartItems.get(position).getPrice()));
        holder.cartItemQty.setText(String.valueOf(cartItems.get(position).getQuantity()));

        return convertView;
    }

    private class ViewHolder{
        //create attributes according to the object related to the list_row
        private TextView cartItemName;
        private TextView cartItemPrice;
        private TextView cartItemQty;
    }
}
