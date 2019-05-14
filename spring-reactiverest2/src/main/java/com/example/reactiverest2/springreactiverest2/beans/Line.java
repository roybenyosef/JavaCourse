package com.example.reactiverest2.springreactiverest2.beans;

public class Line {

    private long index;
    private String content;

    public long getIndex() {
        return index;
    }
    public void setIndex(long index) {
        this.index = index;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Line [index=" + index + ", content=" + content + "]";
    }

}