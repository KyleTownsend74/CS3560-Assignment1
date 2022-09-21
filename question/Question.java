package question;

import java.util.ArrayList;
import java.util.List;

public class Question implements IQuestion {

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
