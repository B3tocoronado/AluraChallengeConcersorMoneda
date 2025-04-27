import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("what is your name? ");
        String name = scanner.nextLine();
        System.out.println("What is your number? ");
        int number = scanner.nextInt();

        System.out.println("Your name is "+name + " your number is "+ number);
    }





}