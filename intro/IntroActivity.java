package com.pic.dailypic.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.pic.dailypic.R;

public class IntroActivity extends AppCompatActivity {

    Button nextBtn;

    ImageView cameraImg,wave;

    TextView title, introMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        //COMP
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setVisibility(View.INVISIBLE);
        cameraImg = findViewById(R.id.cameraImg);
        wave = findViewById(R.id.wave);
        title = findViewById(R.id.title);
        introMsg = findViewById(R.id.introMsg);
        setAnimations();
        (new Handler()).postDelayed(this::setBtnAnimation, 2000); //BTN ANIM WAITHOLDER

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),timeActivity.class));
            }
        });

    }

    public void setAnimations () {
        YoYo.with(Techniques.ZoomIn)
                .duration(1700)
                .repeat(0)
                .playOn(cameraImg);
      YoYo.with(Techniques.SlideInDown)
                .duration(1700)
                .repeat(0)
                .playOn(wave);
        YoYo.with(Techniques.ZoomIn)
                .duration(1700)
                .repeat(0)
                .playOn(title);
        YoYo.with(Techniques.ZoomIn)
                .duration(1700)
                .repeat(0)
                .playOn(introMsg);

    }
    public void setBtnAnimation () {
        nextBtn.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.RotateInDownRight)
                .duration(1500)
                .repeat(0)
                .playOn(nextBtn);
    }
}