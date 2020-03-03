package com.eo.randomusers.ui.usersList;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.eo.randomusers.R;
import com.eo.randomusers.model.NetworkState;
import com.eo.randomusers.model.Results;
import com.eo.randomusers.model.UsersResponse;
import com.eo.randomusers.rest.ApiClient;
import com.eo.randomusers.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.eo.randomusers.BaseActivity.isNetworkAvailable;
import static com.eo.randomusers.utils.Constants.FAILED;
import static com.eo.randomusers.utils.Constants.RUNNING;
import static com.eo.randomusers.utils.Constants.SUCCESS;

public class UserListVM extends AndroidViewModel {

    private MutableLiveData<NetworkState> networkStateMutableLiveData;
    private MutableLiveData<ArrayList<Results>> usersResponseMutableLiveData;

    public UserListVM(@NonNull Application application) {
        super(application);

        networkStateMutableLiveData = new MutableLiveData<>();
        usersResponseMutableLiveData = new MutableLiveData<>();

        getUsersList(5);
    }

     MutableLiveData<ArrayList<Results>> getUsersResponseMutableLiveData() {
        return usersResponseMutableLiveData;
    }

     MutableLiveData<NetworkState> getNetworkStateMutableLiveData() {
        return networkStateMutableLiveData;
    }

    void getUsersList(int count)
    {
        if (isNetworkAvailable(getApplication())) {
            networkStateMutableLiveData.postValue(new NetworkState(RUNNING));

            ApiInterface apiService = ApiClient.getClient(60, 30, 30).create(ApiInterface.class);

            Call<UsersResponse> call = apiService.getUsersList(count);
            call.enqueue(new Callback<UsersResponse>() {
                @Override
                public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                    if (response.isSuccessful()) {
                        usersResponseMutableLiveData.postValue(response.body().getResults());

                        networkStateMutableLiveData.postValue(new NetworkState(SUCCESS));
                    } else {
                        networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.error_getting_data)));
                    }
                }

                @Override
                public void onFailure(Call<UsersResponse> call, Throwable t) {
                    t.printStackTrace();
                    networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.error_getting_data)));
                }
            });

        } else {
            networkStateMutableLiveData.postValue(new NetworkState(FAILED, getApplication().getString(R.string.no_net)));
        }
    }
}