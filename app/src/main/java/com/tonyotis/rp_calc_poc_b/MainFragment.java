package com.tonyotis.rp_calc_poc_b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Tony on 2/4/2016.
 */
public class MainFragment extends Fragment{
    private House mHouse;
    private EditText mPurchasePriceField;
    private EditText mRentField;
    private RadioGroup mIsFinancedRadioGroup;
    private Button mNextButton;

    private void setDefaults() {
        mHouse.setPurchasePrice(Float.parseFloat(getResources().getString(R.string.default_purchase_price)));
        mHouse.setMonthlyRent(Float.parseFloat(getResources().getString(R.string.default_rent)));
        mHouse.setIsFinanced(true);
        Loan loan = new Loan();
        loan.setAmount(mHouse.getPurchasePrice() * (1 - (Float.parseFloat(getResources().getString(R.string.default_down_percent)) / 100)));
        loan.setRate(Float.parseFloat(getResources().getString(R.string.default_interest_rate)));
        loan.setTermYears(Float.parseFloat(getResources().getString(R.string.default_loan_term)));
        mHouse.setLoan1(loan);
        /*mHouse.mLoan1.setAmount(mHouse.getPurchasePrice() * (1 - (Float.parseFloat(getResources().getString(R.string.default_down_percent)) / 100)));
        mHouse.mLoan1.setRate(Float.parseFloat(getResources().getString(R.string.default_interest_rate)));
        mHouse.mLoan1.setTermYears(Float.parseFloat(getResources().getString(R.string.default_loan_term)));*/
        mHouse.setClosingCosts(Float.parseFloat(getResources().getString(R.string.default_closing_costs)));
        mHouse.setSellerPaidsPercent(Float.parseFloat(getResources().getString(R.string.default_seller_paids_percent)));
        mHouse.setRehabDollars(Float.parseFloat(getResources().getString(R.string.default_rehab_budget)));
        mHouse.setVacancyRate(Float.parseFloat(getResources().getString(R.string.default_vacancy_rate)));
        mHouse.setAnnualHOI(Float.parseFloat(getResources().getString(R.string.default_HOI_premium)));
        mHouse.setAnnualTax(Float.parseFloat(getResources().getString(R.string.default_property_taxes)));
        mHouse.setAnnualMaintCapEx(Float.parseFloat(getResources().getString(R.string.default_maint_cap_ex)));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHouse = new House();

        setDefaults();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mPurchasePriceField = (EditText)v.findViewById(R.id.purchase_price);
        mRentField = (EditText)v.findViewById(R.id.rent);
        mIsFinancedRadioGroup = (RadioGroup)v.findViewById(R.id.finance_true);
        mNextButton = (Button)v.findViewById(R.id.next_button);

        mPurchasePriceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    mHouse.setPurchasePrice(Float.parseFloat(s.toString()));
                } catch (NumberFormatException e) {
                    mHouse.setPurchasePrice(0);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                //left intentionally blank
            }
        });


        mRentField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //left intentionally blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    mHouse.setMonthlyRent(Float.parseFloat(s.toString()));
                } catch (NumberFormatException e) {
                    mHouse.setMonthlyRent(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //left intentionally blank
            }
        });

        mIsFinancedRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = mIsFinancedRadioGroup.getCheckedRadioButtonId();
                //Toast.makeText(getActivity(), "true", Toast.LENGTH_SHORT).show();

                if (selectedId == R.id.finance_yes) {
                    mHouse.setIsFinanced(true);
                    //Toast.makeText(getActivity(), "true", Toast.LENGTH_SHORT).show();
                } else if (selectedId == R.id.finance_no) {
                    mHouse.setIsFinanced(false);
                    //Toast.makeText(getActivity(), "false", Toast.LENGTH_SHORT).show();
                } else {
                    mHouse.setIsFinanced(null);
                }
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoanActivity.newIntent(getActivity(), mHouse);
                startActivity(intent);
            }
        });

        return v;
    }

}
