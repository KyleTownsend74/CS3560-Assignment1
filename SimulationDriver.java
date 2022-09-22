import question.IQuestion;
import question.Question;
import vote.IVoteService;
import vote.VoteService;

public class SimulationDriver {

    public static void main(String[] args) {

        // TODO: Create question with answers
        IQuestion q1 = new Question("Question 1 Text");
        q1.addAnswer("A. Answer 1");
        q1.addAnswer("B. Answer 2");

        // TODO: Add question to service
        IVoteService voteService = new VoteService(q1);
        System.out.println(voteService.getQuestionInfo());
        voteService.submitAnswer(0);
        voteService.submitAnswer(1);
        voteService.submitAnswer(1);
        voteService.submitAnswer(1);
        System.out.println(voteService.getSubmissionInfo());

        // TODO: Randomly generate students and their answers

        // TODO: Submit answers to service

        // TODO: Call voting service output function

    }
}