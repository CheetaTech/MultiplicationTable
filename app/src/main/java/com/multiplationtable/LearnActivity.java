package com.multiplationtable;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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

        final LinearLayout myLayout = (LinearLayout) findViewById(R.id.showMath);
        myLayout.post(new Runnable() {

            @Override
            public void run() {
                //controller.setLinearLayoutParams((LinearLayout.LayoutParams) myLayout.getLayoutParams());
                controller.setLinearLayoutParams(myLayout.getHeight(), myLayout.getWidth());
                Log.i("TEST", "Layout width : " + myLayout.getHeight() + " :: " + myLayout.getWidth());
                if(myLayout.getHeight() > 0 && myLayout.getWidth() > 0)
                    controller.setResizedImage(0);
            }
        });



//        final LinearLayout myLayout2 = (LinearLayout) findViewById(R.id.secondLineLinearLayout);
//        myLayout2.post(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.i("TEST", "Layout width2 : " + myLayout2.getHeight() + " :: "+ myLayout2.getWidth());
//
//            }
//        });

//
//        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);
//
//        //LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) relativeLayout.getChildAt(6).getLayoutParams();
//
////        LinearLayout layout = (LinearLayout)findViewById(R.id.showMath);
////        System.err.println("NOT: "+ relativeLayout.getChildCount() + " : "+layout.getHeight() + " : "+ layout.getWidth());
//          System.err.println("NOT: " + relativeLayout.getChildAt(6).getWidth() + " : " + relativeLayout.getChildAt(6).getWidth());
//        ViewGroup.LayoutParams params = relativeLayout.getChildAt(6).getLayoutParams();
//        System.err.println("NOT2: " + params.width + " : " + params.height);


    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        super.onCreateView(inflater,container,savedInstanceState);
//        View view = inflater.inflate(R.layout.content_learn, container, false);
//        return view;
//    }

    @Override
    public void onResume()
    {
        super.onResume();
        System.out.println("PEKER");

        //RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);

        //LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) relativeLayout.getChildAt(6).getLayoutParams();
//
//        LinearLayout layout = (LinearLayout)findViewById(R.id.showMath);
////        System.err.println("NOT: "+ relativeLayout.getChildCount() + " : "+layout.getHeight() + " : "+ layout.getWidth());
//        //System.err.println("NOT: " + relativeLayout.getChildAt(6).getWidth() + " : " + relativeLayout.getChildAt(6).getWidth());
//        //ViewGroup.LayoutParams params = relativeLayout.getChildAt(6).getLayoutParams();
//        System.err.println("NOT2: " + layout.getWidth() + " :: " + layout.getLayoutParams().width + " : " + layout.getLayoutParams().height + " :: "
//        + layout.getHeight()
//        );
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backImageViewLearn)
            onBackPressed();
        for(int i = 0;i<learnButtons.length;i++)
        {
            if(v.getId() == learnButtons[i])
            {
//                controller.setImage(i);
                controller.setResizedImage(i);
                break;
            }
        }
    }

    @Override
    public void OnSelected(Bitmap bitmap) {
        ((ImageView)findViewById(R.id.learnImageView)).setImageBitmap(bitmap);
    }
}
