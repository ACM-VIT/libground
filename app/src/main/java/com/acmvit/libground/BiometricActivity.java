package com.acmvit.libground;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class BiometricActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvStatus;
    private Button btnBiometric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric);

        tvStatus = findViewById(R.id.tv_status);
        btnBiometric = findViewById(R.id.btn_biometric);

        checkAvailability();

        btnBiometric.setOnClickListener(this);
    }

    private void checkAvailability() {
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS: // device have fingerprint sensor
                tvStatus.setText(getResources().getString(R.string.biometric_available));
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE: // device don't have fingerprint sensor
                tvStatus.setText(getResources().getString(R.string.biometric_no_hardware));
                btnBiometric.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                tvStatus.setText(getResources().getString(R.string.biometric_unavailable));
                btnBiometric.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                tvStatus.setText(getResources().getString(R.string.biometric_none_enrolled));
                btnBiometric.setVisibility(View.GONE);
                break;
        }
    }

    private void showBiometricPrompt() {
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(BiometricActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(BiometricActivity.this, errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(BiometricActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("This is title")
                .setSubtitle("This is subtitle")
                .setDescription("This is description")
                .setNegativeButtonText("Cancel")
                .build();

        biometricPrompt.authenticate(promptInfo);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_biometric) {
            showBiometricPrompt();
        }
    }
}