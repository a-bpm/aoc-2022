import java.util.*;
import java.io.*;

class Day5 {
    static final int LINE_SIZE = 34;
    public static void main(String[] args) throws FileNotFoundException
    {
        File inputFile = new File("day5input.txt");
        Scanner scanner = new Scanner(inputFile);
        
        ArrayList<Queue<Character>> stackList = new ArrayList<Queue<Character>>(9);
        initList(stackList);

        String currLine = scanner.nextLine();
        while (!currLine.contains("1"))
        {
            System.out.println(currLine);
            for (int i = 0, currentPos = 1; i < 9; i++, currentPos += 4)
            {
                char currentChar = currLine.charAt(currentPos);
                if (currentChar != ' ')
                {
                    stackList.get(i).add(currentChar);
                }
            }
            currLine = scanner.nextLine();
        }

        for (Queue<Character> s : stackList)
        {
            while (!s.isEmpty())
                System.out.println(s.poll());
        }
        scanner.close();
    }

    static void initList(ArrayList<Queue<Character>> initMe)
    {
        for (int i = 0; i < 10; i++)
        {
            Queue<Character> tempStack = new LinkedList<Character>();
            initMe.add(tempStack);
        }
    }
}