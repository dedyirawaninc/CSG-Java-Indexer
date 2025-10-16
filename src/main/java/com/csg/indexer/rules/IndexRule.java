package com.csg.indexer.rules;

public interface IndexRule {
    String name();
    String apply(String content);
}
