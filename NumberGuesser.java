import java.util.*;
class NumberGuesser {

  public static void guessingGame() {
    int lower; // lower limit for range of numbers
    int upper; // upper limit for range of numbers
    Scanner s = new Scanner(System.in);

    System.out.println("Enter max number of chances: "); // max number of chances allowed to guess the number
    int numChances = s.nextInt();
    System.out.println("Enter lower limit: ");
    lower = s.nextInt();

    // ensure upper limit provided by player is not less than lower limit
    do {
      System.out.println("Enter a valid upper limit: ");
      upper = s.nextInt();
    } while (upper < lower);

    // generate true value of number that will be guessed
    Random r = new Random();
    int trueNumber = r.nextInt(upper - lower + 1) + lower;
    int guess = 0;

    System.out.println("You have " + numChances + " chances to guess a number between " + lower + " and " + upper +".");

    // check if player's guess is correct
    for (int i = 0; i < numChances; i++) {
      System.out.println("Guess the number: ");
      guess = s.nextInt();
      if (guess == trueNumber) {
        System.out.println("Your guess is correct!");
        break;
      }
      else if (guess < trueNumber && i != numChances - 1) {
        System.out.println("Your guess is too low.");
      }
      else if (guess > trueNumber && i != numChances - 1) {
        System.out.println("Your guess is too high.");
      }
      else {
        System.out.println("You have run out of chances. The number was " + trueNumber);
      }
    }
  }

  public static void main (String args[]) {
    boolean playNewGame = false;
    Scanner sc = new Scanner(System.in);

    // start the game and continue if player wants to play again
    do {
      guessingGame();
      System.out.println("Play again? Y/N: ");
      char ans = sc.next().charAt(0);
      ans = Character.toLowerCase(ans);
      playNewGame = (ans == 'y') ? true : false;
    } while(playNewGame);
  }
}
