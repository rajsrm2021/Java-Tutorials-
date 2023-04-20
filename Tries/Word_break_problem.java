// function 
public static boolean wordbreakproblem(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            // for using substring fn if we go from 0 to 0 it will trow an error so we have
            // to start loop frpm 1 so substring to abovide error be happy
            if (search(key.substring(0, i)) &&
                    wordbreakproblem(key.substring(i))) { 
                return true;
            }
        }
        return false;
    }

// driver code

public static void main(String args[]) {
        String words[] = { "i", "love", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilovesamsung";

        System.out.println(wordbreakproblem(key));

    }
