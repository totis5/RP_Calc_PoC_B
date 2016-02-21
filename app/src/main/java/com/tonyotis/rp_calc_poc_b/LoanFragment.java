package com.tonyotis.rp_calc_poc_b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Tony on 2/10/2016.
 */
public class LoanFragment extends Fragment {
    private House mHouse;
    private EditText mDownPaymentPercentField;
    private EditText mLoanAmountDollarsField;
    private EditText mInterestRateField;
    private EditText mLoanTermYearsField;
    private Button mNextButton;

    public static LoanFragment newInstance(House house) {
        Bundle args = new Bundle();
        args.putSerializable("MyHouse", house);
        LoanFragment fragment = new LoanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHouse = (House) getArguments().getSerializable("MyHouse");
        Toast.makeText(getActivity(),
                String.valueOf(mHouse.getMonthlyRent()), Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loan, container, false);

        mDownPaymentPercentField = (EditText) v.findViewById(R.id.down_pay_percentage);
        mLoanAmountDollarsField = (EditText) v.findViewById(R.id.loan_amount);
        mInterestRateField = (EditText) v.findViewById(R.id.interest_rate_percentage);
        mLoanTermYearsField = (EditText) v.findViewById(R.id.loan_term_years);
        mNextButton = (Button) v.findViewById(R.id.next_button);

        mDownPaymentPercentField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float downPayPct;
                try {
                    downPayPct = (Float.parseFloat(s.toString())) / 100;
                } catch (NumberFormatException e) {
                    downPayPct = 0;
                }
                float loanAmt = mHouse.getPurchasePrice() * ( 1 - downPayPct );
                //mHouse.mLoan1 = new Loan();
                if (mHouse.mLoan1 != null) {
                    mHouse.mLoan1.setAmount(loanAmt);
                }

                mLoanAmountDollarsField.setText(String.valueOf(loanAmt));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLoanAmountDollarsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float loanAmt;
                try {
                    loanAmt = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    loanAmt = 0;
                }

                if (mHouse.mLoan1 != null) {
                    mHouse.mLoan1.setAmount(loanAmt);
                }

                //float downPayPct = 1 - ( loanAmt / mHouse.getPurchasePrice() );
                //mDownPaymentPercent.setText(String.valueOf(downPayPct));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mInterestRateField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float intRate;
                try {
                    intRate = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    intRate = 0;
                }

                if (mHouse.mLoan1 != null) {
                    mHouse.mLoan1.setRate(intRate);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLoanTermYearsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float term;
                try {
                    term = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    term = 0;
                }

                if (mHouse.mLoan1 != null) {
                    mHouse.mLoan1.setTermYears(term);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CostsActivity.newIntent(getActivity(), mHouse);
                startActivity(intent);
            }
        });

        return v;
    }
}
