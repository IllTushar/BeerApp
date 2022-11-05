package com.example.beerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beerapp.Adapter.recyclerViewAdapter;
import com.example.beerapp.Api.ApiServices;
import com.example.beerapp.Api.RetrofitClient;
import com.example.beerapp.Model.ResponseClass;
import com.example.beerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ActivityMainBinding binding;
TextView beer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView  =findViewById(R.id.rec_view);
        beer = findViewById(R.id.beer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        processData();
    }

    private void processData()
    {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Please Wait..");
        pd.show();
       ApiServices api  = new RetrofitClient().getRetrofit().create(ApiServices.class);
        Call<List<ResponseClass>> call = api.getData();
        try {
            call.enqueue(new Callback<List<ResponseClass>>() {
                @Override
                public void onResponse(Call<List<ResponseClass>> call, Response<List<ResponseClass>> response) {
                    if (response.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this, "Details Featch!!", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                        List<ResponseClass>responseClasses = response.body();
                        recyclerViewAdapter adapter = new recyclerViewAdapter(MainActivity.this,responseClasses);
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<ResponseClass>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failed!!", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                    return;
                }
            });
        }catch (Exception e){
            Log.d("##Print",e.getMessage());
        }

    }
}