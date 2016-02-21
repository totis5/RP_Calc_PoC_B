package com.tonyotis.rp_calc_poc_b;

import java.io.Serializable;

/**
 * Created by Tony on 2/12/2016.
 */
public class Loan implements Serializable {

    private float mAmount;
    private float mRate;
    private float mTermYears;

    public Loan() {

    }

    public float getAmount() {
        return mAmount;
    }

    public void setAmount(float amount) {
        mAmount = amount;
    }

    public float getRate() {
        return mRate;
    }

    public void setRate(float rate) {
        mRate = rate;
    }

    public float getTermYears() {
        return mTermYears;
    }

    public void setTermYears(float termYears) {
        mTermYears = termYears;
    }
}
