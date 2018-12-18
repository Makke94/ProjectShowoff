package com.example.marwe497.passwordstrengthmeter;

public abstract class AbstractCondStage {

    /**
     * Color for the bar
     */
    private int Color;
    /**
     * Text to display
     */
    private String text;
    /**
     * Color for the text
     */
    private int textColor;

    public AbstractCondStage() {
        init();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    /**
     * Between 0-100, how long the colored part of the bar should be
     */
    private int length;
    /**
     * If the password is passable, i.e. strong enough
     */
    private  boolean allowed;

    /**
     * Should return if the condition is fullfilled for the supplied strength
     * The default algoritm return a value btween 0-100 and -1 if the string is too short
     * @param strength
     * the strength of the password
     * @return
     * if the condition is fulfilled or not
     */
    public abstract boolean isSatisfied(int strength);

    /**
     * Initilizes all values
     * must set the values of text, color, textColor, allowed, and length
     */
    public abstract void init();

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}