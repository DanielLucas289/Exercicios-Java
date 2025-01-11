import java.util.Scanner;

public class Finonacci {

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número");
        int number = scanner.nextInt();

        if (isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }


    public static boolean isFibonacci(int number) {
        if (number < 0) return false; 

        int a = 0; 
        int b = 1; 

        while (a <= number) {
            if (a == number) {
                return true; 
            }

            int next = a + b;
            a = b;
            b = next;
        }

        return false; 
    }
}
