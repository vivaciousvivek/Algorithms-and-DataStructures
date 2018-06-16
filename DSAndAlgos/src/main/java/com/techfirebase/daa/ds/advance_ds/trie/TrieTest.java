package com.techfirebase.daa.ds.advance_ds.trie;
/**
 * @author VIVEK KUMAR SINGH
 * @since (2018-06-16 13:04:50)
 */
public class TrieTest {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();

    sb.append("\n*************Trie Test*************\n");

    Trie trie = new Trie();

    String[] strArr = {"hello", "how", "are", "you"};
    for (String str : strArr) {
      trie.insert(str);
    }

    String[] searchKey = {"hello", "i", "am", "fine", "and", "how", "are", "you"};
    for (String str : searchKey) {
      sb.append(str)
          .append(" : \t\t")
          .append(trie.search(str) ? "found!!!" : "not found!!!")
          .append("\n");
    }

    System.out.println(sb);
  }
}
