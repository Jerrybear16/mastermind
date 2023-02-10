package matrix.mastermind.domain;

import matrix.mastermind.data.GuessRepository;
import matrix.mastermind.models.Answer;
import matrix.mastermind.models.GuessResponse;
import org.springframework.stereotype.Service;

@Service
public class GuessService {

    private final GuessRepository repository;

    public GuessService(GuessRepository repository) {
        this.repository = repository;
    }

    public GuessResponse checkAnswer(Answer guess,Answer answer){
        GuessResponse response = null;

        return response;
    }
}
