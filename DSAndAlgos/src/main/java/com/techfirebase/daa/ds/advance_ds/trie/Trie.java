package com.techfirebase.daa.ds.advance_ds.trie;
/**
 * Trie basically used to efficiently solve the search problems over string. This is preferably used
 * over hash table and balance binary tree.
 *
 * <p>Although hash table has O(1) time complexity for looking for a key, it is not efficient in the
 * following operations :
 *
 * <p>Finding all keys with a common prefix.
 *
 * <p>Enumerating a dataset of strings in lexicographical order.
 *
 * <p>hash table increases in size, there are lots of hash collisions and the search time complexity
 * could deteriorate to O(n), where n is the number of keys inserted.
 *
 * <p>On the other hand Trie could use less space compared to Hash Table when storing many keys with
 * the same prefix.
 *
 * <p>In this case using trie has only O(m) time complexity, where m is the key length.
 *
 * <p>Searching for a key in a balanced tree costs O(mlogn) time complexity.
 *
 * <p>That's why Trie is preferable in all these cases.
 *
 * @author VIVEK KUMAR SINGH
 * @since (2018-06-16 11:01:22)
 */
public class Trie {
  // string can be consist of any of 26 characters
  private static int ALPHABET_SIZE = 26;

  private static TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * In each iteration of the algorithm, we either examine or create a node in the trie till we
   * reach the end of the key. This takes only m operations.
   *
   * <p>Time complexity : O(m), where m is the key length.
   *
   * <p>In the worst case newly inserted key doesn't share a prefix with the the keys already
   * inserted in the trie. We have to add m new nodes, which takes us O(m) space.
   *
   * <p>Space complexity : O(m).
   *
   * @param word
   */
  public void insert(String word) {
    TrieNode child = root;
    child.setCount(child.getCount() + 1);

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      // if character is not inserted yet, add it
      if (!child.containsKey(ch)) child.put(ch, new TrieNode());

      child = child.get(ch);
      child.setCount(child.getCount() + 1);
    }

    child.setEnd(true);
  }

  /**
   * Search a prefix or whole key in trie and returns the node where search ends.
   *
   * <p>Time complexity : O(m) In each step of the algorithm we search for the next key character.
   * In the worst case the algorithm performs m operations.
   *
   * <p>Space complexity : O(1)
   *
   * @param word
   * @return
   */
  public TrieNode searchPrefix(String word) {
    TrieNode child = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      // if character is found, then we have to search for next character
      if (child.containsKey(ch)) child = child.get(ch);
      else return null;
    }

    return child;
  }

  /**
   * @param word
   * @return true if whole word is in the trie
   */
  public boolean search(String word) {
    TrieNode child = searchPrefix(word);

    return (child != null && child.isEnd());
  }

  /**
   * @param prefix
   * @return true if any word start with given prefix in the trie
   */
  public boolean startsWith(String prefix) {
    TrieNode child = searchPrefix(prefix);

    return (child != null);
  }

  static class TrieNode {
    private TrieNode[] children;
    // this will point the end of the word's character if it is true
    private boolean isEnd;

    // count to store that how many times any character appears in a word in trie.
    private int count = 0;

    TrieNode() {
      this.children = new TrieNode[ALPHABET_SIZE];
    }

    /** get the index of character in trie, that is start with 'a' charter's index in our case */
    public boolean containsKey(char ch) {
      return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
      children[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
      return children[ch - 'a'];
    }

    public boolean isEnd() {
      return isEnd;
    }

    public void setEnd(boolean end) {
      isEnd = end;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }
  }
}
