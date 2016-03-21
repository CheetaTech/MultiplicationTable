package com.multiplationtable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

import model.TrainingModel;

public class TrainingActivity extends AppCompatActivity implements View.OnClickListener ,Observer{


    int[] keyboardButtonId = new int[]{ R.id.one_btn,
                                        R.id.two_btn,
                                        R.id.three_btn,
                                        R.id.four_btn,
                                        R.id.five_btn,
                                        R.id.six_btn,
                                        R.id.seven_btn,
                                        R.id.eight_btn,
                                        R.id.nine_btn,
                                        R.id.zero_btn,
                                        R.id.back_btn,
                                        R.id.done_btn
                                        };

    TextView answerText = null;
    TrainingModel trainingModel = null;

    /**
     * İkon olarak doğru ise drawable icindeki correct_image
     * yanlışlarda ise wrong_image imgesi kullanılacaktır.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_training);
        init();
    }

    private void init() {
        trainingModel = new TrainingModel();
        trainingModel.addObserver(this);

        for(int i = 0;i<keyboardButtonId.length;i++)
            ((Button)findViewById(keyboardButtonId[i])).setOnClickListener(this);
        ((ImageView)findViewById(R.id.backImageView)).setOnClickListener(this);
        answerText = (TextView)findViewById(R.id.answerText);
        answerText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.one_btn:
                trainingModel.addKeyboardNumber("1");
                break;
            case R.id.two_btn:
                trainingModel.addKeyboardNumber("2");
                break;
            case R.id.three_btn:
                trainingModel.addKeyboardNumber("3");
                break;
            case R.id.four_btn:
                trainingModel.addKeyboardNumber("4");
                break;
            case R.id.five_btn:
                trainingModel.addKeyboardNumber("5");
                break;
            case R.id.six_btn:
                trainingModel.addKeyboardNumber("6");
                break;
            case R.id.seven_btn:
                trainingModel.addKeyboardNumber("7");
                break;
            case R.id.eight_btn:
                trainingModel.addKeyboardNumber("8");
                break;
            case R.id.nine_btn:
                trainingModel.addKeyboardNumber("9");
                break;
            case R.id.zero_btn:
                trainingModel.addKeyboardNumber("0");
                break;

            case R.id.back_btn:
                trainingModel.deleteKeyboardNumber();
                break;
            case R.id.done_btn:

                break;
            case R.id.backImageView:
                    onBackPressed();
                break;
            default:

                break;
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        answerText.setText(trainingModel.getTotalKeyboardString());
    }
}
