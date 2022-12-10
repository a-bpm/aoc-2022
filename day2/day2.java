import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Day2
{
    final static char ENEMY_ROCK = 'A';
    final static char ROCK = 'X';
    final static int ROCK_VALUE = 1;

    final static char ENEMY_PAPER = 'B';
    final static char PAPER = 'Y';
    final static int PAPER_VALUE = 2;
    
    final static char ENEMY_SCISSORS = 'C';
    final static char SCISSORS = 'Z';
    final static int SCISSORS_VALUE = 3;

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
        int cheatTotal = 0;
        String temp = "";
        
        while (scanner.hasNextLine())
        {
            temp = scanner.nextLine();

            pointTotal += rps(temp.charAt(0),temp.charAt(2));
            cheatTotal += rpsPerfect(temp.charAt(0), temp.charAt(2));
        }
        
        System.out.println("Point total: " + pointTotal);
        System.out.println("Cheat total: " + cheatTotal);
        scanner.close();
    }

    static int rps(char enemy, char me)
    {
        int roundValue = 0;
        int pickValue = getPickValue(me);

        if (enemy+ENEMY_OFFSET == me+MY_OFFSET) // draw
        {
            roundValue += DRAW + pickValue;
        }
        else if (enemy+ENEMY_OFFSET == me+MY_OFFSET+1 || enemy+ENEMY_OFFSET == me+MY_OFFSET-2) // loss
        {
            roundValue += LOSS + pickValue; 
        }
        else // win
        {
            roundValue += WIN + pickValue;
        }
        return roundValue;
    }

    static int rpsPerfect(char enemy, char me)
    {
        int roundValue = 0;
        if (me == ROCK) // Lose
        {
            roundValue = forceLose(enemy, me);
        }
        else if (me == PAPER) // draw
        {
            roundValue = forceDraw(enemy, me); 
        }
        else if(me == SCISSORS) // win
        {
            roundValue = forceWin(enemy, me);
        }
        return roundValue;
    }

    static int forceWin(char enemy, char me)
    {
        int cheatScore = 0;

        if (enemy == ENEMY_PAPER)
        {
            cheatScore = rps(enemy, SCISSORS);
        }
        else if (enemy == ENEMY_SCISSORS)
        {
            cheatScore = rps(enemy, ROCK);
        }
        else 
        {
            cheatScore = rps(enemy, PAPER);
        }
        return cheatScore;
    }

    static int forceLose(char enemy, char me)
    {
        int cheatScore = 0;

        if (enemy == ENEMY_PAPER)
        {
            cheatScore = rps(enemy, ROCK);
        }
        else if (enemy == ENEMY_SCISSORS)
        {
            cheatScore = rps(enemy, PAPER);
        }
        else 
        {
            cheatScore = rps(enemy, SCISSORS);
        }
        return cheatScore;
    }
    
    static int forceDraw(char enemy, char me)
    {
        int cheatScore = 0;

        if (enemy == ENEMY_PAPER)
        {
            cheatScore = rps(enemy, PAPER);
        }
        else if (enemy == ENEMY_SCISSORS)
        {
            cheatScore = rps(enemy, SCISSORS);
        }
        else 
        {
            cheatScore = rps(enemy, ROCK);
        }
        return cheatScore;
    }

    static int getPickValue(char choice)
    {
        int pickValue = 0;
        if (choice == ROCK)
        {
            pickValue = ROCK_VALUE;
        }
        else if (choice == PAPER)
        {
            pickValue = PAPER_VALUE;
        }
        else 
        {
            pickValue = SCISSORS_VALUE;
        }
        return pickValue;
    }
}