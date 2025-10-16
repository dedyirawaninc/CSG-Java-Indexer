package com.csg.indexer;

import java.nio.file.Path;

import com.csg.indexer.io.FileLoader;
import com.csg.indexer.parser.ContentExtractor;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java -jar java-indexer.jar <file1> <file2> ...");
            System.exit(1);
        }
        
        for (String fileArg : args) {
            Path path = Path.of(fileArg);
            try {
                byte[] fileBytes = FileLoader.readBytes(path);
                String extractedText = ContentExtractor.extractText(fileBytes, path);
                System.out.println("Extracted text from " + path + ":\n" + extractedText);
            }
            catch (Exception e) {
                System.err.println("Error processing file " + path + ": " + e.getMessage());
            }
        }
    }
}
