package com.multiplationtable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity  implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selection);
        Button buttonLearn = (Button)findViewById(R.id.buttonLearn);
        Button buttonTrain = (Button)findViewById(R.id.buttonTrain);
        buttonLearn.setOnClickListener(this);
        buttonTrain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLearn:
                startActivity(new Intent(SelectionActivity.this, LearnActivity.class));
            break;
            case R.id.buttonTrain:
                startActivity(new Intent(SelectionActivity.this, TrainSelectActivity.class));
                break;
            default:
                break;
        }

    }
}
