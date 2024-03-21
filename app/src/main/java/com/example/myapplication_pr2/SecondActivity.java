package com.example.myapplication_pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;

import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
        Bundle image = getIntent().getExtras();
        ImageView imageView = findViewById(R.id.imageViewConstraintLayout);
        int imageResource = image.getInt("image");
        imageView.setImageResource(imageResource);
        Button backButton = findViewById(R.id.buttonConstraintLayout);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("image", imageResource);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}