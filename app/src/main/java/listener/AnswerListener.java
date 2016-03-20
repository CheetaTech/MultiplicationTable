package listener;

/**
 * Created by Erkan on 20.03.2016.
 */
public interface AnswerListener {
    /**
     * The method is called by TrainingController to show correct answer
     * */

    public void onCorrectAnswer();

    /**
     * The method is called by TrainingController to show correct answer
     * */

    public void onWrongAnswer();
}
