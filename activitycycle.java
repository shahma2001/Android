package com.example.activitycycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifecycle";
    private TextView textView;
    private StringBuilder lifecycleText = new StringBuilder(); // to append lifecycle events

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this matches your XML filename

        textView = findViewById(R.id.textView);

        logAndAppend("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend("onDestroy");
    }

    private void logAndAppend(String methodName) {
        Log.d(TAG, methodName + " called");
        lifecycleText.append(methodName).append("\n");
        textView.setText(lifecycleText.toString());
    }
}
