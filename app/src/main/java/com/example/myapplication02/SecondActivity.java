package com.example.myapplication02;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class SecondActivity extends AppCompatActivity {
    TextView textViewGreeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewGreeting =findViewById(R.id.textViewGreeting);
        String name = getIntent().getStringExtra("USER_NAME");
        textViewGreeting.setText("Hello, " + name + "!");
    }
}
