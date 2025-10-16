package com.csg.indexer;

import com.csg.indexer.io.FileLoader;
import com.csg.indexer.parser.ContentExtractor;
import com.csg.indexer.rules.IndexRule;
import com.csg.indexer.rules.LongWordsRule;
import com.csg.indexer.rules.UppercaseStartCountRule;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java -jar java-indexer.jar <file1> <file2> ...");
            System.exit(1);
        }

        List<IndexRule> rules = new ArrayList<>();
        rules.add(new UppercaseStartCountRule());
        rules.add(new LongWordsRule(5));

        for (String fileArg : args) {
            Path path = Path.of(fileArg);
            
            try {
                String content = ContentExtractor.extractText(FileLoader.readBytes(path), path);
                System.out.println("=== File: " + path.toString() + " ===");

                for (IndexRule rule : rules) {
                    System.out.println(rule.name() + ":");
                    System.out.println(rule.apply(content));
                }

                System.out.println();
            }
            catch (Exception e) {
                System.err.println("Error processing file " + path + ": " + e.getMessage());
            }
        }
    }
}
