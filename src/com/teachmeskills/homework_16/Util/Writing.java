package com.teachmeskills.homework_16.Util;

import com.teachmeskills.homework_16.model.Sonnet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writing {
    public void writeDownText(List<Sonnet> sonnets) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\NewHomework\\Fail\\" +
                sonnets.get(0).getAuthor().getFirstName() +
                sonnets.get(0).getAuthor().getLastName() +
                sonnets.get(0).getTitle()));
        bufferedWriter.write(String.valueOf(sonnets));
        bufferedWriter.close();
    }
}
