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

        // Print output from voting simulation
        System.out.println("+-------------------------------------------+\n");
        System.out.println("Voting simulation for the following question:");

        if(voteService.getCurQuestion().getQuestionType() == QType.SINGLE_CHOICE) {
            System.out.print("(Single Choice Question, ");
        }
        else {
            System.out.print("(Multiple Choice Question, ");
        }

        System.out.println(numStudents + " Students)\n");
        System.out.println(voteService.getQuestionInfo());
        System.out.println(voteService.getAnswerInfo());
        System.out.println("Vote totals for each answer:");
        System.out.println(voteService.getSubmissionInfo());
        System.out.println("+-------------------------------------------+\n");
    }

    public static void main(String[] args) {

        // Create single choice question with answers
        IQuestion singleQuestion = new SingleChoiceQuestion(
            "What is the current most popular programming language?");
        singleQuestion.addAnswer("Java");
        singleQuestion.addAnswer("C++");
        singleQuestion.addAnswer("Python");

        runSimulation(singleQuestion);

        // Create multiple choice question with answers
        IQuestion multipleQuestion = new MultipleChoiceQuestion(
            "Which of the following are valid statements in Java?");
        multipleQuestion.addAnswer("int x");
        multipleQuestion.addAnswer("int x;");
        multipleQuestion.addAnswer("int x = 0");
        multipleQuestion.addAnswer("int x = 0;");
        multipleQuestion.addAnswer("Integer x = 0;");

        runSimulation(multipleQuestion);

    }
}