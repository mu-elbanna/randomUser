package com.eo.randomusers.ui.usersList;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.eo.randomusers.BaseActivity;
import com.eo.randomusers.R;
import com.eo.randomusers.databinding.ActivityUsersListBinding;
import com.eo.randomusers.model.NetworkState;
import com.eo.randomusers.model.Results;
import com.eo.randomusers.ui.userProfile.UserProfileActivity;

import java.util.ArrayList;

import static com.eo.randomusers.utils.Constants.FAILED;
import static com.eo.randomusers.utils.Constants.PASS_DATA;
import static com.eo.randomusers.utils.Constants.RUNNING;
import static com.eo.randomusers.utils.Constants.SUCCESS;

public class UsersListActivity extends BaseActivity {
    public UserListVM vm;
    public ActivityUsersListBinding binding;
    private UsersListAdapter usersListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_users_list);

        vm = ViewModelProviders.of(this).get(UserListVM.class);

        binding.setLifecycleOwner(this);

        binding.mainView.addView(progressBar);

        vm.getNetworkStateMutableLiveData().observe(this, this::onChangedNetwork);
        vm.getUsersResponseMutableLiveData().observe(this, this::onChangedData);

        binding.pullToRefresh.setOnRefreshListener(() -> {
            vm.getUsersList(3);
        });

        setUsersListAdapter();
    }

    private void onChangedData(ArrayList<Results> results) {
        if (results != null) {
            usersListAdapter.updateItems(results);
        }
    }

    private void setUsersListAdapter() {
        UsersListCallBack callBack = data -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable(PASS_DATA, data);
            gotoActivity(UsersListActivity.this, UserProfileActivity.class, false, bundle, false);
        };

        binding.rcvUserList.setItemAnimator(new DefaultItemAnimator());

        usersListAdapter = new UsersListAdapter(new ArrayList<>(), callBack);
        binding.rcvUserList.setAdapter(usersListAdapter);
    }

    private void onChangedNetwork(@Nullable NetworkState networkState) {
        if (networkState != null) {
            switch (networkState.getStatus()) {
                case RUNNING:
                    showProgress();
                    break;

                case SUCCESS:
                    hideProgress();
                    binding.pullToRefresh.setRefreshing(false);
                    binding.rcvUserList.smoothScrollToPosition(usersListAdapter.getItemCount() - 3);
                    break;

                case FAILED:
                    hideProgress();
                    binding.pullToRefresh.setRefreshing(false);
                    showMsg(networkState.getPayLoad());
                    break;
            }
        }
    }
}
