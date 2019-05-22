package com.au.counter.controller;

import com.au.counter.model.CountWord;
import com.au.counter.service.CounterService;
import com.au.counter.service.ParagraphService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class SearchWordController {

    @Autowired
    CounterService counterService;

    @Autowired
    ParagraphService paragraphService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountWord> search(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> words = mapper.readValue(request.getReader().readLine(), Map.class);

        if (words != null) {
            String paragraph = paragraphService.getParagraph("sample.txt");
            CountWord result = counterService.getWordCount(paragraph, words.get("searchText"));
            if (result == null) {
                return new ResponseEntity<CountWord>(result, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<CountWord>(result, HttpStatus.OK);
        }
        return null;
    }


    @RequestMapping(value = "/top/{top}", method = RequestMethod.GET, produces = "text/csv")
    public ResponseEntity<String> countOfTopWords(@PathVariable("top") int top) {
        String result = "";
        String paragraph = paragraphService.getParagraph("sample.txt");
        CountWord wordCount = counterService.getWordCount(paragraph);
        if (wordCount == null) {
            return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
        }
        result = wordCount.getTopWords(top);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
