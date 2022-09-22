package vote;

import java.util.HashMap;
import java.util.Map;

import question.IQuestion;
import student.IStudent;

public class VoteService implements IVoteService {
    
    private IQuestion curQuestion;
    private int[] answerSubmissions;
    private Map<Integer, Integer> submittedStudents;

    public VoteService(IQuestion curQuestion) {
        this.curQuestion = curQuestion;
        answerSubmissions = new int[curQuestion.getAnswers().length];
        submittedStudents = new HashMap<>();
    }

    @Override
    public void setCurQuestion(IQuestion curQuestion) {
        this.curQuestion = curQuestion;
    }

    // Returns true if answer successfully submitted, false otherwise
    @Override
    public boolean submitAnswer(IStudent student, int answerNum) {
        if(answerNum >= 0 && answerNum < answerSubmissions.length) {
            // If the student already submitted an answer, get rid of the old submission
            if(submittedStudents.containsKey(student.getId())) {
                answerSubmissions[submittedStudents.get(student.getId())]--;
            }
            
            answerSubmissions[answerNum]++;
            submittedStudents.put(student.getId(), answerNum);
            
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
