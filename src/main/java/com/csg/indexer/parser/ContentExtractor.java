package com.csg.indexer.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ContentExtractor {
    public static String extractText(byte[] bytes, Path path) {
        String name = path.getFileName().toString().toLowerCase();
        String raw = new String(bytes, StandardCharsets.UTF_8);

        if (name.endsWith(".html") || name.endsWith(".htm")) {
            // Parse HTML to text using jsoup
            Document doc = Jsoup.parse(raw);
            // Keep only visible text
            return Jsoup.clean(doc.text(), Safelist.none());
        }
        
        // Default: treat as plain text
        return raw;
    }
}
