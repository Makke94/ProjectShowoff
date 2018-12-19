package com.example.marwe497.passwordstrengthmeter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PasswordStrengthMeter extends LinearLayout {

    public PasswordStrengthMeter(Context context) {
        super(context);
        init();
    }

    public PasswordStrengthMeter(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordStrengthMeter(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PasswordStrengthMeter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * Sets the PasswordStrengthMeter to a vertical layout
     */
    public void setVertical(){
        this.setOrientation(LinearLayout.VERTICAL);
    }

    /**
     * Sets the PasswordStrengthMeter to a horizontal
     */
    public void setHorizontal(){
        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    /**
     * Sets the text to the left/above the editText
     * @param text
     */
    public void setFirstText(String text){
        chooseApassword.setText(text);
    }

    /**
     * Sets the instruction text
     * @param text
     */
    public void setInst(String text){
        textInst.setText(text);
    }

    /**
     * Set the description text
     * @param text
     */
    public void setDesc(String text){
        bar.gettVDesc().setText(text);
    }

    /**
     * Sets the algoritm to use for calculating the password strength
     * Make sure that it only returns values that can be fullfilled by the conditions
     * Default: 0-100 and -1
     * @param algoritm
     * algoritm to use
     */
    public void setAlgoritm(AbstractPasswordAlgoritm algoritm) {
        this.algoritm = algoritm;
    }

    private AbstractPasswordAlgoritm algoritm;


    private TextView chooseApassword = new TextView(getContext());
    private LinearLayout vertLayout = new LinearLayout(getContext());
    private EditText edTxt = new EditText(getContext());
    private TextView textInst = new TextView(getContext());
    private ColorBar bar = new ColorBar(getContext());

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    private boolean allowed = false;

    @SuppressLint("ResourceType")
    private void init(){
        edTxt.setId(10);

        algoritm = new DefaultAlgoritm();
        this.setOrientation(LinearLayout.VERTICAL);
        chooseApassword.setText("Choose a password: ");
        vertLayout.setOrientation(LinearLayout.VERTICAL);
        edTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        textInst.setText("Minimum of 8 characters in length");
        textInst.setTextColor(Color.LTGRAY);
        vertLayout.addView(edTxt);
        vertLayout.addView(textInst);

        edTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                allowed = bar.checkStage(algoritm.getStrength(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        this.addView(chooseApassword);
        this.addView(vertLayout);
        this.addView(bar);
    }

}
