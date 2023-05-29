package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CommentImpl implements Comment {

    public static final int CONTENT_LEN_MIN = 3;
    public static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = String.format(
            "Content must be between %d and %d characters long!",
            CONTENT_LEN_MIN,
            CONTENT_LEN_MAX);

    private String content;
    private String author;

    public CommentImpl(String content, String author) {
        setContent(content);
        this.author = author;
    }

    @Override
    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        validateContent(content);
        this.content = content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    private void validateContent(String content) {
        ValidationHelpers.validateIntRange(content.length(), CONTENT_LEN_MIN, CONTENT_LEN_MAX, CONTENT_LEN_ERR);
    }

    @Override
    public String toString() {
        return String.format("%n----------%n%s%nUser: %s%n----------",
                getContent(),
                getAuthor());
    }
}