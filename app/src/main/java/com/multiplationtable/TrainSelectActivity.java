package com.multiplationtable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import controller.SelectionController;
import controller.TrainingController;

public class TrainSelectActivity extends AppCompatActivity implements View.OnClickListener , CompoundButton.OnCheckedChangeListener{

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
            R.id.select_seven_btn,
            R.id.select_eight_btn,
            R.id.select_nine_btn,
            R.id.select_ten_btn
    };
    Button[] buttons = new Button[10];
    int[] buttonKontrolArray = new int[10]; // ilk deger ataması

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_train_select);
        init();
    }

    private void init() {
        for (int i = 0; i < trainingSelectButtonId.length; i++)
        {
            buttons[i] = ((ToggleButton) findViewById(trainingSelectButtonId[i]));
            ((ToggleButton)buttons[i]).setOnCheckedChangeListener(this);
        }
        ((Button) findViewById(R.id.buttonBack)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonStart)).setOnClickListener(this);

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
        SelectionController.getInstance().clear();
        for(int i = 0;i<buttons.length;i++)
        {
            if( ((ToggleButton)buttons[i]).isChecked() == false)
            {
                Log.e("TOGGLE","Button id si "+ (i+1));
                SelectionController.getInstance().add(i+1);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
