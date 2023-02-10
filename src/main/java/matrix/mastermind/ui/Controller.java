package matrix.mastermind.ui;

import matrix.mastermind.domain.GuessService;
import matrix.mastermind.models.Answer;
import matrix.mastermind.models.GuessResponse;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Controller {
    private final View view;
    private final GuessService service;

    public Controller(View view, GuessService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        try{
            runApp();
        }catch(Exception e){
            view.displayHeader("Something went Wrong :(");
        }
    }

    private void runApp() {
        view.displayHeader("Welcome to Mastermind");
        Answer code = generateCode();
        view.displayRules();

        int guesses = 12;
        boolean playing = true;
        Answer guess;
        GuessResponse response;
        do{
            guesses--;
            guess = view.getGuess();
            response = service.checkAnswer(guess,code);
            if(!response.isCorrect()&&guesses>0){
                view.displayClue(response.getClue());
            }else if(response.isCorrect()){
                view.displayWin();
                playing = false;
            }else if(!response.isCorrect()&&guesses<=0){
                view.displayLoss();
                playing = false;
            }

            if(!playing){
                view.displayEndgame();
                playing = view.getEndgameResponse();
                if(playing){
                    code = generateCode();
                    guesses=12;
                }
            }

        }while(playing);
        view.displayHeader("Goodbye!");

    }

    private Answer generateCode() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for(int i=0;i<4;i++){
            sb.append(String.valueOf(rand.nextInt(6)+1));
        }
        return new Answer(sb.toString());
    }
}
