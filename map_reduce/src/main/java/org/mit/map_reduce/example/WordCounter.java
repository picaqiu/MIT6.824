package org.mit.map_reduce.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {
    private Map<String, Long> data = new HashMap<>();


    public void map(List<String> words) {
        data = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toMap(Function.identity(), word -> 1L, Long::sum));
    }

    public Map<String, Long> reduce() {
        return data;
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        String inputText = "Hello World Hello Java World";

        // Tokenize the input text into words
        List<String> words = Arrays.asList(inputText.split("\\s+"));
        wordCounter.map(words);
        wordCounter.reduce().forEach((k,v)->System.out.println(k+" : " + v));
    }


}
