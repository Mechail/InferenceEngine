import java.lang.reflect.Array;
import java.util.*;

public class KB {
    // This variable should be initialised in a constructor
    // String[] propositionSymbols;

    public KB()
    {

    }

    public void parseGivenKnowledgeBase(String[] givenKB)
    {
        extractPropositionSymbols(givenKB);
    }

    private ArrayList<String> extractPropositionSymbols(String[] givenKB)
    {
        ArrayList<String> splitFromImplications = splitFromImplication(givenKB);
        ArrayList<String> splitFromConjunctions = splitFromConjunction(splitFromImplications);
        ArrayList<String> removeWhiteSpacing = formatList(splitFromConjunctions);
        ArrayList<String> removeMultiples = removeMultiples(removeWhiteSpacing);

        return removeMultiples;
    }

    private ArrayList<String> splitFromImplication(String[] s)
    {
        ArrayList<String> stringSplitFromImplications = new ArrayList<String>();

        for (int i = 0; i < s.length; i++)
        {
            String[] eachSentence = s[i].split("=>");

            for (int j = 0; j < eachSentence.length; j++) {

                stringSplitFromImplications.add(eachSentence[j]);
            }
        }

        return stringSplitFromImplications;
    }

    private ArrayList<String> splitFromConjunction(ArrayList<String> s)
    {
        ArrayList<String> stringSplitFromConjunctions = new ArrayList<String>();

        for (int i = 0; i < s.size(); i++)
        {
            String[] eachSentence = s.get(i).split("&");

            for (int j = 0; j < eachSentence.length; j++) {

                stringSplitFromConjunctions.add(eachSentence[j]);
            }
        }

        return stringSplitFromConjunctions;
    }

    private ArrayList<String> removeMultiples(ArrayList<String> s)
    {
        ArrayList<String> stringRemoveMultiples = new ArrayList<String>();

        for (int i = 0; i < s.size(); i++)
        {
            if (stringRemoveMultiples.contains(s.get(i)))
            {
                continue;
            } else {
                stringRemoveMultiples.add(s.get(i));
            }
        }

        return stringRemoveMultiples;
    }

    private ArrayList<String> formatList(ArrayList<String> s)
    {
        ArrayList<String> stringFormatted = new ArrayList<String>();

        for (int i = 0; i < s.size(); i++)
        {
            stringFormatted.add(s.get(i).replaceAll("\\s", ""));
        }

        return stringFormatted;
    }
}
