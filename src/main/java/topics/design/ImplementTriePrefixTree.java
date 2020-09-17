package topics.design;

import java.util.HashMap;

//leetCode #208
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        trie.search("apps");
        trie.search("app");
    }

    private static class Trie {

        private static class Node {

            Character ch;
            HashMap<Character, Node> childMap;
            boolean isWordMarker = false;

            private Node(Character ch) {
                this.ch = ch;
                childMap = new HashMap();
            }

            private void addChild(Character ch) {
                if (!childMap.containsKey(ch)) {
                    childMap.put(ch, new Node(ch));
                }
            }

        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node(null);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node trav = root;
            for (char ch : word.toCharArray()) {
                trav.addChild(ch);
                trav = trav.childMap.get(ch);
            }
            trav.isWordMarker = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node trav = root;

            for (char ch : word.toCharArray()) {
                if (trav.childMap.containsKey(ch)) {
                    trav = trav.childMap.get(ch);
                } else {
                    return false;
                }
            }

            return trav.isWordMarker;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node trav = root;

            for (char ch : prefix.toCharArray()) {
                if (trav.childMap.containsKey(ch)) {
                    trav = trav.childMap.get(ch);
                } else {
                    return false;
                }
            }

            return true;
        }
    }

}
