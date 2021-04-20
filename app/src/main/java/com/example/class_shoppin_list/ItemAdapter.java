package com.example.class_shoppin_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    private ArrayList<Item> itemList=new ArrayList<>();
    private LayoutInflater inflater;
    //constructor
    public ItemAdapter(Context context, ArrayList<Item>itemList){
        this.itemList=itemList;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount()  {
        return itemList.size();
    }

    @Override
    public Object getItem(int position)  { return itemList.get(position);}

    @Override
    public long getItemId(int position) { return position; }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.itemName);
            holder.itemPrice = convertView.findViewById(R.id.itemPrice);
            holder.itemImage = convertView.findViewById(R.id.itemImage);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.itemName.setText(itemList.get(position).getName());
        holder.itemPrice.setText(String.valueOf(itemList.get(position).getPrice()));
        int imId=convertView.getResources().getIdentifier(itemList.get(position).getImageName(),"mipmap",inflater.getContext().getPackageName());
        holder.itemImage.setImageResource(imId);

        return convertView;
    }
    private class ViewHolder{
        //create attributes according to the object related to the list_row
        private TextView itemName;
        private TextView itemPrice;
        private ImageView itemImage;
    }
}
