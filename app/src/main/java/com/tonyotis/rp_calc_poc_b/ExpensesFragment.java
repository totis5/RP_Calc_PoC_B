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

/**
 * Created by Tony on 2/14/2016.
 */
public class ExpensesFragment extends Fragment {
    private House mHouse;
    private EditText mVacancyRateField;
    private EditText mHOIField;
    private EditText mPropertyTaxesField;
    private EditText mMaintCapExField;
    private Button mNextButton;

    public static ExpensesFragment newInstance(House house) {
        Bundle args = new Bundle();
        args.putSerializable("MyHouse", house);
        ExpensesFragment fragment = new ExpensesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHouse = (House) getArguments().getSerializable("MyHouse");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_expenses, container, false);

        mVacancyRateField = (EditText) v.findViewById(R.id.vacancy_percentage);
        mHOIField = (EditText) v.findViewById(R.id.insurance_dollars);
        mPropertyTaxesField = (EditText) v.findViewById(R.id.property_taxes_dollars);
        mMaintCapExField = (EditText) v.findViewById(R.id.maintenance_dollars);
        mNextButton = (Button) v.findViewById(R.id.next_button);

        mVacancyRateField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float vacancyRate;
                try {
                    vacancyRate = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    vacancyRate = 0;
                }

                mHouse.setVacancyRate(vacancyRate);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mHOIField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float hoi;
                try {
                    hoi = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    hoi = 0;
                }

                mHouse.setAnnualHOI(hoi);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPropertyTaxesField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float tax;
                try {
                    tax = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    tax = 0;
                }

                mHouse.setAnnualTax(tax);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMaintCapExField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float maintAndCapEx;
                try {
                    maintAndCapEx = Float.parseFloat(s.toString());
                } catch (NumberFormatException e) {
                    maintAndCapEx = 0;
                }

                mHouse.setAnnualMaintCapEx(maintAndCapEx);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = InputsActivity.newIntent(getActivity(), mHouse);
                startActivity(intent);
            }
        });

        return v;
    }

}
