// imports
import java.io.*;
import java.util.HashMap;
import java.util.Map;

// main method 
public class SynaLogik {
        
    public static void main(String[] args) {
    HashMap<Integer, Integer> lengthCount = new HashMap<Integer, Integer>();
    BufferedReader br;
    try {
        String currentLine;
        br = new BufferedReader(new FileReader("bible.txt"));

        // Gets new line, if it is the end of the file, it ends
        int totalNumberWords = 0;
        while ((currentLine = br.readLine()) != null) {
            String[] words = currentLine.split(" ");
            totalNumberWords += words.length;

            // Iterates through the words in the line and
            // increments the map appropriately
            for (String word : words) {
                int currentNumber = 0;
                if (lengthCount.get(word.length()) != null)
                    currentNumber = lengthCount.get(word.length());
                lengthCount.put(word.length(), currentNumber + 1);
            }
        }

        // Iterates through the map and prints the amount of strings
        // for each length and the percent of words with each length
        for (Map.Entry<Integer, Integer> curEntry : lengthCount.entrySet()) {
            double percentWithThisLength = ((double) curEntry.getValue() / totalNumberWords) * 100;
            System.out.print(curEntry.getValue() + " words with length " + curEntry.getKey());
            System.out.println(" (" + percentWithThisLength + "%)");
        }

        br.close();
        } catch (IOException e) {
            System.out.println("Could not find specified file");
        }

    }
}

