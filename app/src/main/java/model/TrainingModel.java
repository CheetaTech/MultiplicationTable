package model;


import java.util.Observable;

public class TrainingModel extends Observable{

    private String keyboardNumber = null;
    private String totalKeyboardString = "";
    public TrainingModel(){
    }
    public void setKeyboardNumber(String keyboardNumber)
    {
        this.keyboardNumber = keyboardNumber;
    }

    public void addKeyboardNumber(String addKeyboard)
    {
        if(this.totalKeyboardString.length() >= 3)
            return;

        int value = Integer.parseInt(addKeyboard);
        int originalValue = -1;
        try {
            originalValue = Integer.parseInt(String.valueOf(this.totalKeyboardString.charAt(0)));
        }catch (StringIndexOutOfBoundsException e2)
        { }
        catch (NumberFormatException e)
        { }

        int length = getTotalKeyboardLength();
        if(length == 0)
        {
            if(value == 0)
            {
                if(originalValue == 0){}
                else{this.totalKeyboardString = "0";}
            }else{this.totalKeyboardString += addKeyboard;}
        }else{
            if(originalValue == 0)
            {}else{this.totalKeyboardString += addKeyboard;}
        }
        setChanged();
        notifyObservers();
    }
    public void deleteKeyboardNumber()
    {
        int length = this.totalKeyboardString.length();
        if(length==0)
            return;
        this.totalKeyboardString = this.totalKeyboardString.substring(0,length-1);
        setChanged();
        notifyObservers();
    }
    public String getTotalKeyboardString()
    {
        return this.totalKeyboardString;
    }
    public int getTotalKeyboardLength()
    {
        return this.totalKeyboardString.length();
    }
    public void clearKeyboard()
    {
        this.totalKeyboardString = "";
    }
}
