public class tries2 {
    static class Node {
        Node[] childern = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < childern.length; i++) {
                childern[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childern[idx] == null) {
                curr.childern[idx] = new Node();

            } else {
                curr.childern[idx].freq++;
            }
            curr = curr.childern[idx];
        }

        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans) { // T(n)=O(L) i.e. longest word in my tries
        // base case
        if (root == null) {
            return;
        }
        // 2nd base case
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.childern.length; i++) {
            if (root.childern[i] != null) {
                findPrefix(root.childern[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String args[]) {

        String words[] = { "zebera", "dog", "duck", "dove" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        root.freq = -1;
        findPrefix(root, "");
    }

}
