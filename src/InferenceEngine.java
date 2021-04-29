import java.io.*;
import java.util.*;

class InferenceEngine {
    public static final int METHOD_COUNT = 3;
    public static InferenceAlgorithm[] lMethods;

    public static void main(String[] args) {

        InitMethods();

        // check to see if input was entered correctly
        if (args.length < 2)
        {
            System.out.println("Usage: iengine <method> <filename>.");
            System.exit(1);
        }

        readProblemFile(args[0]);

        System.exit(0);
    }

    private static KB readProblemFile(String fileName)
    {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String kbLine, queryLine;
            String[] kbSentences;
            KB knowledgeBase = new KB();

            // Skip over line that says "TELL"
            bufferedReader.readLine();

            // Split all the sentences from the knowledge base by the semicolon
            kbLine = bufferedReader.readLine();
            kbSentences = kbLine.split(";");

            // Remove the whitespace at the beginning of each sentence
            for (int i = 0; i < kbSentences.length; i++)
            {
                kbSentences[i] = kbSentences[i].stripLeading();
            }

            // Skip over line that says "ASK"
            bufferedReader.readLine();

            // Read the line with the query
            queryLine = bufferedReader.readLine();

            // Parse the given knowledge base to extract individual symbols
            knowledgeBase.parseGivenKnowledgeBase(kbSentences);

        }
        catch(FileNotFoundException ex)
        {
            //The file didn't exist, show an error
            System.out.println("Error: File \"" + fileName + "\" not found.");
            System.out.println("Please check the path to the file.");
            System.exit(1);
        }
        catch(IOException ex)
        {
            //There was an IO error, show and error message
            System.out.println("Error in reading \"" + fileName + "\". Try closing it and programs that may be accessing it.");
            System.out.println("If you're accessing this file over a network, try making a local copy.");
            System.exit(1);
        }

        //this code should be unreachable. This statement is simply to satisfy Eclipse.
        return null;
    }

    private static void InitMethods()
    {
        lMethods = new InferenceAlgorithm[METHOD_COUNT];
        lMethods[0] = new TT();
        lMethods[1] = new FC();
        lMethods[2] = new BC();
    }

}
