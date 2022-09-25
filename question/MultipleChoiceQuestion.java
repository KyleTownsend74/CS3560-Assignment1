package question;

public class MultipleChoiceQuestion extends Question {
    
    public MultipleChoiceQuestion(String question) {
        super(question);
    }

    public QType getQuestionType() {
        return QType.MULTIPLE_CHOICE;
    }

}
