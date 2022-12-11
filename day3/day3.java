import java.util.*;
import java.io.*;


class Day3 {

    static final int LOWER_OFFSET = -96;
    static final int UPPER_OFFSET = -38;


    public static void main (String [] args) throws FileNotFoundException
    {
        File inputFile = new File("day3input.txt");
        Scanner fileScanner = new Scanner(inputFile);
        HashSet<Character> firstRuckSet = new HashSet<Character>();
        HashSet<Character> secondRuckSet = new HashSet<Character>();
        
        String temp; 
        int halfway;
        int priorityTotal = 0;
        int prioGroupTotal = 0;
        while(fileScanner.hasNextLine())
        {
            temp = fileScanner.nextLine();
            halfway = temp.length()/2;

            firstRuckSet = populate(temp.substring(0, halfway));
            secondRuckSet = populate(temp.substring(halfway));
            firstRuckSet.retainAll(secondRuckSet);

            char currChar = firstRuckSet.toString().charAt(1);
            priorityTotal += getPrio(currChar);

            firstRuckSet.clear();
            secondRuckSet.clear();
        }

        fileScanner.close(); 
        fileScanner = new Scanner(inputFile);

        HashSet<Character> p1RuckSet = new HashSet<Character>();
        HashSet<Character> p2RuckSet = new HashSet<Character>();
        HashSet<Character> p3RuckSet = new HashSet<Character>();

        while (fileScanner.hasNextLine())
        {
            p1RuckSet = populate(fileScanner.nextLine());
            p2RuckSet = populate(fileScanner.nextLine());
            p3RuckSet = populate(fileScanner.nextLine());
       
            p1RuckSet.retainAll(p2RuckSet);
            p1RuckSet.retainAll(p3RuckSet);

            char currChar = p1RuckSet.toString().charAt(1);
            prioGroupTotal += getPrio(currChar);
        }
        fileScanner.close();
        System.out.println("Part 1 answer: " + priorityTotal);
        System.out.println("Part 2 answer: " + prioGroupTotal);
    }

    static HashSet<Character> populate(String input)
    {
        HashSet<Character> retHash = new HashSet<Character>();
        for (char c : input.toCharArray())
        {
            retHash.add(c);
        }
        return retHash;
    }

    static int getPrio(char c)
    {
        int prio = 0;
        if (Character.isUpperCase(c))
            {
                prio = c + UPPER_OFFSET;
            } 
        else
            {
                prio = c + LOWER_OFFSET;
            }
        return prio;
    }
}