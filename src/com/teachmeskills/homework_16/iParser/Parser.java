package com.teachmeskills.homework_16.iParser;

import com.teachmeskills.homework_16.model.Sonnet;

import java.util.List;

public interface Parser {
    List<Sonnet> process(String file);
}
