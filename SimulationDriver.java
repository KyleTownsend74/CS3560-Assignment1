import question.IQuestion;
import question.Question;

public class SimulationDriver {

    public static void main(String[] args) {

        // TODO: Create question with answers
        IQuestion q1 = new Question("Question 1 Text");
        q1.addAnswer("A. Answer 1");
        q1.addAnswer("B. Answer 2");

        System.out.println(q1.getQuestion());
        System.out.println(q1.getAnswers().length);
        System.out.println(q1.getAnswers()[0]);
        System.out.println(q1.getAnswers()[1]);

        // TODO: Add question to service

        // TODO: Randomly generate students and their answers

        // TODO: Submit answers to service

        // TODO: Call voting service output function

    }
}