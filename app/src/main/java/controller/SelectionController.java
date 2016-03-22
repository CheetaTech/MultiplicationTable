package controller;


import java.util.ArrayList;

public class SelectionController {

    private static SelectionController instance = null;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private SelectionController()
    {

    }
    public static SelectionController getInstance()
    {
        if(instance == null)
            instance = new SelectionController();
        return instance;
    }
    public void add(int buttonNumber)
    {
        if(list==null)
            list = new ArrayList<Integer>();
        list.add(buttonNumber);
    }
    public void clear()
    {
        if(list == null)
            list = new ArrayList<Integer>();
        this.list.clear();
    }
    public ArrayList<Integer> getNumberList()
    {
        return this.list;
    }

}
