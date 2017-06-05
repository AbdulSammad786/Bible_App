package com.example.abdulsamad.bible.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.abdulsamad.bible.AppIntro.animations.CustomAnimation;
import com.example.abdulsamad.bible.AppIntro.animations.DepthAnimation;
import com.example.abdulsamad.bible.AppIntro.animations.FadeAnimation;
import com.example.abdulsamad.bible.AppIntro.animations.FlowAnimation;
import com.example.abdulsamad.bible.AppIntro.animations.SlideOverAnimation;
import com.example.abdulsamad.bible.AppIntro.animations.ZoomAnimation;
import com.example.abdulsamad.bible.AppIntro.indicators.CustomIndicator;
import com.example.abdulsamad.bible.AppIntro.indicators.ProgressIndicator;
import com.example.abdulsamad.bible.R;
public class AppIntroMainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appintro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("App Intro");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void startDefaultIntro(View v) {
        Intent intent = new Intent(this, DefaultIntro.class);
        startActivity(intent);
        finish();
    }
    public void startCustomIntro(View v) {
        Intent intent = new Intent(this, CustomIntro.class);
        startActivity(intent);
        finish();
    }
    public void startSecondLayoutIntro(View v) {
        Intent intent = new Intent(this, SecondLayoutIntro.class);
        startActivity(intent);
        finish();
    }
    public void startFadeAnimation(View v) {
        Intent intent = new Intent(this, FadeAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startZoomAnimation(View v) {
        Intent intent = new Intent(this, ZoomAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startFlowAnimation(View v) {
        Intent intent = new Intent(this, FlowAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startDepthAnimation(View v) {
        Intent intent = new Intent(this, DepthAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startSlideOverAnimation(View v) {
        Intent intent = new Intent(this, SlideOverAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startCustomAnimation(View v) {
        Intent intent = new Intent(this, CustomAnimation.class);
        startActivity(intent);
        finish();
    }
    public void startProgressIndicator(View v) {
        Intent intent = new Intent(this, ProgressIndicator.class);
        startActivity(intent);
        finish();
    }
    public void startCustomIndicator(View v) {
        Intent intent = new Intent(this, CustomIndicator.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}