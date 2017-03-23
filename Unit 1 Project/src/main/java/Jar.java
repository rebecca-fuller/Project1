import java.util.Random;
import java.util.Scanner;

public class Jar {
  Scanner scanner = new Scanner(System.in);
  Random random = new Random();
  
  public String item;
  public int jarMax;
  private int guess;
  public boolean isWon = false;
  private int number;
  private int turns = 0;
  public int randInt = 0;
  private String message;
  
  public Jar(String item, int jarMax) {
    this.item = item;
    this.jarMax = jarMax;
  }
  
  public void fill() {
    while (randInt == 0) {
      randInt = random.nextInt(jarMax); 
    }
    System.out.println("-----------------------------------------------");
    System.out.println("-------------------Let's Play------------------");  
    System.out.println("-----------------------------------------------");    
  }
  
  //Get users guess and test it//
  public void guess() {
    System.out.printf("How many %s are in the jar? Guess a number between 1 & %d:  ", item, jarMax);
    guess = scanner.nextInt(); 
    normalizeGuess(guess);
  }
  
  public int normalizeGuess(int guess) {
    if (guess > jarMax) {
      throw new IllegalArgumentException("Your guess must be less then %d" + jarMax);
    } else {
      isWon();  
    }
    return guess;
  }
  
  //Test if its won, if not print message and prompt for guess again//
  public void isWon() {
    message = "";
    turns++;
    if (guess == randInt) {
      System.out.printf("You won! You got it in %d attempt(s)%n", turns);
      isWon = true;  
    } else {
      if (guess > randInt) {
        message = "Your guess is to high. ";    
      } else {
        message = "Your guess is to low. ";  
      }
    
    System.out.println(message + "Try again.");  
    }
  }
}
 
