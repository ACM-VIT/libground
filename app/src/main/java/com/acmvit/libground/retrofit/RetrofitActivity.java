package com.acmvit.libground.retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.acmvit.libground.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private TextView tvQuotes;
    private TextView tvAuthor;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        tvQuotes = findViewById(R.id.retrofit_quotes);
        tvAuthor = findViewById(R.id.retrofit_author);
        progressBar = findViewById(R.id.progress);

        getQuotes();
    }

    private void getQuotes() {
        Call<ApiResponse> getData = RetrofitClient.getService().getData();
        getData.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        setUpViewWithData(response.body());
                    }
                } else {
                    Toast.makeText(RetrofitActivity.this, "Failed get data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "Failed get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpViewWithData(ApiResponse response) {
        progressBar.setVisibility(View.GONE);
        tvQuotes.setText(response.getContent());
        tvAuthor.setText(response.getAuthor());
    }
}