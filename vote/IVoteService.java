package vote;

import question.IQuestion;
import student.IStudent;

public interface IVoteService {
    
    public void setCurQuestion(IQuestion question);
    public boolean submitAnswer(IStudent student, int... answerNums);
    public String getQuestionInfo();
    public String getSubmissionInfo();

}
