import java.util.*;
import java.io.*;

class Day5 {
    static final int LINE_LENGTH = 34;
    static final int TEST_SIZE = 9;

    ArrayList<LinkedList<Character>> partOneList = new ArrayList<LinkedList<Character>>();
    ArrayList<LinkedList<Character>> partTwoList = new ArrayList<LinkedList<Character>>();
    public static void main(String[] args) throws FileNotFoundException
    {
        File inputFile = new File("day5input.txt");
        Scanner scanner = new Scanner(inputFile);
        Day5 solution = new Day5(); 
        solution.initList();

        String currLine = scanner.nextLine();
        while (!currLine.contains("1"))
        {
            System.out.println(currLine);
            for (int i = 0, currentPos = 1; i < TEST_SIZE; i++, currentPos += 4)
            {
                char currentChar = currLine.charAt(currentPos);
                if (currentChar != ' ')
                {
                    solution.partOneList.get(i).add(currentChar);
                    solution.partTwoList.get(i).addFirst(currentChar);
                }
            }
            currLine = scanner.nextLine();
        }

        scanner.nextLine();
        while (scanner.hasNextLine())
        {
            currLine = scanner.nextLine();
            String[] currSplit = currLine.split(" ");
            solution.move(Integer.parseInt(currSplit[1]), Integer.parseInt(currSplit[3]), Integer.parseInt(currSplit[5]));
        }
        solution.printSolution(); 
        scanner.close();
    }

    void initList()
    {
        for (int i = 0; i < TEST_SIZE; i++)
        {
            LinkedList<Character> tempList = new LinkedList<Character>();
            this.partOneList.add(tempList);
            LinkedList<Character> tempList2 = new LinkedList<Character>();
            this.partTwoList.add(tempList2);
        }
    }

    void move(int howMany, int from, int to)
    {
        Stack<Character> temp = new Stack<Character>();
        for (int i = 0; i < howMany; i++)
        {
            partOneList.get(to-1).addFirst(partOneList.get(from-1).poll());
            temp.add(partTwoList.get(from-1).removeLast()); 
        }
        while(!temp.isEmpty())
        {
            partTwoList.get(to-1).addLast(temp.pop());
        }
        System.out.println(partTwoList.toString());
    }

    void printFull()
    {
        int i = 0;
        for (LinkedList<Character> q : this.partTwoList)
        {
            System.out.println("Printing list #" + (i+1));
            while(!q.isEmpty())
            {
                System.out.println(q.poll());
            }
            i++;
        }
    }

    void printSolution()
    {
        System.out.print("Part one solution: ");
        for (LinkedList<Character> q : this.partOneList)
        {
            if(!q.isEmpty())
            {
                System.out.print(q.poll());
            }
        }
        System.out.println();

        System.out.print("Part two solution: ");
        for (LinkedList<Character> q : this.partTwoList)
        {
            System.out.print(q.removeLast());
        }
        System.out.println();
    }
}