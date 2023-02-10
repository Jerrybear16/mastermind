package matrix.mastermind.domain;

import matrix.mastermind.data.GuessRepositoryDouble;
import matrix.mastermind.models.Answer;
import matrix.mastermind.models.GuessResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessServiceTest {

    GuessService service = new GuessService(new GuessRepositoryDouble());

    @Test
    void checkAnswerShouldBeCorrect() {
        Answer guess = new Answer("1234");
        Answer answer = new Answer("1234");

        GuessResponse response = service.checkAnswer(guess,answer);

        assertNotNull(response);
        assertTrue(response.isCorrect());
        assertNull(response.getClue());
    }

    @Test
    void checkAnswerShouldBeIncorrectWithNoClue() {
        Answer guess = new Answer("5555");
        Answer answer = new Answer("1234");

        GuessResponse response = service.checkAnswer(guess,answer);

        assertNotNull(response);
        assertFalse(response.isCorrect());
        assertNull(response.getClue());
    }

    @Test
    void checkAnswerShouldHaveOneCorrectPosition(){
        Answer guess = new Answer("1555");
        Answer answer = new Answer("1234");

        GuessResponse response = service.checkAnswer(guess,answer);

        assertNotNull(response);
        assertFalse(response.isCorrect());
        assertNotNull(response.getClue());
        assertEquals(response.getClue().length(),1);
        assertEquals(response.getClue(),"+");
    }

    @Test
    void checkAnswerShouldHaveOneCorrectPositionAndOneCorrectOutOfPosition(){
        Answer guess = new Answer("1455");
        Answer answer = new Answer("1234");

        GuessResponse response = service.checkAnswer(guess,answer);

        assertNotNull(response);
        assertFalse(response.isCorrect());
        assertNotNull(response.getClue());
        assertEquals(response.getClue().length(),2);
        assertEquals(response.getClue(),"+-");
    }




}