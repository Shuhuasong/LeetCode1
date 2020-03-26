package DataStructureDesign;

import java.util.HashMap;
import java.util.HashSet;

public class AddAndSearchWord_211 {
    class WordDictionary {

        class TrieNode{
            TrieNode[] children;
            boolean isWord;
            public TrieNode(){
                children = new TrieNode[26];
                isWord = false;
            }
        }

        private TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                int index = (int)(c - 'a');
                if(cur.children[index]==null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return find(word, 0, root);
        }

        private boolean find(String word, int index, TrieNode cur){
            if(index==word.length()){
                return cur.isWord;
            }

            char c = word.charAt(index);

            if(c=='.'){
                for(int i=0; i<26; i++){
                    if(cur.children[i] != null){
                        if (find(word, index+1, cur.children[i])) return true;
                    }
                }
                return false;
            }

            else{
                return (cur.children[c-'a'] != null && find(word, index+1, cur.children[c-'a']));
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
