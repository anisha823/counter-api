package com.au.counter.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

@Service("ParagraphService")
public class ParagraphServiceImpl implements ParagraphService {

    @Override
    public String getParagraph(String fileName) {
        StringBuffer stringBuffer = new StringBuffer();
        URL urlpath = this.getClass().getClassLoader().getResource(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(urlpath.getFile()));
            String str;
            while ((str = br.readLine()) != null) {
                stringBuffer.append("\n").append(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            System.out.println("Exception while reading");
        }
        return stringBuffer.toString();
    }
}
