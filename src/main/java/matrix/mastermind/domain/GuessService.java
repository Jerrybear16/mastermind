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
        GuessResponse response = new GuessResponse();


        if(guess.getAnswer().equals(answer.getAnswer())){
            response.setCorrect(true);
        }else{
            calculateCluedResponse(guess, answer, response);
        }

        return response;
    }

    private void calculateCluedResponse(Answer guess, Answer answer, GuessResponse response) {
        response.setCorrect(false);
        int correct=0;
        int inPosition=0;
        int outPosition=0;
        char c;
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i< guess.getAnswer().length(); i++){
            c= guess.getAnswer().charAt(i);
            if(!sb.toString().contains(String.valueOf(c))){
                sb.append(c);
                if(answer.getAnswer().contains(String.valueOf(c))){
                    correct+= getCharacterAppearances(c, guess, answer);
                }
            }
            if(guess.getAnswer().charAt(i) == answer.getAnswer().charAt(i)){
                inPosition++;
            }
        }
        outPosition = correct-inPosition;

        StringBuilder responseBuilder = new StringBuilder();

        for(int i=0;i<inPosition;i++){
            responseBuilder.append("+");
        }
        for(int i=0;i<outPosition;i++){
            responseBuilder.append("-");
        }
        response.setClue(responseBuilder.toString());
    }

    private int getCharacterAppearances(char c, Answer guess, Answer answer) {
        int guessAppearances=0;
        int answerAppearances=0;

        for(int i=0;i< guess.getAnswer().length();i++){
            if(guess.getAnswer().charAt(i) == c){
                guessAppearances++;
            }
        }

        for(int i=0;i< answer.getAnswer().length();i++){
            if(answer.getAnswer().charAt(i) == c){
                answerAppearances++;
            }
        }

        return Math.min(guessAppearances,answerAppearances);
    }

    private GuessResponse validate(Answer guess) {
        return null;
    }
}
