package vote;

import question.IQuestion;

public class VoteService implements IVoteService {
    
    private IQuestion curQuestion;
    private int[] answerSubmissions;

    public VoteService(IQuestion curQuestion) {
        this.curQuestion = curQuestion;
        answerSubmissions = new int[curQuestion.getAnswers().length];
    }

    @Override
    public void setCurQuestion(IQuestion curQuestion) {
        this.curQuestion = curQuestion;
    }

    // Returns true if answer successfully submitted, false otherwise
    @Override
    public boolean submitAnswer(int answerNum) {
        if(answerNum >= 0 && answerNum < answerSubmissions.length) {
            answerSubmissions[answerNum]++;
            return true;
        }

        return false;
    }

    @Override
    public String getQuestionInfo() {
        return curQuestion.getQuestion();
    }

    @Override
    public String getSubmissionInfo() {
        String info = "";

        for(int i = 0; i < answerSubmissions.length; i++) {
            info += curQuestion.getAnswers()[i] + " : " + answerSubmissions[i] + "\n";
        }
        
        return info;
    }

}
