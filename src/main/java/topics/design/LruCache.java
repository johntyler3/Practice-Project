package topics.design;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds
the capacity from this operation, evict the least recently used key.

Follow up:
Could you do get and put in O(1) time complexity?


Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
 */

import java.util.HashMap;

//leetCode #146
public class LruCache {

    /*
    **NOTE** the idea here is that you create the LruNode and all methods dealing with the node yourself
    This lets you grab the tail and move nodes to head when accessed easily in O(1) time
     */

    private static class LruNode {
        private int key;
        private int val;
        private LruNode pre;
        private LruNode post;
    }

    private void addNode(LruNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(LruNode node) {
        LruNode pre = node.pre;
        LruNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(LruNode node) {
        removeNode(node);
        addNode(node);
    }

    private LruNode popTail() {
        LruNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private HashMap<Integer, LruNode> cache = new HashMap();
    private int cap;
    private LruNode head;
    private LruNode tail;

    public LruCache(int capacity) {
        cap = capacity;
        head = new LruNode();
        tail = new LruNode();

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        LruNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        LruNode node = cache.get(key);

        if (node == null) {

            LruNode newNode = new LruNode();
            newNode.key = key;
            newNode.val = value;

            cache.put(key, newNode);
            addNode(newNode);

            if (cache.size() > cap) {
                LruNode tail = popTail();
                cache.remove(tail.key);
            }

        } else {
            node.val = value;
            moveToHead(node);
        }

    }

}
