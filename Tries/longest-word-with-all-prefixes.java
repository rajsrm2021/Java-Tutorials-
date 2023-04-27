import java.util.*;

public class Tries1 {
    static class Node {
        Node[] children = new Node[26]; // 'a'-'z'
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // insertion operation : T(n)=O(L)

    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }
  public static String ans = "";

    public static void longestword(Node root, StringBuilder temp) {
        // Corner case
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);

                if (temp.length() > ans.length()) {
                    // String builders cant be assign directly to string thatswhy we will use
                    // toString() function
                    ans = temp.toString();
                }

                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1); // back-tracking
            }
        }
    }

    public static void main(String args[]) {
  
        String word[] = { "apple", "banana", "appl", "app", "a", "apply" ,"ap" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }

        longestword(root, new StringBuilder(""));
        System.out.println(ans);

    }

}
