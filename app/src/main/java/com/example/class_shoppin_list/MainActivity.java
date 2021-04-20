package com.example.class_shoppin_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> items=new ArrayList<>();
    public static ArrayList<cartItem> cartItems=new ArrayList<>();
    Button addBtn,viewCartBtn, placeOrderBtn;
    SeekBar qtySb;
    ListView itemsLV;
    TextView qtyLbl,totalLbl;

    public static Item selectedItem;
    public static double total = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();

        selectedItem = items.get(0);
        addBtn = findViewById(R.id.addBtn);
        viewCartBtn = findViewById(R.id.viewCartBtn);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);
        qtySb = findViewById(R.id.qtySb);
        itemsLV = findViewById(R.id.itemsLV);
        qtyLbl = findViewById(R.id.qtyLbl);
        totalLbl = findViewById(R.id.totalLbl);
        totalLbl.setText("$ " + String.format("%.2f", total));
        itemsLV.setAdapter(new ItemAdapter(getBaseContext(), items));
        itemsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = items.get(position);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.add( new cartItem(selectedItem.getName(), selectedItem.getPrice(), qtySb.getProgress()) );
                total += selectedItem.getPrice() * qtySb.getProgress();
                totalLbl.setText("$ " + String.format("%.2f", total));
            }
        });

        qtySb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                qtyLbl.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0.0;
                totalLbl.setText("$ " + String.format("%.2f", total));
                cartItems.clear();
            }
        });

        viewCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), cartActivity.class);
                startActivity(intent);
            }
        });
    }

    public void fillData(){
        if(items.size() == 0){

            items.add(new Item("Hand Gloves",9.9,"gloves"));
            items.add(new Item("Face Mask",12.5,"mask"));
            items.add(new Item("Alcohol Spray",6.5,"alcohol"));
            items.add(new Item("Sanitizer",7.5,"sanitizer"));
            items.add(new Item("Face Shield",6,"shield"));
            items.add(new Item("PPE Kit",75,"ppe"));
            total = 0.0;
            totalLbl.setText("$ " + String.format("%.2f", total));
        }
    }
}