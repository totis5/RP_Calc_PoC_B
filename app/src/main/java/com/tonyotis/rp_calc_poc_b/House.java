package com.tonyotis.rp_calc_poc_b;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Toast;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Tony on 2/4/2016.
 */
public class House implements Serializable{

    private UUID mId;
    private float mPurchasePrice;
    private float mMonthlyRent;
    private Boolean mIsFinanced;
    public Loan mLoan1;
    private float mClosingCosts;
    private float mSellerPaidsPercent;
    private float mRehabDollars;
    private float mVacancyRate;
    private float mAnnualHOI;
    private float mAnnualTax;
    private float mAnnualMaintCapEx;

    private float mScheduledIncome;
    private float mMortgagePayment;
    private float mInsurancePayment;
    private float mTaxPayment;
    private float mMaintenancePayment;
    private float mCashFlow;
    private float mCashFlowAnnual;
    private float mCashRequired;
    private float mCoCReturn;




    public House() {
        mId = UUID.randomUUID();
    }

    public void calculateResults() {
        mScheduledIncome = mMonthlyRent * ( 1 - ( mVacancyRate / 100 ));
        mMortgagePayment = calculateMortgagePayment(mLoan1.getAmount(), mLoan1.getRate()/100, mLoan1.getTermYears());
        mInsurancePayment = mAnnualHOI / 12;
        mTaxPayment = mAnnualTax / 12;
        mMaintenancePayment = mAnnualMaintCapEx / 12;
        mCashFlow = calculateCashFlow(mScheduledIncome,mMortgagePayment,mInsurancePayment,mTaxPayment,mMaintenancePayment);
        mCashFlowAnnual = mCashFlow * 12;
        mCashRequired = mPurchasePrice - mLoan1.getAmount() + mClosingCosts + mRehabDollars - ( ( mSellerPaidsPercent / 100 ) * mPurchasePrice );
        mCoCReturn = 100 * ( mCashFlowAnnual / mCashRequired );


    }

    private float calculateMortgagePayment(float principal, float annualRate, float termYears) {
        float pmt;
        double i = (double)annualRate/12;
        double p = (double)principal;
        double l = (double)termYears * 12;

        pmt = (float) ( ( p * i ) / ( 1 - Math.pow( ( 1 + i ), -l ) ) );
        return pmt;
    }

    private float calculateCashFlow(float income, float mortgage, float insurance, float taxes, float maint) {
        float cf;
        cf = income - mortgage - insurance - taxes - maint;

        return cf;
    }


    public UUID getId() {
        return mId;
    }

    public float getPurchasePrice() {
        return mPurchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        mPurchasePrice = purchasePrice;
    }

    public float getMonthlyRent() {
        return mMonthlyRent;
    }

    public void setMonthlyRent(float monthlyRent) {
        mMonthlyRent = monthlyRent;
    }

    public Boolean isFinanced() {
        return mIsFinanced;
    }

    public void setIsFinanced(Boolean isFinanced) {
        mIsFinanced = isFinanced;

        if (isFinanced) {
            mLoan1 = new Loan();
        } else {
            mLoan1 = null;
        }

    }

    public Boolean getIsFinanced() {
        return mIsFinanced;
    }

    public Loan getLoan1() {
        return mLoan1;
    }

    public void setLoan1(Loan loan1) {
        mLoan1 = loan1;
    }

    public float getClosingCosts() {
        return mClosingCosts;
    }

    public void setClosingCosts(float closingCosts) {
        mClosingCosts = closingCosts;
    }

    public float getSellerPaidsPercent() {
        return mSellerPaidsPercent;
    }

    public void setSellerPaidsPercent(float sellerPaidsPercent) {
        mSellerPaidsPercent = sellerPaidsPercent;
    }

    public float getRehabDollars() {
        return mRehabDollars;
    }

    public void setRehabDollars(float rehabDollars) {
        mRehabDollars = rehabDollars;
    }

    public float getVacancyRate() {
        return mVacancyRate;
    }

    public void setVacancyRate(float vacancyRate) {
        mVacancyRate = vacancyRate;
    }

    public float getAnnualHOI() {
        return mAnnualHOI;
    }

    public void setAnnualHOI(float annualHOI) {
        mAnnualHOI = annualHOI;
    }

    public float getAnnualTax() {
        return mAnnualTax;
    }

    public void setAnnualTax(float annualTax) {
        mAnnualTax = annualTax;
    }

    public float getAnnualMaintCapEx() {
        return mAnnualMaintCapEx;
    }

    public void setAnnualMaintCapEx(float annualMaintCapEx) {
        mAnnualMaintCapEx = annualMaintCapEx;
    }

    public float getCoCReturn() {
        return mCoCReturn;
    }

    private void setCoCReturn(float coCReturn) {
        mCoCReturn = coCReturn;
    }

    public float getScheduledIncome() {
        return mScheduledIncome;
    }

    private void setScheduledIncome(float scheduledIncome) {
        mScheduledIncome = scheduledIncome;
    }

    public float getMortgagePayment() {
        return mMortgagePayment;
    }

    private void setMortgagePayment(float mortgagePayment) {
        mMortgagePayment = mortgagePayment;
    }

    public float getInsurancePayment() {
        return mInsurancePayment;
    }

    private void setInsurancePayment(float insurancePayment) {
        mInsurancePayment = insurancePayment;
    }

    public float getTaxPayment() {
        return mTaxPayment;
    }

    private void setTaxPayment(float taxPayment) {
        mTaxPayment = taxPayment;
    }

    public float getMaintenancePayment() {
        return mMaintenancePayment;
    }

    private void setMaintenancePayment(float maintenancePayment) {
        mMaintenancePayment = maintenancePayment;
    }

    public float getCashFlow() {
        return mCashFlow;
    }

    private void setCashFlow(float cashFlow) {
        mCashFlow = cashFlow;
    }

    public float getCashFlowAnnual() {
        return mCashFlowAnnual;
    }

    private void setCashFlowAnnual(float cashFlowAnnual) {
        mCashFlowAnnual = cashFlowAnnual;
    }

    public float getCashRequired() {
        return mCashRequired;
    }

    private void setCashRequired(float cashRequired) {
        mCashRequired = cashRequired;
    }
}
