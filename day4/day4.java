import java.util.*;
import java.io.*;

class Day4
{
    public static void main(String [] args) throws FileNotFoundException
    {
        File inputFile = new File("day4input.txt");
        Scanner fileScanner = new Scanner(inputFile);
        int subsetCount = 0;
        int overlapCount = 0;
        int firstElf1, firstElf2, secondElf1, secondElf2;
        String temp;
        while(fileScanner.hasNextLine())
        {
            temp = fileScanner.nextLine();
            String [] splitMeUp = temp.split("[-|,]", temp.length());
            firstElf1 = Integer.valueOf(splitMeUp[0]);
            firstElf2 = Integer.valueOf(splitMeUp[1]);
            secondElf1 = Integer.valueOf(splitMeUp[2]);
            secondElf2 = Integer.valueOf(splitMeUp[3]);

            if (isSubset(firstElf1, firstElf2, secondElf1, secondElf2))
            {
                subsetCount++;
            }
            if (isOverlapping(firstElf1, firstElf2, secondElf1, secondElf2))
            {
                overlapCount++;
            }
        }
        fileScanner.close();
        System.out.println("Subset count: " + subsetCount);
        System.out.println("Overlap count: " + overlapCount);
    }

    static boolean isSubset(int s1Start, int s1End, int s2Start, int s2End)
    {
        return ((s1Start <= s2Start && s1End >= s2End) || 
            (s2Start <= s1Start && s2End >= s1End));
    }

    static boolean isOverlapping(int s1Start, int s1End, int s2Start, int s2End)
    {
        boolean retBool = false;
        HashSet<Integer> firstPair = new HashSet<Integer>();
        for (int i = s1Start; i < s1End+1; i++)
        {
            firstPair.add(i);
        }
        for (int i = s2Start; i < s2End+1; i++)
        {
            if (!(firstPair.add(i)))
            {
                retBool = true;
                i = s2End;
            }
        }
        return retBool;
    }
}