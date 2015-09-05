package com.garamtech.manipuribible.model;

import java.util.List;

/**
 * Created by gp on 2/9/15.
 */

/**
 * POJO for Book item (Eg. Ruth, Exo, etc.)
 */
public class Book {

    //prefix
    private String pre;

    //name in Manipuri
    private String name;

    //List of chapters
    private List<Chapter> chapters;

    /**
     * Getters and Setters
     */
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }
}
