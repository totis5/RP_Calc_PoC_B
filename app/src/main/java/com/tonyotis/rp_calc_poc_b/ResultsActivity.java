package com.tonyotis.rp_calc_poc_b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Tony on 2/17/2016.
 */
public class ResultsActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext, House house) {
        Intent intent = new Intent(packageContext, ResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("MyHouse", house);
        intent.putExtras(bundle);

        return intent;
    }

    protected Fragment createFragment() {
        House house = (House) getIntent().getSerializableExtra("MyHouse");
        return ResultsFragment.newInstance(house);
    }

}
