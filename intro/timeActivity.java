package com.pic.dailypic.intro;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.pic.dailypic.MainActivity;
import com.pic.dailypic.R;

import java.util.Calendar;
import java.util.Objects;

public class timeActivity extends AppCompatActivity {

    ImageView clock;
    TextView title,timeSelected;
    Button selectBtn,nextBtn;
    String timeSelectedT = "";

    ConstraintLayout timeCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        //COMP
        clock = findViewById(R.id.clock);
        title = findViewById(R.id.title);
        timeSelected = findViewById(R.id.timeSelected);
        timeCard = findViewById(R.id.timeCard);
        timeCard.setVisibility(View.INVISIBLE);
        selectBtn = findViewById(R.id.selectBtn);
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setVisibility(View.INVISIBLE);
        loadAnimations(); //ANIMATIONS
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTimePicker();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(timeSelectedT, "")) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("time",timeSelectedT);
                    startActivity(i);
                }
            }
        });

    }
    public void displayTimePicker () {
        Context context = this;
        final Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeSelectedT = String.format("%02d:%02d", hourOfDay, minute);
                        timeSelected.setText(getString(R.string.time_selected) +  " " + timeSelectedT.toString() + "h");
                        nextBtn.setVisibility(View.VISIBLE);
                        timeCard.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.RollIn)
                                .duration(1500)
                                .repeat(0)
                                .playOn(nextBtn);
                        YoYo.with(Techniques.StandUp)
                                .duration(1000)
                                .repeat(0)
                                .playOn(timeCard);
                    }
                },
                currentHour, currentMinute, false);
        timePickerDialog.setTitle(getString(R.string.time_selected));
        timePickerDialog.show();

    }

    public void loadAnimations () {
        YoYo.with(Techniques.SlideInLeft)
                .duration(1600)
                .repeat(0)
                .playOn(clock);
        YoYo.with(Techniques.SlideInLeft)
                .duration(1600)
                .repeat(0)
                .playOn(title);
        YoYo.with(Techniques.SlideInLeft)
                .duration(1600)
                .repeat(0)
                .playOn(selectBtn);
    }


}