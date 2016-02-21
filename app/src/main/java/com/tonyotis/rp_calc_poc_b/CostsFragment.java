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
 * Created by Tony on 2/12/2016.
 */
public class CostsFragment extends Fragment{
    private House mHouse;
    private EditText mClosingCostsField;
    private EditText mSellerPaidsField;
    private EditText mRehabField;
    private Button mNextButton;

    public static CostsFragment newInstance(House house) {
        Bundle args = new Bundle();
        args.putSerializable("MyHouse", house);
        CostsFragment fragment = new CostsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHouse = (House) getArguments().getSerializable("MyHouse");
        //Toast.makeText(getActivity(), String.valueOf(mHouse.mLoan1.getAmount()), Toast.LENGTH_SHORT).show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_costs, container, false);

        mClosingCostsField = (EditText) v.findViewById(R.id.closing_costs_dollar);
        mSellerPaidsField = (EditText) v.findViewById(R.id.seller_paids_percentage);
        mRehabField = (EditText) v.findViewById(R.id.rehab_budget_dollars);
        mNextButton = (Button) v.findViewById(R.id.next_button);

        mClosingCostsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float closingCosts;
                try {
                    closingCosts = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    closingCosts = 0;
                }

                mHouse.setClosingCosts(closingCosts);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSellerPaidsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float sellerPaidsPct;
                try {
                    sellerPaidsPct = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    sellerPaidsPct = 0;
                }

                mHouse.setSellerPaidsPercent(sellerPaidsPct);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRehabField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float rehabBudget;
                try {
                    rehabBudget = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    rehabBudget = 0;
                }

                mHouse.setRehabDollars(rehabBudget);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ExpensesActivity.newIntent(getActivity(), mHouse);
                startActivity(intent);
            }
        });

        return v;
    }
}
