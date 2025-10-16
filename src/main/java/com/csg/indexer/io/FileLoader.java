package com.csg.indexer.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLoader {
    public static byte[] readBytes(Path path) throws IOException {
        return Files.readAllBytes(path);
    }
}
