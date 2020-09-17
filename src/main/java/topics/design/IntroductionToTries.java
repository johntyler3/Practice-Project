package topics.design;

import java.util.HashMap;

/*
A Trie or Prefix Tree an efficient data lookup structure - often used to store large collections of words or
dictionaries. With a Trie, search complexities can be reduced to O(k) where k is the key or word length.
The autocorrect on your iOS or Android keyboard uses a Trie of the most commonly used words along with fuzzy
match algorithms to autocorrect and autosuggest words as you type. You're given a completed TrieNode class that
represents one node of a Trie, and a partially complete Trie class. Your task is to complete the insertWord,
searchWord and searchPrefix methods on the Trie class. Take a look at the examples below to see what each of these do.

Example:
trie.inserWord("AB")
trie.inserWord("ABS")
trie.inserWord("ADS")
trie.inserWord("ADSD")
trie.inserWord("ACS")

Internal Trie Structure:

    A
  / | \
 B  C  D
 |  |  |
 S  S  S
       |
       D
 */

//fireCode
public class IntroductionToTries {

    class TrieNode {
        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(Character c) {
            this.c = c;
        }
    }

    class Trie {
        private TrieNode root;

        // Implement these methods :
        public Trie() {
            root = new TrieNode();
        }

        public void insertWord(String word) {
            if (word != null && word.length() >= 1) {
                TrieNode trav = root;
                HashMap<Character, TrieNode> children = trav.children;

                for (int i = 0; i < word.length(); i++) {
                    Character c = word.charAt(i);
                    if (!children.containsKey(c)) {
                        children.put(c, new TrieNode(c));
                    }
                    trav = (TrieNode)children.get(c);
                    if (i == word.length() - 1) {
                        trav.isLeaf = true;
                    }
                }

            }

        }

        public Boolean searchWord(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            TrieNode trav = root;
            HashMap<Character, TrieNode> children = trav.children;

            for (char ch : word.toCharArray()) {
                if (!children.containsKey(ch)) {
                    return false;
                }
                trav = (TrieNode)children.get(ch);
            }

            return trav.isLeaf;
        }


        public Boolean searchPrefix(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            TrieNode trav = root;
            HashMap<Character, TrieNode> children = trav.children;

            for (char ch : word.toCharArray()) {
                if (!children.containsKey(ch)) {
                    return false;
                }
                trav = (TrieNode)children.get(ch);
            }

            return true;
        }
    }

}
