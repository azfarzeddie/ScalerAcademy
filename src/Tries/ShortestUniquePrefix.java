package Tries;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {

    static int NUM_LETTERS = 26;

    public static void main(String[] args) {
        String[] entries = {"id", "qscdxrjmow", "rxsjybldbe", "sarcbyne", "dyggxxp", "lorel", "nmpa"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(entries));
        list = prefix(list);
        System.out.println("list :: " + list);
    }

    /*iterate over the list of words and insert each word in the trie.
      for each of the insertion, insert if the character is not in the trie already.
      increase the frequency of each letter by 1.
      iterate over the string list. for each word, check first letter where frequency is 1.
      return the prefix till that letter.
     */
    public static ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> resList = new ArrayList<>();
        insertInTrie(A);
        return searchInTrie(A);
    }

    private static ArrayList<String> searchInTrie(ArrayList<String> words) {
        ArrayList<String> resList = new ArrayList<>();
        for (String word : words) {
            TrieNode root = dummy;
            String prefix = "";
            for (char ch : word.toCharArray()) {
                prefix = prefix.concat(String.valueOf(ch));
                if (root.character[ch - 'a'] != null && root.character[ch - 'a'].freq == 1) {
                    break;
                }
                root = root.character[ch - 'a'];
            }
            resList.add(prefix);
        }
        return resList;
    }

    static TrieNode dummy = new TrieNode();

    private static void insertInTrie(ArrayList<String> words) {
        for (String word : words) {
            TrieNode root = dummy;
            for (char ch : word.toCharArray()) {
                if (root.character[ch - 'a'] == null)
                    root.character[ch - 'a'] = new TrieNode();
                root.character[ch - 'a'].freq++;
                root = root.character[ch - 'a'];
            }
        }
        printTrie(dummy);
    }

    private static void printTrie(TrieNode root) {
        for (int i = 0; i < NUM_LETTERS; i++) {
            if (root.character[i] != null) {
                System.out.println((char) (i + 97) + " " + root.character[i].freq);
                printTrie(root.character[i]);
            }
        }
    }

    static class TrieNode {
        int freq;
        TrieNode[] character = new TrieNode[NUM_LETTERS];

        TrieNode() {
            freq = 0;
            for (int i = 0; i < NUM_LETTERS; i++)
                character[i] = null;
        }
    }
}

