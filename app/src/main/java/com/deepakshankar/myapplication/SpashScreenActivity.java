package com.deepakshankar.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SpashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spash_screen);

        final ImageView appImage = (ImageView) findViewById(R.id.appImage);
        final Animation roatate = AnimationUtils.loadAnimation(getBaseContext(),R.anim.splash_screen_anime);
        final Animation fadeOut = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        appImage.startAnimation(roatate);

        roatate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                appImage.startAnimation(fadeOut);
                finish();
                Intent searchIntent = new Intent(getBaseContext(),SearchActivity.class);
                startActivity(searchIntent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
