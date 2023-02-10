package matrix.mastermind.models;

public class GuessResponse {

    private boolean isCorrect;
    private String clue;

    public GuessResponse(){
        this.clue = null;
        this.isCorrect = false;
    }
    public GuessResponse(boolean isCorrect, String clue) {
        this.isCorrect = isCorrect;
        this.clue = clue;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
}
