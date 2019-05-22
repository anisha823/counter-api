package com.au.counter.service;

import com.au.counter.model.CountWord;

import java.util.List;

public interface CounterService {

    CountWord getWordCount(String paragraph);

    CountWord getWordCount(String paragraph, List<String> words);

}
