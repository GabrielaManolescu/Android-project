package com.example.gestiunechirii;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FeedbackActivity extends AppCompatActivity {
    public static final String SHARED_PREF="sharedPref";
    public static final String SHARED_PREF_FEEDBACK="sharedPrefFeedback";
    private ImageButton btnHome;
    private RatingBar ratingBar;
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        initComponents();
    }

    private void initComponents() {
         btnHome = findViewById(R.id.btn_home);
         ratingBar = findViewById(R.id.feedback_raiting_bar);

            sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        float ratingValue = sharedPref.getFloat(SHARED_PREF_FEEDBACK, -1);

        if(ratingValue != -1) {
            ratingBar.setRating(ratingValue);
        }

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putFloat(SHARED_PREF_FEEDBACK, rating);
            editor.apply();
        });

        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            Toast.makeText(getApplicationContext(), R.string.feedback_mult,
                    Toast.LENGTH_LONG)
                    .show();
            startActivity(intent);
        });
    }

}