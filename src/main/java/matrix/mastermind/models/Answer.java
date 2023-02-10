package matrix.mastermind.models;

public class Answer {

    private String answer;

    public void setGuess(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
    public Answer(String g){
        this.answer = g;
    }


}
