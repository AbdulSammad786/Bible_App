package com.example.abdulsamad.bible.AppIntro.animations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.abdulsamad.bible.AppIntro.AppIntroMainActivity;
import com.example.abdulsamad.bible.AppIntro.SampleSlide;
import com.example.abdulsamad.bible.R;

import me.arulnadhan.appintro.AppIntro;

public class FadeAnimation extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));

        setFadeAnimation();
    }

    private void loadMainActivity() {
        Intent intent = new Intent(this, AppIntroMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}