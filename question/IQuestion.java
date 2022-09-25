package question;

import question.Question.QType;

public interface IQuestion {
    
    public void setQuestion(String question);
    public String getQuestion();
    public void addAnswer(String answer);
    public String[] getAnswers();
    public QType getQuestionType();

}
