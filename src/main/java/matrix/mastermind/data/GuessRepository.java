package matrix.mastermind.data;

import matrix.mastermind.models.Answer;

public interface GuessRepository {

    Answer saveGuess(Answer answer);
}
