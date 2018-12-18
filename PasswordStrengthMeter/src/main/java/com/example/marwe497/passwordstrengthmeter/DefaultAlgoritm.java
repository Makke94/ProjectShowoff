package com.example.marwe497.passwordstrengthmeter;

public class DefaultAlgoritm extends AbstractPasswordAlgoritm {
    @Override
    /**
     * Default implementation of a PasswordAlgorithm
     */
    public int getStrength(String password) {

        if(password.length() < 8){
            return -1;
        }

        int strength = 0;

        for (int i = 0; i<password.length(); i++){
            strength += (int)password.charAt(i);
        }

        strength = strength/30;

        if(strength > 100){
            strength = 100;
        }

        return strength;
    }
}
