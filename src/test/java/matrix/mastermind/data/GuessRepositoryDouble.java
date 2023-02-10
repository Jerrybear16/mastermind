package matrix.mastermind.data;

import matrix.mastermind.models.Answer;

public class GuessRepositoryDouble implements GuessRepository {
    @Override
    public Answer saveGuess(Answer answer) {
        return answer;
    }
}
