package com.tonyotis.rp_calc_poc_b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tony on 2/15/2016.
 */
public class InputsFragment extends Fragment {
    private House mHouse;
    private TextView mPurchasePriceView;
    private TextView mRentView;
    private TextView mFinancedView;
    private TextView mLoanAmountView;
    private TextView mInterestRateView;
    private TextView mLoanTermView;
    private TextView mClosingCostsView;
    private TextView mSellerPaidsView;
    private TextView mRehabBudgetView;
    private TextView mVacancyRateView;
    private TextView mInsuranceView;
    private TextView mPropertyTaxesView;
    private TextView mMaintenanceView;
    private Button mNextButton;


    public static InputsFragment newInstance(House house) {
        Bundle args = new Bundle();
        args.putSerializable("MyHouse", house);
        InputsFragment fragment = new InputsFragment();
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
        View v = inflater.inflate(R.layout.fragment_inputs, container, false);

        mPurchasePriceView = (TextView) v.findViewById(R.id.purchase_price_input);
        mPurchasePriceView.setText(String.valueOf(mHouse.getPurchasePrice()));
        mRentView = (TextView) v.findViewById(R.id.monthly_rent_input);
        mRentView.setText(String.valueOf(mHouse.getMonthlyRent()));
        mFinancedView = (TextView) v.findViewById(R.id.financed_input);
        String s = "False";
        if (mHouse.getIsFinanced()) {
            s = "True";
        }
        mFinancedView.setText(s);
        mLoanAmountView = (TextView) v.findViewById(R.id.loan_amount_input);
        mLoanAmountView.setText(String.valueOf(mHouse.getLoan1().getAmount()));
        mInterestRateView = (TextView) v.findViewById(R.id.interest_rate_input);
        mInterestRateView.setText(String.valueOf(mHouse.getLoan1().getRate()));
        mLoanTermView = (TextView) v.findViewById(R.id.loan_term_input);
        mLoanTermView.setText(String.valueOf(mHouse.getLoan1().getTermYears()));
        mClosingCostsView = (TextView) v.findViewById(R.id.closing_costs_input);
        mClosingCostsView.setText(String.valueOf(mHouse.getClosingCosts()));
        mSellerPaidsView = (TextView) v.findViewById(R.id.seller_paids_input);
        mSellerPaidsView.setText(String.valueOf(mHouse.getSellerPaidsPercent()));
        mRehabBudgetView = (TextView) v.findViewById(R.id.rehab_budget_input);
        mRehabBudgetView.setText(String.valueOf(mHouse.getRehabDollars()));
        mVacancyRateView = (TextView) v.findViewById(R.id.vacancy_rate_input);
        mVacancyRateView.setText(String.valueOf(mHouse.getVacancyRate()));
        mInsuranceView = (TextView) v.findViewById(R.id.insurance_input);
        mInsuranceView.setText(String.valueOf(mHouse.getAnnualHOI()));
        mPropertyTaxesView = (TextView) v.findViewById(R.id.property_tax_input);
        mPropertyTaxesView.setText(String.valueOf(mHouse.getAnnualTax()));
        mMaintenanceView = (TextView) v.findViewById(R.id.maintenance_input);
        mMaintenanceView.setText(String.valueOf(mHouse.getAnnualMaintCapEx()));

        mNextButton = (Button)v.findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ResultsActivity.newIntent(getActivity(), mHouse);
                startActivity(intent);
            }
        });



        return v;
    }
}

