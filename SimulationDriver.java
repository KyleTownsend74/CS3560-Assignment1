import java.util.Random;

import question.IQuestion;
import question.MultipleChoiceQuestion;
import question.SingleChoiceQuestion;
import question.Question.QType;
import student.IStudent;
import student.Student;
import vote.IVoteService;
import vote.VoteService;

public class SimulationDriver {

    private static void runSimulation(IQuestion question) {
        // Add question to voting service
        IVoteService voteService = new VoteService(question);

        // Randomly generate students and their answers
        Random rand = new Random();
        int numStudents = rand.nextInt(15) + 20;
        int numPossibleAnswers = voteService.getCurQuestion().getAnswers().length;
        boolean isMultipleChoice = question.getQuestionType() == QType.MULTIPLE_CHOICE;

        for(int i = 0; i < numStudents; i++) {
            IStudent student = new Student();

            // If on a multiple choice question, randomly have students submit
            // multiple answers
            if(isMultipleChoice) {
                int[] answers = new int[rand.nextInt(numPossibleAnswers) + 1];

                for(int j = 0; j < answers.length; j++) {
                    answers[j] = rand.nextInt(numPossibleAnswers);
                }

                voteService.submitAnswer(student, answers);
            }
            else {
                voteService.submitAnswer(student, rand.nextInt(numPossibleAnswers));    
            }
        }

        // Get output from voting service
        System.out.println(voteService.getQuestionInfo());
        System.out.println(voteService.getSubmissionInfo());
    }

    public static void main(String[] args) {

        // Create single choice question with answers
        IQuestion singleQuestion = new SingleChoiceQuestion("Single Choice Question Text");
        singleQuestion.addAnswer("A. Answer 1");
        singleQuestion.addAnswer("B. Answer 2");
        singleQuestion.addAnswer("C. Answer 3");

        runSimulation(singleQuestion);

        // Create multiple choice question with answers
        IQuestion multipleQuestion = new MultipleChoiceQuestion("Multiple Choice Question Text");
        multipleQuestion.addAnswer("A. Answer 1");
        multipleQuestion.addAnswer("B. Answer 2");
        multipleQuestion.addAnswer("C. Answer 3");
        multipleQuestion.addAnswer("D. Answer 4");
        multipleQuestion.addAnswer("E. Answer 5");

        runSimulation(multipleQuestion);

    }
}