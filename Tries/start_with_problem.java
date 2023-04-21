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
  
  public static boolean startWith_PROBLEM(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
  
  public static void main(String args[]) {
     String words[]={"apple","app","mango","man","women"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        String prefix1 = "app";
        String prefix2 = "add";
        System.out.println(startWith_PROBLEM(prefix1));
        System.out.println(startWith_PROBLEM(prefix2));


    }

}
