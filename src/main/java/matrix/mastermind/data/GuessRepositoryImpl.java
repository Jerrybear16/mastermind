package matrix.mastermind.data;

import matrix.mastermind.models.Answer;
import org.springframework.stereotype.Repository;

@Repository
public class GuessRepositoryImpl implements GuessRepository {
    @Override
    public Answer saveGuess(Answer answer) {
        return answer;
    }
}
