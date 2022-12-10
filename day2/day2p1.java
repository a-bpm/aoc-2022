import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Day2
{
    final static char ROCK = 'X';
    final static int ROCK_VALUE = 1;

    final static char PAPER = 'Y';
    final static int PAPER_VALUE = 2;
    
    final static char SCISSORS = 'Z';
    final static int SCIRSSORS_VALUE = 3;

    final static int ENEMY_OFFSET = 11;
    final static int MY_OFFSET = -12;

    final static int LOSS = 0;
    final static int DRAW = 3;
    final static int WIN = 6;
    public static void main (String[] args) throws FileNotFoundException
    {
        File inputFile = new File("day2Input.txt");
        Scanner scanner = new Scanner(inputFile);

        int pointTotal = 0;
        String temp = "";
        
        while (scanner.hasNextLine())
        {
            temp = scanner.nextLine();

            pointTotal += rps(temp.charAt(0),temp.charAt(2));
        }
        
        System.out.println(pointTotal);
    }

    static int rps(char enemy, char me)
    {
        int roundValue = 0;
        int pickValue = getPickValue(me);

        if (enemy+ENEMY_OFFSET == me+MY_OFFSET) // draw
        {
            roundValue += DRAW + pickValue;
            System.out.println("Draw");
        }
        else if (enemy+ENEMY_OFFSET == me+MY_OFFSET+1 || enemy+ENEMY_OFFSET == me+MY_OFFSET-2) // loss
        {
            roundValue += LOSS + pickValue; 

            System.out.println("Loss");
        }
        else // win
        {
            roundValue += WIN + pickValue;

            System.out.println("Win");
        }
        System.out.println(roundValue);
        return roundValue;
    }

    static int getPickValue(char choice)
    {
        int pickValue = 0;
        if (choice == ROCK)
        {
            System.out.println("Picked rock");
            pickValue = ROCK_VALUE;
        }
        else if (choice == PAPER)
        {
            System.out.println("Picked paper");
            pickValue = PAPER_VALUE;
        }
        else 
        {
            System.out.println("Picked scissors");
            pickValue = SCIRSSORS_VALUE;
        }

        return pickValue;
    }
}