import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("What type of item is in the jar?  ");
      String item = scanner.nextLine();
      
      System.out.printf("What is the maximum number of %s that fit in the jar? ", item);
      int jarMax = scanner.nextInt();
      
      Jar jar = new Jar(item, jarMax);
      
      jar.fill();
      
      while (!jar.isWon) {
        jar.guess();
      }
   }
}