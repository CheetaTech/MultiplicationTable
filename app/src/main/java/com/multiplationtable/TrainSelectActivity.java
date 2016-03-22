package com.multiplationtable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TrainSelectActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     *  ilk acıldıgında butonları normal konumuna almamız gerekebilir.
     * */

    int[] trainingSelectButtonId = new int[]{
            R.id.select_one_btn,
            R.id.select_two_btn,
            R.id.select_three_btn,
            R.id.select_four_btn,
            R.id.select_five_btn,
            R.id.select_six_btn,
            R.id.select_eight_btn,
            R.id.select_nine_btn,
            R.id.select_ten_btn,
            R.id.buttonBack,
            R.id.buttonStart
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_train_select);
        init();


        /*
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonStart.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        */
    }

    private void init() {
        for(int i = 0;i<trainingSelectButtonId.length;i++)
            ((Button)findViewById(trainingSelectButtonId[i])).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonBack:
                onBackPressed();
                break;
            case R.id.buttonStart:
                checkButtons();
                startActivity(new Intent(TrainSelectActivity.this,TrainingActivity.class));
                break;
            default:
                break;
        }
    }

    private void checkButtons() {

    }
}
