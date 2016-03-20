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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_train_select);
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonStart.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonBack:
                onBackPressed();
                break;
            case R.id.buttonStart:
                startActivity(new Intent(TrainSelectActivity.this,TrainingActivity.class));
                break;
            default:
                break;
        }
    }
}
