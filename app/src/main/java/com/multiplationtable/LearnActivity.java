package com.multiplationtable;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import controller.LearningController;

public class LearnActivity extends AppCompatActivity implements  View.OnClickListener , LearningController.OnSelectedImage {

    int[] learnButtons = new int[]{
            R.id.buttonX1,
            R.id.buttonX2,
            R.id.buttonX3,
            R.id.buttonX4,
            R.id.buttonX5,
            R.id.buttonX6,
            R.id.buttonX7,
            R.id.buttonX8,
            R.id.buttonX9,
            R.id.buttonX10
    };
    LearningController controller = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_learn);
        init();
    }

    private void init() {

        controller = new LearningController(getApplicationContext());
        controller.setListener(this);

        ((ImageView)findViewById(R.id.backImageViewLearn)).setOnClickListener(this);
        for (int i = 0;i< learnButtons.length; i++)
            ((Button)findViewById(learnButtons[i])).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backImageViewLearn)
            onBackPressed();

        for(int i = 0;i<learnButtons.length;i++)
        {
            if(v.getId() == learnButtons[i])
            {
                controller.setImage(i);
                break;
            }
        }
    }

    @Override
    public void OnSelected(Bitmap bitmap) {
        ((ImageView)findViewById(R.id.learnImageView)).setImageBitmap(bitmap);
    }
}
