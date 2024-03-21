package com.example.myapplication_pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.widget.TextView;

import android.widget.ImageView;

import android.view.View;

import android.util.Log;

import android.content.Intent;

import com.example.myapplication_pr2.databinding.ConstraintLayoutBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        setContentView(R.layout.constraint_layout);
        TextView textView = findViewById(R.id.textViewConstraintLayout);
        textView.setText(getString(R.string.hello_messege));
        ImageView imageView = findViewById(R.id.imageViewConstraintLayout);
        imageView.setImageResource(R.drawable.secondimage);
        Button button = findViewById(R.id.buttonConstraintLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("NW_Teg)", "Кнопка нажата программно");
            };
        });
         */
        ConstraintLayoutBinding binding = ConstraintLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonConstraintLayout.setText(getString(R.string.hello_messege));
        binding.imageViewConstraintLayout.setImageResource(R.drawable.secondimage);
        binding.buttonConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", R.drawable.secondimage);
                start.launch(intent);
            }
            ActivityResultLauncher<Intent> start = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Bundle image = result.getData().getExtras();
                            ImageView imageView = findViewById(R.id.imageViewConstraintLayout);
                            int imageResource = image.getInt("image");
                            imageView.setImageResource(imageResource);
                        }
                    });
        });
    }
    /*
    public void onClick(View view) {
        Log.d("NW_Teg)", "Кнопка нажата декларативно");
    }
     */
}