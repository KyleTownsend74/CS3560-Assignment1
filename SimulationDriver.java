import question.IQuestion;
import question.MultipleChoiceQuestion;
import question.SingleChoiceQuestion;
import student.IStudent;
import student.Student;
import vote.IVoteService;
import vote.VoteService;

public class SimulationDriver {

    public static void main(String[] args) {

        // TODO: Create question with answers
        IQuestion q1 = new SingleChoiceQuestion("Question 1 Text");
        q1.addAnswer("A. Answer 1");
        q1.addAnswer("B. Answer 2");

        // TODO: Add question to service
        IVoteService voteService = new VoteService(q1);
        System.out.println(voteService.getQuestionInfo());

        // TODO: Randomly generate students and their answers
        IStudent s1 = new Student();
        IStudent s2 = new Student();
        voteService.submitAnswer(s1, 0);
        voteService.submitAnswer(s2, 0);
        System.out.println(voteService.getSubmissionInfo());

        IQuestion q2 = new MultipleChoiceQuestion("Question 2 Text");
        q2.addAnswer("A. Answer 1");
        q2.addAnswer("B. Answer 2");
        q2.addAnswer("C. Answer 3");
        voteService.setCurQuestion(q2);
        System.out.println(voteService.getQuestionInfo());
        voteService.submitAnswer(s1, 0, 1);
        voteService.submitAnswer(s2, 1, 2);
        System.out.println(voteService.getSubmissionInfo());

        // TODO: Submit answers to service

        // TODO: Call voting service output function

    }
}