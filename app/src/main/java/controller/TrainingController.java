package controller;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.multiplationtable.R;
import com.multiplationtable.TrainingActivity;

import java.util.ArrayList;

import model.TrainingModel;

public class TrainingController {

    public interface OnQuestionAskingListener{
        void OnCorrectAnswer(Bitmap correctBitmap);
        void OnWrongAnswer(Bitmap wrongBitmap);
        void OnQuestion(String message);
    }

    private int firstInt =1 ;
    private int secondInt = 2;
    private int responseInt;
    Bitmap correctBitmap,wrongBitmap;
    private OnQuestionAskingListener listener = null;

    private ArrayList<Integer> list = new ArrayList<Integer>();
    private TrainingModel trainingModel = null;
    public TrainingController()
    {
        trainingModel = new TrainingModel();
    }
    public TrainingController(Context context)
    {
        trainingModel = new TrainingModel();
        correctBitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.correct_image);
        wrongBitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.wrong_image);
    }

    public void addNumber(String number)
    {
        this.trainingModel.addKeyboardNumber(number);
    }
    public void setListener(final OnQuestionAskingListener listener)
    {
        this.listener = listener;
    }

    public void setSelectedList(ArrayList<Integer> list)
    {
        this.list = list;
    }

    public void askQuestion()
    {
        this.firstInt += 1 ;
        this.secondInt += 1 ;
        this.responseInt = this.firstInt * this.secondInt;
        listener.OnQuestion(String.valueOf(this.firstInt)+" x "+this.secondInt+" = ?");
    }

    public void doneControl(String answer)
    {
        int val = Integer.parseInt(answer);
        if(val == responseInt)
        {
            Log.e("RESPONSE","Cevap Doğrudur.");
            listener.OnCorrectAnswer(correctBitmap);
        }else{
            Log.e("RESPONSE","Cevap Yanlıştır");
            listener.OnWrongAnswer(wrongBitmap);
        }
        // burada son sorulan sorunun cevabı ile karşılaştırılacak
    }

    public Bitmap getCorrectBitmap()
    {
        return this.correctBitmap;
    }
    public Bitmap getWrongBitmap()
    {
        return this.wrongBitmap;
    }

}
