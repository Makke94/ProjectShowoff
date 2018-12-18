package com.example.marwe497.carousel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class Carousel extends LinearLayout {

    private RecyclerView RecyclerView;
    private CircularAdapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private ArrayList<ListItem> itemList = new ArrayList<>();
    private SeekBar bar = new SeekBar(getContext());

    public Carousel(Context context) {
        super(context);
        init();
    }

    public Carousel(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Carousel(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Carousel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * Adds an item to the carousel
     * @param item
     * ListItem to display, with an Image, text and an OnClickListener
     */
    public void addItem(ListItem item){
        itemList.add(item);
        Adapter.notifyDataSetChanged(); //Tells the adapter the data is changed, so it redraws itself
    }

    /**
     *  Sets the image dimensions
     * @param width
     * Width in dp
     * @param height
     * Height in dp
     */

    public void setImgDimension(int width, int height){
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
        Adapter.setHeight(height);
        Adapter.setWidth(width);
    }

    private void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        RecyclerView = new RecyclerView(getContext());

        LayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.setLayoutManager(LayoutManager);

        Adapter = new CircularAdapter(itemList, getContext());
        RecyclerView.setAdapter(Adapter);

        RecyclerView.scrollToPosition(Integer.MAX_VALUE/2);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        RecyclerView.setLayoutParams(lp);

        RecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            //Calculates the true position of the item in the middle of the screen and translates it to a precentage and displays on the bar
            public void onScrolled(@NonNull android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);
                int firstPos = ((LinearLayoutManager)LayoutManager).findFirstVisibleItemPosition();



                int lastPos = ((LinearLayoutManager)LayoutManager).findLastVisibleItemPosition();

                int posDif = Math.abs(firstPos - lastPos)/2;

                lastPos -= posDif;

                lastPos = Math.abs(lastPos);

                lastPos = lastPos%((CircularAdapter)recyclerView.getAdapter()).getTrueLength();
                lastPos *= 100;

                lastPos /= ((CircularAdapter)recyclerView.getAdapter()).getTrueLength();
                bar.setProgress(lastPos, false);


            }
        });
        bar.setClickable(false);
        bar.setFocusableInTouchMode(false);
        bar.getThumb().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        //bar.animate();

        bar.setProgressTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        //Makes bar not touchable
        bar.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        this.addView(RecyclerView);
        this.addView(bar);
    }
}
