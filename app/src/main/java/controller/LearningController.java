package controller;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.widget.LinearLayout;

import com.multiplationtable.R;

public class LearningController {

    public interface OnSelectedImage{
        void OnSelected(Bitmap bitmap);
    }
    private LinearLayout.LayoutParams layoutParams = null;

    private Context context = null;
    Bitmap[] images = new Bitmap[10];
    Bitmap[] resizedImages = new Bitmap[10];
    private int layoutWidth = -1, layoutHeigth = -1;
    int[] imageSource = new int[]{
            R.drawable.pfirst,
            R.drawable.psecond,
            R.drawable.pthird,
            R.drawable.pfourth,
            R.drawable.pfive,
            R.drawable.psixth,
            R.drawable.pseventh,
            R.drawable.peigth,
            R.drawable.pninth,
            R.drawable.ptenth
    };
//    int[] imageSource = new int[]{
//            R.drawable.gnew1,
//            R.drawable.gnu1,
//            R.drawable.third,
//            R.drawable.fourth,
//            R.drawable.fifth,
//            R.drawable.sixth,
//            R.drawable.seventh,
//            R.drawable.eighth,
//            R.drawable.ninth,
//            R.drawable.tenth
//    };

    private OnSelectedImage onSelectedImage = null;

    public LearningController()
    {
        //BitmapFactory.decodeResource(context.getResources(),R.drawable.wrong_image);
    }
    public LearningController(Context context)
    {
        this.context = context;

        for (int i = 0;i<images.length;i++)
        {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 0;
            //Bitmap bitmap = BitmapFactory.decodeFile(path,options);
            images[i] = BitmapFactory.decodeResource(context.getResources(),imageSource[i],options);

        }
        if(this.layoutParams == null)
            return;
        for (int i = 0;i<images.length;i++)
            resizedImages[i] = getResizedBitmap(images[i],this.layoutHeigth,this.layoutWidth);

            //resizedImages[i] = getResizedBitmap(images[i],layoutParams.height,layoutParams.width);


//        this.context = context;
//        if(this.layoutParams == null)
//            return;
//        for (int i = 0;i<images.length;i++)
//            images[i] = BitmapFactory.decodeResource(context.getResources(),imageSource[i]);
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
        if(layoutParams == null)
            return;
        onSelectedImage.OnSelected(images[index]);
    }

    public void setResizedImage(int index)
    {

        if(images == null)
            return;
        if(onSelectedImage == null)
            return;
        if(this.layoutHeigth == -1)
            return;
        if(this.layoutWidth == -1)
            return;
        onSelectedImage.OnSelected(resizedImages[index]);

//        if(images == null)
//            return;
//        if(onSelectedImage == null)
//            return;
//        if(layoutParams == null)
//            return;
//        onSelectedImage.OnSelected(resizedImages[index]);
    }
    public void setLinearLayoutParams(LinearLayout.LayoutParams params)
    {
        this.layoutParams = params;
        if(this.layoutParams == null)
            return;
        for (int i = 0;i<images.length;i++)
            resizedImages[i] = getResizedBitmap(images[i],layoutParams.height,layoutParams.width);
    }
    public void setLinearLayoutParams(int resizedHeight, int resizedWidth)
    {
        this.layoutHeigth = resizedHeight;
        this.layoutWidth = resizedWidth;
        if(this.layoutHeigth == -1)
            return;
        if(this.layoutWidth == -1)
            return;
        for (int i = 0;i<images.length;i++)
            resizedImages[i] = getResizedBitmap(images[i],this.layoutHeigth,this.layoutWidth);
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
}
