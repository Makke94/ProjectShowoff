package com.example.marwe497.projectshowoff;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marwe497.carousel.Carousel;
import com.example.marwe497.carousel.ListItem;
import com.example.marwe497.passwordstrengthmeter.PasswordStrengthMeter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        Carousel carousel = findViewById(com.example.marwe497.carousel.R.id.carousel);

        final PasswordStrengthMeter psm = findViewById(R.id.psm);

        Button button = findViewById(R.id.button);

        ListItem i1 = new ListItem(com.example.marwe497.carousel.R.drawable.numb1, "numb1");
        ListItem i2 = new ListItem(com.example.marwe497.carousel.R.drawable.numb2, "numb2");
        ListItem i3 = new ListItem(com.example.marwe497.carousel.R.drawable.numb3, "numb3");
        ListItem i4 = new ListItem(com.example.marwe497.carousel.R.drawable.numb4, "numb4");
        ListItem i5 = new ListItem(com.example.marwe497.carousel.R.drawable.numb5, "numb5");
        ListItem i6 = new ListItem(com.example.marwe497.carousel.R.drawable.numb6, "numb6");
        ListItem i7 = new ListItem(com.example.marwe497.carousel.R.drawable.numb7, "numb7");
        ListItem i8 = new ListItem(com.example.marwe497.carousel.R.drawable.numb8, "numb8");
        ListItem i9 = new ListItem(com.example.marwe497.carousel.R.drawable.numb9, "numb9");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(psm.isAllowed()){
                    Toast.makeText(context, "Password OK!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Password not OK!", Toast.LENGTH_SHORT).show();
                }
            }
        });


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
