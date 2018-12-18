package com.example.marwe497.carousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Carousel carousel = findViewById(R.id.carousel);

        ListItem i1 = new ListItem(R.drawable.numb1, "numb1");
        ListItem i2 = new ListItem(R.drawable.numb2, "numb2");
        ListItem i3 = new ListItem(R.drawable.numb3, "numb3");
        ListItem i4 = new ListItem(R.drawable.numb4, "numb4");
        ListItem i5 = new ListItem(R.drawable.numb5, "numb5");
        ListItem i6 = new ListItem(R.drawable.numb6, "numb6");
        ListItem i7 = new ListItem(R.drawable.numb7, "numb7");
        ListItem i8 = new ListItem(R.drawable.numb8, "numb8");
        ListItem i9 = new ListItem(R.drawable.numb9, "numb9");


        carousel.addItem(i1);
        carousel.addItem(i2);
        carousel.addItem(i3);
        carousel.addItem(i4);
        carousel.addItem(i5);
        carousel.addItem(i6);
        carousel.addItem(i7);
        carousel.addItem(i8);
        carousel.addItem(i9);

        carousel.setImgDimension(75, 100);



    }
}
