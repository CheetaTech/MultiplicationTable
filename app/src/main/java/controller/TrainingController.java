package controller;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.multiplationtable.R;
import com.multiplationtable.TrainingActivity;

import java.util.ArrayList;
import java.util.Random;

import model.TrainingModel;

public class TrainingController {

    public interface OnQuestionAskingListener{
        void OnCorrectAnswer(Bitmap correctBitmap,int correctValScore);
        void OnWrongAnswer(Bitmap wrongBitmap,int wrongValScore);
        void OnQuestion(String message);
    }

    private Random random = null;
    private int firstInt =1 ;
    private int secondInt = 2;
    private int responseInt;
    Bitmap correctBitmap,wrongBitmap;
    private int correctValueScore = 0,wrongValueScore =0;
    private OnQuestionAskingListener listener = null;
    private int holdValue = -1;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private TrainingModel trainingModel = null;
    public TrainingController()
    {
        trainingModel = new TrainingModel();
        random = new Random();
        correctValueScore = 0;
        wrongValueScore = 0;
    }
    public TrainingController(Context context)
    {
        trainingModel = new TrainingModel();
        correctBitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.correct_image);
        wrongBitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.wrong_image);

        random = new Random();
        correctValueScore = 0;
        wrongValueScore = 0;
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

        int listSize = list.size();
        int randomlistIndex = -1 ;
        Log.e("SIZE",""+listSize);
        if(listSize>0)
        {
            if(holdValue!=-1)
            {
                while (true)
                {
                    randomlistIndex = random.nextInt(listSize);
                    if(holdValue != randomlistIndex)
                        break;
                }
            }
            else
                randomlistIndex = random.nextInt(listSize);
        }
        else
            randomlistIndex = random.nextInt(listSize);

        this.firstInt = list.get(randomlistIndex);
        this.secondInt = random.nextInt(10)+1;

        this.responseInt = this.firstInt * this.secondInt;
        holdValue = this.firstInt;
        listener.OnQuestion(String.valueOf(this.firstInt)+" x "+this.secondInt+" = ?");
    }

    public void doneControl(String answer)
    {
        int val = -1;
        try {
            val = Integer.parseInt(answer);
        }catch (NumberFormatException e)
        {

        }

        if(val != -1) {
            if (val == responseInt) {
                Log.e("RESPONSE", "Cevap Doğrudur.");
                correctValueScore += 1;
                listener.OnCorrectAnswer(correctBitmap, correctValueScore);
            } else {
                Log.e("RESPONSE", "Cevap Yanlıştır");
                wrongValueScore += 1;
                listener.OnWrongAnswer(wrongBitmap, wrongValueScore);
            }
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

    public int getCorrectValueScore()
    {
        return this.correctValueScore;
    }
    public int getWrongValueScore()
    {
        return this.wrongValueScore;
    }
    public String getCorrectStringValue()
    {
        return String.valueOf(this.firstInt)+" x "+String.valueOf(this.secondInt)+" = "+String.valueOf(this.responseInt);
    }
}
