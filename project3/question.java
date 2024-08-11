import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Question Class
class Question {
    private String prompt;
    private String[] options;
    private String answer;

    public Question(String prompt, String[] options, String answer) {
        this.prompt = prompt;
        this.options = options;
        this.answer = answer;
    }

    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}

// Quiz Class
class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int takeQuiz(List<String> answers) {
        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String userAnswer = answers.get(i);
            if (question.isCorrect(userAnswer)) {
                score++;
            }
        }
        return score;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

// QuizApp Class (Main Entry Point)
public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome"}, "Paris"));
        quiz.addQuestion(new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, "4"));

        List<String> answers = Arrays.asList("Paris", "4");
        int score = quiz.takeQuiz(answers);

        System.out.println("Your score: " + score + "/" + quiz.getQuestions().size());
    }
}

// JUnit5 Test Class
public class QuizAppTest {

    @Test
    public void testAddQuestion() {
        Quiz quiz = new Quiz();
        Question question = new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome"}, "Paris");
        quiz.addQuestion(question);

        assertEquals(1, quiz.getQuestions().size());
        assertEquals("What is the capital of France?", quiz.getQuestions().get(0).getPrompt());
    }

    @Test
    public void testTakeQuiz() {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome"}, "Paris"));
        quiz.addQuestion(new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, "4"));

        List<String> answers = Arrays.asList("Paris", "4");
        int score = quiz.takeQuiz(answers);

        assertEquals(2, score);  // Both answers are correct
    }

    @Test
    public void testCalculateScore() {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome"}, "Paris"));
        quiz.addQuestion(new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, "4"));

        List<String> answers = Arrays.asList("Paris", "5");  // One correct and one incorrect
        int score = quiz.takeQuiz(answers);

        assertEquals(1, score);  // Only one answer is correct
    }
}
