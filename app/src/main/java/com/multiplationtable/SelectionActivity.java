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
import android.widget.RelativeLayout;

public class SelectionActivity extends AppCompatActivity  implements  View.OnClickListener{

    public static Bitmap[] readedBitmaps = new Bitmap[10];
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
        Button buttonLearn = (Button)findViewById(R.id.buttonLearn);
        Button buttonTrain = (Button)findViewById(R.id.buttonTrain);
        buttonLearn.setOnClickListener(this);
        buttonTrain.setOnClickListener(this);
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
}
