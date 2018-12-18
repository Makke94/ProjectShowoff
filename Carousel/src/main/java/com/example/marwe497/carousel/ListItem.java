package com.example.marwe497.carousel;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ListItem {

    private int imgDrawable;

    private String text;

    public ListItem(int imgDrawable, String text) {
        this.imgDrawable = imgDrawable;

        this.text = text;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public View.OnClickListener onClickListener(final Context context){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Makes a little toast just to confirm you've clicked the item
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

            }
        };
    }

}
