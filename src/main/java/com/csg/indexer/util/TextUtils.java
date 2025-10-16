package com.csg.indexer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {
    // Unicode-aware word regex: sequences of letters/digits/underscores considered words;
    private static final Pattern WORD = Pattern.compile("\\b[\\p{L}\\p{Nd}_]+\\b");

    public static List<String> tokenizeWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher m = WORD.matcher(text);

        while (m.find()) {
            words.add(m.group());
        }

        return words;
    }
}
