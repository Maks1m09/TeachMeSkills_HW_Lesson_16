package com.teachmeskills.homework_16.runner;

import com.teachmeskills.homework_16.Util.Writing;
import com.teachmeskills.homework_16.domParser.Dom;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Start");
        Dom dom = new Dom();
        String filepath = "C:\\NewHomework\\Fail\\hw.xml";
        Writing writing = new Writing();
        try {
            writing.writeDownText(dom.process(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}