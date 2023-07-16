package com.example.sampleproject;

import static com.example.sampleproject.RetrofitApi.apiService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchDataFromApi();
            }
            private void FetchDataFromApi() {
                Call<List<Product>> call = (Call<List<Product>>) apiService.getProduct();
              call.enqueue(new Callback<List<Product>>(){
                  @Override
                  public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                      if (response.isSuccessful()){
                          Product data = (Product) response.body();
                          Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                           intent.putExtra("data",(CharSequence) data);
                           startActivity(intent);
                      }
                  }

                  @Override
                  public void onFailure(Call<List<Product>> call, Throwable t) {
                      Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                  }
            });
            }

        });

    }
}