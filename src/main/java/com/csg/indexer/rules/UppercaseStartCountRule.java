package com.csg.indexer.rules;

import com.csg.indexer.util.TextUtils;

public class UppercaseStartCountRule implements IndexRule {
    @Override
    public String name() {
        return "Rule#1 - WordsStartingWithUppercase (count)";
    }

    @Override
    public String apply(String content) {
        long count = TextUtils.tokenizeWords(content).stream()
            .filter(w -> !w.isEmpty())
            .filter(w -> Character.isUpperCase(w.codePointAt(0)))
            .count();

        return String.valueOf(count);
    }
}
