package com.example.abdulsamad.bible.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.abdulsamad.bible.R;
public class Signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void signup(View view)
    {

    }
    public void redirectLogin(View view)
    {
        finish();
        startActivity(new Intent(this,Login.class));
    }
}