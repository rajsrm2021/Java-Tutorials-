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
  
  public static int countnode(Node root){
        if(root==null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count += countnode(root.children[i]);
            }
        }
        return count+1;
    }
  
  public static void main(String args[]) {
        String word = "apple"; // ans =15


        for(int i=0;i<word.length();i++){
            String suffix = (word.substring(i));
            insert(suffix);
        }

        System.out.println(countnode(root));

    }

}
