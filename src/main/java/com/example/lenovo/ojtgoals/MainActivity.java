package com.example.lenovo.ojtgoals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtview.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.image, 0, 0, 0);
    }
}
