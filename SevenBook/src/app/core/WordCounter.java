package app.core;

import java.util.TreeMap;

public class WordCounter {
    public static void main(String[] args) {
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : args) {
            Integer wordCount = wordCountMap.getOrDefault(word, 0) + 1;
            wordCountMap.put(word, wordCount);
        }

        System.out.println(wordCountMap);
    }
}
