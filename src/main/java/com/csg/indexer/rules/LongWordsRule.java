package com.csg.indexer.rules;

import com.csg.indexer.util.TextUtils;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LongWordsRule implements IndexRule {
    private final int minLength;

    public LongWordsRule(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public String name() {
        return "Rule#2 - LongWords(>" + minLength + ") (unique, sorted)";
    }

    @Override
    public String apply(String content) {
        Set<String> unique = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        unique.addAll(TextUtils.tokenizeWords(content).stream()
            .filter(w -> w.length() > minLength)
            .collect(Collectors.toSet())
        );

        // Return as comma-separated list, sorted case-insensitively then by natural tie-breaker
        return unique.stream()
            .sorted(Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.joining(", "));
    }
}
