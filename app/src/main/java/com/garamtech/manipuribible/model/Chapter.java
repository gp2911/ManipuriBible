package com.garamtech.manipuribible.model;

import java.util.List;

/**
 * Created by gp on 2/9/15.
 */

/**
 * POJO for Chapter item
 */
public class Chapter {

    //chapter number in that book
    private int num;

    //List of verses
    private List<Verse> verses;

    /**
     * Getters and Setters
     */

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }
}
