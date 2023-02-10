# Mastermind

## Architecture

    * 3 Layer Architecture
        * Data
        * Domain
        * MVC UI

## Design

    * On start-up, application should randomly generate the code.
        * Code is 4 characters of numbers 1-6
    * Domain Rules
        * User gets 12 guesses
        * Guesses must be 4 characters exactly
        * Guesses cannot include non-numbers or numbers outside the range 1-6
    * MVC UI
        * Display a welcome message, explain the rules of the game/how to play, and prompt the user to begin making guesses
        * Call the domain service for validation and a response
        * On an incorrect answer, say "incorrect" and display +'s and -'s as specified by the requirements
        * If no number or position is correct, display nothing.
        * promt user to continue guessing until they win or are out of guesses.
        * display win or lose message as specified by the requirements.
        * At the end of the game prompt the user to either play again or exit the application.
    * Domain Service
        * CheckGuess method which validates the answer and checks it for correctness
            * returns a GuessResponse
    * Models
        * Guess
            * Class which defines the data and functionality of a player Guess
            * String answer stores the player's answer as a string
        * GuessResponse
            * class which defines data and functionality of the response to a player answer
            * isCorrect boolean
            * String clue is populated based on the number of correct numbers and their correct or incorrect positions

## Follow-Ups

    * Is Persistence an expectation from the Product?
        * Should you be able to save games?
        * Save player data like win-loss record?
    * Are there any User experience features needed?
        * An option to display all previous guesses?
        * Display number of guesses remaining after each incorrect answer?
        * Display something when the answer contains contains no correct characters or positions?
    * What kind of data should the application be keeping track of?
        * do we need a backlog of the guesses so far?
        