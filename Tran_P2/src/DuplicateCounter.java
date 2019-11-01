import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class DuplicateCounter {
    //establishes a Map of Strings to count how many times each word occurs.
    private Map<String, Integer> wordCounter;

    //determines whether an exceptional IO event occurs
    void count(String dataFile) throws IOException
    {
        wordCounter = new HashMap<String, Integer>();
        Scanner sc = new Scanner(new File(dataFile));

        //adds the words to the Map of Strings
        while (sc.hasNext()) {
            String word = sc.next();

            //determines where and if a word is located.
            Integer count = wordCounter.get(word);

            //if a word is located, its appearance count will increase by 1.
            if (count != null) {
                count = count + 1;
            } else {
                count = 1;
            }

            //puts the word and the number of times it occurs in the map.
            wordCounter.put(word, count);
        }

        //cleans all resources allocated during execution
        sc.close();
    }
    void write(String outPutFile) throws IOException
    {

        //creates new file
        FileWriter overwrite = new FileWriter(new File(outPutFile));

        //for each word, will print out each unique word and determine how many times it has appeared.
        for (Entry<String, Integer> entry : wordCounter.entrySet()) {
            overwrite.write(entry.getKey() + " " + entry.getValue() + "\r\n");
        }

        //cleans all resources allocated during execution.
        overwrite.close();
    }
}