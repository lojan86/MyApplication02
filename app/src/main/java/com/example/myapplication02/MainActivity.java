package com.example.myapplication02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication02.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnNavigate, btnOpenWeb, btnDialPhone, btnCapturePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        btnNavigate = findViewById(R.id.btnNavigate);
        btnOpenWeb = findViewById(R.id.btnOpenWeb);
        btnDialPhone = findViewById(R.id.btnDialPhone);
        btnCapturePhoto = findViewById(R.id.btnCapturePhoto);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                if (!name.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("USER_NAME", name);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnDialPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneUri = Uri.parse("tel:1234567890");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnCapturePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
