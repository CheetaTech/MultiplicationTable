package com.multiplationtable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class SelectionActivity extends AppCompatActivity  implements  View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    public static Bitmap[] readedBitmaps = new Bitmap[10];
    public static boolean voiceState = true; // if true voice on - else voice off
    // bitmapleri okumak için kullanildi
    int[] imageSource = new int[]{
            R.drawable.ggfirst2,
            R.drawable.ggsecond,
            R.drawable.ggthird,
            R.drawable.ggfourth,
            R.drawable.ggfifth,
            R.drawable.ggsixth,
            R.drawable.ggseventh,
            R.drawable.ggeigth,
            R.drawable.ggninth,
            R.drawable.ggtenth
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selection);
        readBitmaps();
        ((Button)findViewById(R.id.buttonLearn)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonTrain)).setOnClickListener(this);
        ((ToggleButton)findViewById(R.id.voiceButton)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
      }

    private void readBitmaps() {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        for (int i = 0;i<readedBitmaps.length;i++)
            readedBitmaps[i] = BitmapFactory.decodeResource(getApplicationContext().getResources(),imageSource[i],options);
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.voiceButton:
                if (isChecked){
                    voiceState = false;
                    System.err.println("IsChecked");
                }
                else{
                    voiceState = true;
                    System.err.println("Not Checked");
                }
                break;
            default:
                break;
        }
    }
}
