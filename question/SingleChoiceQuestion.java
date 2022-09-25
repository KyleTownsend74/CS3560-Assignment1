package question;

public class SingleChoiceQuestion extends Question {
    
    public SingleChoiceQuestion(String question) {
        super(question);
    }

    public QType getQuestionType() {
        return QType.SINGLE_CHOICE;
    }

}
