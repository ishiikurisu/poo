import java.util.Scanner;

public class fat {
    public static long fatorial(long number) 
    {
        if (number <= 1) 
            return 1;
        
        for (long i = number - 1; i != 1; --i) 
            number *= i;

        return number;
    }

    public static final void main(String args[]) 
    {
        Scanner input = new Scanner(System.in);
        long number;

        number = input.nextLong();
        while (number >= 0)
        {
            System.out.println(fatorial(number));
            number = input.nextLong();
        } 
    }
}
