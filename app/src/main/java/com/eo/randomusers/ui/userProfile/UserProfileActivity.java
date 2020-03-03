package com.eo.randomusers.ui.userProfile;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.databinding.DataBindingUtil;

import com.eo.randomusers.BaseActivity;
import com.eo.randomusers.R;
import com.eo.randomusers.databinding.ActivityUserProfileBinding;
import com.eo.randomusers.model.Results;

import static com.eo.randomusers.utils.Constants.PASS_DATA;

public class UserProfileActivity extends BaseActivity {
    public ActivityUserProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_profile);

        binding.setLifecycleOwner(this);

        binding.setVar((Results) getIntent().getSerializableExtra(PASS_DATA));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
