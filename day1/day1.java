import java.util.*;
import java.io.*;

class Day1
{
    public static void main (String[] args) throws FileNotFoundException
    {
        File input = new File("day1input.txt");
        Scanner scanner = new Scanner(input);
        String curr = "";
        Integer maxCalories = 0;
        Integer highest = 0;

        PriorityQueue<Integer> top3PriorityQueue = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        top3PriorityQueue.add(0); 
        while(scanner.hasNextLine())
        {
            curr = scanner.nextLine();
            if (curr.equals(""))
            {
                if (highest < maxCalories)
                {
                    highest = maxCalories;
                }
                top3PriorityQueue.add(maxCalories);
                maxCalories = 0;
            }
            else
            {
                maxCalories += maxCalories.valueOf(curr);
            }
        }
        System.out.println("Highest count is: " + highest);
        System.out.println("Top 3 total is: " + (top3PriorityQueue.poll() + top3PriorityQueue.poll() + top3PriorityQueue.poll()));
    }
}