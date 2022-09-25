package question;

import java.util.ArrayList;
import java.util.List;

public abstract class Question implements IQuestion {

    public enum QType {
        SINGLE_CHOICE, MULTIPLE_CHOICE
    }

    private String question;
    private List<String> answers;

    public Question(String question) {
        this.question = question;
        answers = new ArrayList<>();
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    @Override
    public String[] getAnswers() {
        return answers.toArray(new String[answers.size()]);
    }
    
}
