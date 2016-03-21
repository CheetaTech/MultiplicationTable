package controller;


import model.TrainingModel;

public class TrainingController {

    private TrainingModel trainingModel = null;
    public TrainingController()
    {
        trainingModel = new TrainingModel();
    }

    public void addNumber(String number)
    {
        this.trainingModel.addKeyboardNumber(number);
    }
}
