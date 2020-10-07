package com.acmvit.libground;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Implemented the layout per http://facebook.github.io/shimmer-android/
 */

public class ShimmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer);
    }

}
