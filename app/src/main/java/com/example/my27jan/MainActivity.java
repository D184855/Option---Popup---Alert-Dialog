package com.example.my27jan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button, buttonPopup;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.alert);
        builder = new AlertDialog.Builder(MainActivity.this);

        buttonPopup = findViewById(R.id.popup);
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonPopup);
                popupMenu.inflate(R.menu.popup);
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                        switch (menuItem.getItemId()){
                            case R.id.html:
                                Toast.makeText(getApplicationContext(), "HTML", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.css:
                                Toast.makeText(getApplicationContext(), "CSS", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.bootstrap:
                                Toast.makeText(getApplicationContext(), "Bootstrap", Toast.LENGTH_LONG).show();
                                break;
                        }

                        return false;
                    }
                });

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Build Alert Dialog start
                builder.setMessage("Do you want to close this app ?");
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
//                Build Alert Dialog end

//                Show Alert Dialog start
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Alert");
                alertDialog.show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(MainActivity.this, "Call", Toast.LENGTH_LONG).show();
                break;

            case R.id.sms:
                Toast.makeText(MainActivity.this, "SMS", Toast.LENGTH_LONG).show();
                break;


            case R.id.email:
                Toast.makeText(MainActivity.this, "Email", Toast.LENGTH_LONG).show();
                break;

            case R.id.secondactivity:
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}