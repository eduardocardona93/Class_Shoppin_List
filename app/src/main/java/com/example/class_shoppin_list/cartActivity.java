package com.example.class_shoppin_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class cartActivity extends AppCompatActivity {
    Button returnBtn;
    TextView totalCartLbl;
    ListView cartLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        returnBtn = findViewById(R.id.returnBtn);
        totalCartLbl = findViewById(R.id.totalCartLbl);
        cartLV = findViewById(R.id.cartLV);

        cartLV.setAdapter(new cartItemAdapter(getBaseContext(), MainActivity.cartItems));
        totalCartLbl.setText("$ " + String.format("%.2f",  MainActivity.total));

        cartLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.total -= MainActivity.cartItems.get(position).getPrice() * MainActivity.cartItems.get(position).getQuantity();
                MainActivity.cartItems.remove(position);
                cartLV.setAdapter(new cartItemAdapter(getBaseContext(), MainActivity.cartItems));
                totalCartLbl.setText("$ " + String.format("%.2f",  MainActivity.total));
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}