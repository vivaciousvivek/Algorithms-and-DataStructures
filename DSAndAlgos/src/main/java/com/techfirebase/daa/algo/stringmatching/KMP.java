package com.techfirebase.daa.algo.stringmatching;
/**
 * String Searching by KMP algorithm (Knuth Morris Pratt algorithm).
 *
 * <p>The problem: given a (long) text and a (short) pattern, both strings, determine whether the
 * pattern appears somewhere in the text.
 *
 * <p>Naive solution will take TC: O(T*P) in worst case, by comparing the characters in both string,
 * and after we will get mismatch on last character of pattern in text, then we need to go backward
 * in text string and then check again from the next character from the index we just started
 * comparison.
 *
 * <p>For example if we have input like:
 *
 * <p>Text : abcxabcdabcdabcy
 *
 * <p>Pat: abcdabcy
 *
 * <p>In this example till we reach y in pattern every thing is matched, only one character that is
 * y is not matched with d. So we need to go back till and then again do the same process from its
 * next character i.e is b.
 *
 * <p>So to improve the worst case TC, this algo was designed efficiently
 *
 * @author VIVEK KUMAR SINGH
 * @since (2018-07-15 10:00:53)
 */
public class KMP {

  /**
   * KMP algorithm preprocessed pat[] and constructs an auxiliary lps[] of size m (same as size of
   * pattern) which is used to skip characters while matching with the text.
   *
   * <p>To do that, we keep track of the length of the longest prefix suffix value (we use
   * lenOfPrefixItselfIsSuffix variable for this purpose) for the previous index. We initialize
   * lps[0] and lenOfPrefixItselfIsSuffix as 0.
   *
   * <p>If pat[lenOfPrefixItselfIsSuffix] and pat[i] match, we increment len by 1 and assign the
   * incremented value to lps[i].
   *
   * <p>If pat[i] and pat[lenOfPrefixItselfIsSuffix] do not match and len is not 0, we need to
   * update the lenOfPrefixItselfIsSuffix to lps[lenOfPrefixItselfIsSuffix-1] (its previous matched
   * character in patter).
   *
   * @param pattern
   * @return
   */
  private static int[] computeLongestPrefixArray(String pattern) {
    int len = pattern.length();
    int[] lps = new int[len];

    int i = 1, lenOfPrefixItselfIsSuffix = 0;
    while (i < len) {
      if (pattern.charAt(i) == pattern.charAt(lenOfPrefixItselfIsSuffix)) {
        lps[i] = ++lenOfPrefixItselfIsSuffix;
        i++;
      } else if (lenOfPrefixItselfIsSuffix != 0) {
        lenOfPrefixItselfIsSuffix = lps[lenOfPrefixItselfIsSuffix - 1];
      } else {
        lps[i] = lenOfPrefixItselfIsSuffix;
        i++;
      }
    }

    return lps;
  }

  /**
   * The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches),
   * we won't go backward in Text string as we already know some of the characters in the text are
   * already in pattern (i.e pattern having same sub-patterns appearing more than once in the
   * pattern) so we need not to check them again.
   *
   * <p>But how we will know which sub-patterns are exist where in pattern. To know this info we
   * need to extract and store this info into some somewhere. So we will store this info into an
   * array called Longest Prefix Array(LPS) which is itself a Suffix (i.e if any pattern is
   * appearing at the beginning also available in pattern somewhere).
   *
   * <p>We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and
   * txt[i] are matching.
   *
   * <p>When we see a mismatch:
   *
   * <p>We know that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and
   * suffix. So we will check for those in lps by going backward till we reach 0(at first index).
   *
   * <p>If there is no match till 0 so we can't go backword any more then we need to increment i and
   * start the whole process again till we got the match or till last character of the Text String.
   *
   * <p>TC: O(T + P) Sum of length of the Text and Pattern. i.e. in linear time.
   *
   * @param text
   * @param pattern
   * @return
   */
  public static int stringMatchingUsingKMP(String text, String pattern) {
    if (pattern == null
        || text == null
        || pattern.isEmpty()
        || text.isEmpty()
        || text.length() < pattern.length()) return -1;

    int textLen = text.length();
    int patLen = pattern.length();
    int[] lps = computeLongestPrefixArray(pattern);

    int i = 1, lenOfPrefixItselfIsSuffix = 0;
    while (i < textLen && lenOfPrefixItselfIsSuffix < patLen) {
      if (text.charAt(i) == text.charAt(lenOfPrefixItselfIsSuffix)) {
        i++;
        lenOfPrefixItselfIsSuffix++;
      } else if (lenOfPrefixItselfIsSuffix != 0) {
        lenOfPrefixItselfIsSuffix = lps[lenOfPrefixItselfIsSuffix - 1];
      } else {
        i++;
      }
    }

    return (lenOfPrefixItselfIsSuffix == patLen) ? i - lenOfPrefixItselfIsSuffix : -1;
  }
}
