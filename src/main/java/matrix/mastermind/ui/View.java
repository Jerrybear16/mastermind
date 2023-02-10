package matrix.mastermind.ui;

import matrix.mastermind.models.Answer;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {

    private final Scanner console = new Scanner(System.in);

    public void displayHeader(String text) {
        displayText("");
        displayText(text);
        displayText("=".repeat(text.length()));
        displayText("");
    }

    public void displayRules(){
        displayText("Hello Codebreaker,");
        displayText("The Gamemaster has generated a Secret Code.");
        displayText("The code is 4 digits. Each digit is a number from 1-6.");
        displayText("You will enter guesses to try and break the code.");
        displayText("If your guess is incorrect you will be given a clue.");
        displayText("The Clue will contain a number of +'s and -'s.");
        displayText("A + indicates you have a correct number in the correct location.");
        displayText("A - indicates you have a correct number in the incorrect location.");
        displayText("Good luck!");
    }

    public Answer getGuess(){
        displayTextInline("Enter your Guess: ");

        Answer guess = new Answer(readString());

        return guess;
    }

    public void displayClue(String clue){
        displayText("Incorrect. Here's your clue: "+clue);
    }

    public void displayLoss(){
        displayText("You lose :(");
    }

    public void displayEndgame(){
        displayText("Enter \"Exit\" to end the game");
        displayText("Enter \"New Game\" to try a new code");
    }

    public boolean getEndgameResponse(){
        String response = readRequiredString();
        if(response.equals("Exit")){
            return false;
        }else if(response.equals("New Game")){
            return true;
        }
        return false;
    }

    private String readRequiredString() {
        while (true){
            String value = readString();
            if(value.equals("Exit")||value.equals("New Game")){
                return value;
            }else{
                displayText("Enter a valid answer");
            }
        }
    }

    public String readString(){
        return console.nextLine();
    }

    private void displayText(String s) {
        System.out.println(s);
    }

    private void displayTextInline(String text) {
        System.out.print(text);
    }

    public void displayWin() {
        displayText("You solved it!");
    }
}
