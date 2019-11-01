import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class DuplicateRemover {
    //establishes Set of Strings to eliminate duplicate words
    private Set<String> uniqueWords;

    //determines whether an exceptional IO event occurs
    void remove(String dataFile) throws IOException
    {
        uniqueWords = new HashSet<String>();
        Scanner sc = new Scanner(new File(dataFile));

        //adds the words into the Set of Strings
        while(sc.hasNext()) {
            String word = sc.next();
            uniqueWords.add(word);
        }

        //cleans all resources allocated during method execution
        sc.close();
    }

    //determines whether an exception IO event occurs
    void write(String outPutFile) throws IOException
    {
        //creates a new file
        File newFile = new File(outPutFile);
        FileWriter overwrite = null;

        //checks to see if the new file already exists
        if(newFile.exists()) {

            //if it does exist, it will clear and overwrite the old file and replace with new.
            overwrite = new FileWriter(newFile, false);

            //prints each unique word
            for (String s : uniqueWords) {
                overwrite.write(s + " ");
            }

            //cleans all resources allocated during execution
            overwrite.close();
        }

        //if the file does not exist, then it will just make a new file
        else {
            overwrite = new FileWriter(newFile);

            //prints each unique word
            for (String s2 : uniqueWords) {
                overwrite.write(s2 + " ");
            }

            //cleans all resources
            overwrite.close();
        }
    }
}
