package com.garamtech.manipuribible.model;

/**
 * Created by gp on 2/9/15.
 */

/**
 * POJO for Verse item
 */

public class Verse {

    //verse number in that chapter
    private int num;

    //text of the verse
    private String text;

    /**
     * Getters and Setters
     */

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
