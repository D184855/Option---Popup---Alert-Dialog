package com.example.my27jan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    Button button1;
    Button button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Button 1", Toast.LENGTH_SHORT).show();
            }
        });

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);


    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button3:
                Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button4:
                Toast.makeText(this, "Button 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showToastMsg(View view) {
        Toast.makeText(this, "Button 5", Toast.LENGTH_SHORT).show();
    }


    public void showMessage(View view) {
        Toast.makeText(this, "Button 6", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }
}