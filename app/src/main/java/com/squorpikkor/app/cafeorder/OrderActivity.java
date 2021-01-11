package com.squorpikkor.app.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.squorpikkor.app.cafeorder.SetOrderActivity.ORDER;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ((TextView)findViewById(R.id.order)).setText(getIntent().getStringExtra(ORDER));
    }
}