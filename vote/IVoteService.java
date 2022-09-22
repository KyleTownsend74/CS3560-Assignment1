package vote;

import question.IQuestion;

public interface IVoteService {
    
    public void setCurQuestion(IQuestion question);
    public boolean submitAnswer(int answerNum);
    public String getQuestionInfo();
    public String getSubmissionInfo();

}
