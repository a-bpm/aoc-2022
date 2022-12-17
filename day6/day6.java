import java.util.*;
import java.io.*;

class Day6 {
    static final String FILE_NAME = "day6input.txt";
    static final int MARKER_OFFSET = 4;
    static final int MESSAGE_OFFSET = 14;

    LinkedHashSet<Character> marker = new LinkedHashSet<Character>(); 
    LinkedHashSet<Character> message = new LinkedHashSet<Character>(); 
    public static void main(String [] args) throws FileNotFoundException
    {
        Day6 messager = new Day6();
        File inputFile = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(inputFile);

        String completeFile = fileScanner.next();

        int currPos = -1;
        boolean markerSearching = true;
        boolean messageSearching = true;
        int foundMarker = 0, foundMessage = 0;
        while (markerSearching || messageSearching)
        {
            currPos++;

            markerSearching = messager.marker.size() < MARKER_OFFSET;
            messageSearching = messager.message.size() < MESSAGE_OFFSET;

            if (markerSearching)
            {
                messager.marker.clear();
                String nextMarker = completeFile.substring(currPos, currPos+MARKER_OFFSET);
                messager.findMarker(nextMarker);
                foundMarker = currPos;
            }

            if (messageSearching)
            {
                messager.message.clear();
                String nextMessage = completeFile.substring(currPos, currPos+MESSAGE_OFFSET);
                messager.findMessage(nextMessage);
                foundMessage = currPos;
            }
        }        

        System.out.println("First marker found at position: " + (foundMarker + MARKER_OFFSET));
        System.out.println("First message found at position: " + (foundMessage + MESSAGE_OFFSET));
    }

    void findMessage(String subbedString)
    {
        for (int i = 0; i < subbedString.length(); i++)
        {
            message.add(subbedString.charAt(i));
        }
    }

    void findMarker(String subbedString)
    {
        for (int i = 0; i < subbedString.length(); i++)
        {
            marker.add(subbedString.charAt(i));
        }
    }
}