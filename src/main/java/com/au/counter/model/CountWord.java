package com.au.counter.model;

import java.util.List;
import java.util.Map;

public class CountWord {
    private List<Map.Entry<String, Integer>> tally;

    public List<Map.Entry<String, Integer>> getTally() {
        return tally;
    }

    public void setTally(List<Map.Entry<String, Integer>> tally) {
        this.tally = tally;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Integer> count : tally) {
            buffer.append(count.getKey()).append("|").append(count.getValue());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public String getTopWords(int c) {
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Integer> count : tally) {
            buffer.append(count.getKey()).append("|").append(count.getValue());
            buffer.append("\n");
            if (++i == c)
                break;
        }
        return buffer.toString();
    }

}

