package vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import question.IQuestion;
import question.Question.QType;
import student.IStudent;

public class VoteService implements IVoteService {
    
    private IQuestion curQuestion;
    private int[] answerSubmissions;
    private Map<Integer, List<Integer>> submittedStudents;

    public VoteService(IQuestion curQuestion) {
        setCurQuestion(curQuestion);
    }

    @Override
    public void setCurQuestion(IQuestion curQuestion) {
        this.curQuestion = curQuestion;

        // Question is changed, so reset (or set up) the state of the VoteService
        answerSubmissions = new int[curQuestion.getAnswers().length];
        submittedStudents = new HashMap<>();
    }

    @Override
    public IQuestion getCurQuestion() {
        return curQuestion;
    }

    // Returns true if answer successfully submitted, false otherwise
    @Override
    public boolean submitAnswer(IStudent student, int... answerNums) {
        if(answerNums.length > 0) {
            // Keep track of answers checked while validating input
            List<Integer> answerNumsChecked = new ArrayList<>();

            // Validate input
            for(int curAnswerNum : answerNums) {
                if(curAnswerNum < 0 
                        || curAnswerNum >= answerSubmissions.length 
                        || answerNumsChecked.contains(curAnswerNum)) {

                    return false;
                }

                answerNumsChecked.add(curAnswerNum);
            }

            int studentId = student.getId();

            // If the student already submitted an answer, get rid of the old submission
            if(submittedStudents.containsKey(studentId)) {
                for(int curOldAnswer : submittedStudents.get(studentId)) {
                    answerSubmissions[curOldAnswer]--;
                }
            }
            
            // Submit the answers. If single choice question and multiple
            // answers were submitted, only use the first answer passed in
            if(curQuestion.getQuestionType() == QType.SINGLE_CHOICE) {
                answerSubmissions[answerNums[0]]++;
            }
            else {
                for(int curAnswerNum : answerNums) {
                    answerSubmissions[curAnswerNum]++;
                }
            }

            // Keep track of what answers the student submitted
            submittedStudents.put(studentId, answerNumsChecked);
            
            return true;
        }

        return false;
    }

    @Override
    public String getQuestionInfo() {
        return curQuestion.getQuestion();
    }

    @Override
    public String getAnswerInfo() {
        String info = "";
        char curChar = 'A';

        for(int i = 0; i < answerSubmissions.length; i++) {
            info += curChar++ + ". " + curQuestion.getAnswers()[i] + "\n";
        }
        
        return info;
    }

    @Override
    public String getSubmissionInfo() {
        String info = "";
        char curChar = 'A';

        for(int i = 0; i < answerSubmissions.length; i++) {
            info += curChar++ + " : " + answerSubmissions[i] + "\n";
        }
        
        return info;
    }

}
