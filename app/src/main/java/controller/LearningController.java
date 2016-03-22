package controller;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.multiplationtable.R;

public class LearningController {

    public interface OnSelectedImage{
        void OnSelected(Bitmap bitmap);
    }

    private Context context = null;
    Bitmap[] images = new Bitmap[10];
    int[] imageSource = new int[]{
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
            R.drawable.fifth,
            R.drawable.sixth,
            R.drawable.seventh,
            R.drawable.eighth,
            R.drawable.ninth,
            R.drawable.tenth
    };

    private OnSelectedImage onSelectedImage = null;

    public LearningController()
    {
        //BitmapFactory.decodeResource(context.getResources(),R.drawable.wrong_image);
    }
    public LearningController(Context context)
    {
        this.context = context;
        for (int i = 0;i<images.length;i++)
            images[i] = BitmapFactory.decodeResource(context.getResources(),imageSource[i]);

    }
    public void setListener(final OnSelectedImage selectedImage)
    {
        this.onSelectedImage = selectedImage;
    }
    public void setImage(int index)
    {
        if(images == null)
            return;
        if(onSelectedImage == null)
            return;
        onSelectedImage.OnSelected(images[index]);
    }
}
