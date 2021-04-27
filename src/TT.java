import java.util.Arrays;

public class TT extends InferenceAlgorithm {
    public void Solve()
    {

    }

    // NOTE: please change the return type of this next method
    public boolean TT_Entails(KB kb, String alpha)
    {
        // Basic idea for how to verify KB entails alpha
//        if (kb == alpha) {
//            return true;
//        }
        return false;
    }

    public boolean TT_Check_All(KB kb, String alpha, String[] symbols, String[] model)
    {
        if (symbols.length == 0)
        {
            // if the current model is entailed by kb, then check to see if model is also entailed by alpha.
            // if it is, return true.

            // if the current model is NOT entailed by kb
            // return true.
        } else {
            String p = symbols[0];
            String[] rest = Arrays.copyOfRange(symbols, 1, symbols.length);
        }

        // NOTE: dummy value
        return false;
    }
}
