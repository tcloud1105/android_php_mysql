package com.example.application.demodatabase;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
    }

    public void gotoregister(View view){
    Intent intent = new Intent(this, Register.class);
    startActivity(intent);
    }
}
