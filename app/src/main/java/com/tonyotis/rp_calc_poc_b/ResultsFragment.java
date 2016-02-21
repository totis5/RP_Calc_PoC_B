package com.tonyotis.rp_calc_poc_b;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by Tony on 2/17/2016.
 */
public class ResultsFragment extends Fragment {
    private House mHouse;
    private TextView mScheduledIncomeView;
    private TextView mMortgagePaymentView;
    private TextView mInsuranceView;
    private TextView mPropertyTaxesView;
    private TextView mMaintenanceView;
    private TextView mCashFlowView;
    private TextView mCashFlowAnnualView;
    private TextView mCashReqView;
    private TextView mCoCReturnView;

    public static ResultsFragment newInstance(House house) {
        Bundle args = new Bundle();
        args.putSerializable("MyHouse", house);
        ResultsFragment fragment = new ResultsFragment();
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
        View v = inflater.inflate(R.layout.fragment_results, container, false);

        mScheduledIncomeView = (TextView) v.findViewById(R.id.scheduled_income);
        mMortgagePaymentView = (TextView) v.findViewById(R.id.mortage_payment);
        mInsuranceView = (TextView) v.findViewById(R.id.insurance_payment);
        mPropertyTaxesView = (TextView) v.findViewById(R.id.tax_payment);
        mMaintenanceView = (TextView) v.findViewById(R.id.maintenance);
        mCashFlowView = (TextView) v.findViewById(R.id.cash_flow);
        mCashFlowAnnualView = (TextView) v.findViewById(R.id.cash_flow_annual);
        mCashReqView = (TextView) v.findViewById(R.id.money_down);
        mCoCReturnView = (TextView) v.findViewById(R.id.coc_return);

        mHouse.calculateResults();

        mScheduledIncomeView.setText(String.valueOf(mHouse.getScheduledIncome()));
        mMortgagePaymentView.setText(String.valueOf(mHouse.getMortgagePayment()));
        mInsuranceView.setText(String.valueOf(mHouse.getInsurancePayment()));
        mPropertyTaxesView.setText(String.valueOf(mHouse.getTaxPayment()));
        mMaintenanceView.setText(String.valueOf(mHouse.getMaintenancePayment()));
        mCashFlowView.setText(String.valueOf(mHouse.getCashFlow()));
        mCashFlowAnnualView.setText(String.valueOf(mHouse.getCashFlowAnnual()));
        mCashReqView.setText(String.valueOf(mHouse.getCashRequired()));
        mCoCReturnView.setText(String.valueOf(mHouse.getCoCReturn()));

        return v;
    }
}
