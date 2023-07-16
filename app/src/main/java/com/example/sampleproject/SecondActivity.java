package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView id_TV = findViewById(R.id.id_Tv);
        TextView userId_TV = findViewById(R.id.userId_Tv);
        TextView title = findViewById(R.id.title_Tv);
        TextView body = findViewById(R.id.body_Tv);


        List<Product> data = (List<Product>) getIntent().getSerializableExtra("data");

//        Product data = getIntent().getParcelableExtra("data");

//        id_TV.setText(data.getId());
//        userId_TV.setText(data.getUserId());
//        title.setText(data.getTitle());
//        body.setText(data.getBody());
    }
}