package com.pic.dailypic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    TextView title;
    ConstraintLayout card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //COMP
        title = findViewById(R.id.txt);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        loadAnimations();
        if (getIntent().getExtras() != null) {
            Log.d("Time", getIntent().getExtras().getString("time")); //CONFIRM DATA PASSED
        }
    }

    public void loadAnimations () {
        YoYo.with(Techniques.SlideInUp)
                .duration(1600)
                .repeat(0)
                .playOn(title);
        YoYo.with(Techniques.SlideInUp)
                .duration(1600)
                .repeat(0)
                .playOn(card1);
        YoYo.with(Techniques.SlideInUp)
                .duration(1600)
                .repeat(0)
                .playOn(card2);

    }
}