package com.au.counter.model;

import java.util.List;
import java.util.Map;

public class CountWord {
    private List<Map.Entry<String, Integer>> counts;

    public List<Map.Entry<String, Integer>> getCounts() {
        return counts;
    }

    public void setCounts(List<Map.Entry<String, Integer>> counts) {
        this.counts = counts;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Integer> count : counts) {
            buffer.append(count.getKey()).append("|").append(count.getValue());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public String getTopWords(int top) {
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Integer> count : counts) {
            buffer.append(count.getKey()).append("|").append(count.getValue());
            buffer.append("\n");
            if (++i == top)
                break;
        }
        return buffer.toString();
    }

}

