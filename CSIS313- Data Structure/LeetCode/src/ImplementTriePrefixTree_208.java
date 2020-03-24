public class ImplementTriePrefixTree_208 {

    class Trie {

        class TrieNode {
            char c;
            TrieNode[] children;
            boolean isWord;

            public TrieNode(char c) {
                this.c = c;
                children = new TrieNode[26];
                isWord = false;
            }
        }

        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode('\n');
        }

        /** Inserts a word into the trie. */
        /** Helper function for Insert*/
        private void insert(TrieNode root, String word){
            if(word.length()==0){
                root.isWord = true;
                return;
            }
            int childIndex = word.charAt(0)-'a';
            if(root.children[childIndex] == null){
                root.children[childIndex] = new TrieNode(word.charAt(0));
            }
            insert(root.children[childIndex],word.substring(1));
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(root,word);
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return  find(root, word);
        }

        private boolean find(TrieNode root, String word){
            if(root == null) return false;

            if(word.length()==0) return root.isWord;
            int index = word.charAt(0) - 'a';
            return find(root.children[index], word.substring(1));
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */


        private TrieNode locate(TrieNode root, String prefix){
            if(root == null) return null;
            if(prefix.length()==0) return root;
            return locate(root.children[prefix.charAt(0)-'a'], prefix.substring(1));
        }

        private boolean startWith(TrieNode root){
            if(root.isWord) return true;
            for(int i=0; i<26; i++){
                if(root.children[i] != null && startWith(root.children[i]));
                return true;
            }
            return false;
        }

        public boolean startWith(String prefix){
            TrieNode node = locate(root, prefix);
            if(node==null){
                return false;
            }
            return startWith(node);
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
