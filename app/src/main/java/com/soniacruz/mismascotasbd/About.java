package com.soniacruz.mismascotasbd;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBarAbout);
        setSupportActionBar(miActionBar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Habilita el botón Subir
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setIcon(R.drawable.ic_footprint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(1200);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(new Fade(Fade.OUT));
        }


    }
}