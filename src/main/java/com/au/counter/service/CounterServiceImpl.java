package com.au.counter.service;

import com.au.counter.model.CountWord;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

@Service("CounterService")
public class CounterServiceImpl implements CounterService {

    public static final String SEPERATOR = ", ?.!:\"\"''\n";

    public CountWord getWordCount(String paragraph) {
        if (paragraph == null)
            return null;
        Map<String, Integer> map = createParaMap(paragraph);
        CountWord countWord = createWordCount(map);
        return countWord;
    }

    public CountWord getWordCount(String paragraph, List<String> words) {
        if (paragraph == null || words == null)
            return getWordCount(paragraph);
        List<Map.Entry<String, Integer>> tallyList = new ArrayList<Map.Entry<String, Integer>>();
        Map<String, Integer> map = createParaMap(paragraph);
        for (String word : words) {
            Integer c = map.get(word.toLowerCase());
            if (c == null)
                c = 0;
            Map.Entry<String, Integer> entry = new SimpleEntry<String, Integer>(word, c);
            tallyList.add(entry);
        }

        CountWord result = new CountWord();
        result.setTally(tallyList);
        return result;
    }

    private CountWord createWordCount(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> countList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(countList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        CountWord wordCount = new CountWord();
        wordCount.setTally(countList);
        return wordCount;
    }

    private Map<String, Integer> createParaMap(String paragraph) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringTokenizer token = new StringTokenizer(paragraph);
        while (token.hasMoreTokens()) {
            String word = token.nextToken(SEPERATOR).toLowerCase();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else
                map.put(word, 1);
        }
        return map;
    }


}
