package com.acmvit.libground;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class FastAndroidNetworkingActivity extends AppCompatActivity {

    private TextView tvQuotes;
    private TextView tvAuthor;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_android_networking);

        tvQuotes = findViewById(R.id.fan_quotes);
        tvAuthor = findViewById(R.id.fan_author);
        progressBar = findViewById(R.id.progress);

        getQuotes();
    }

    private void getQuotes() {
        AndroidNetworking.get("http://api.quotable.io/random")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        setUpViewWithData(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(FastAndroidNetworkingActivity.this, "Failed get data", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setUpViewWithData(JSONObject response) {
        progressBar.setVisibility(View.GONE);
        try {
            tvQuotes.setText(response.getString("content"));
            tvAuthor.setText(response.getString("author"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}