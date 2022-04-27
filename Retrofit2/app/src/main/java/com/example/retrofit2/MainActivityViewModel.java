package com.example.retrofit2;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<UserResponse> createNewUserLiveData;

    private RetroServiceInterface retroServiceInterface;

    public MainActivityViewModel() {
        createNewUserLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<UserResponse> getCreateUserObserver() {
        return createNewUserLiveData;
    }

    public void createNewUser (User user) {
        retroServiceInterface = RetroInstance.getRetroInstance().create(RetroServiceInterface.class);
        Call<UserResponse> call = retroServiceInterface.createUser(user);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    createNewUserLiveData.postValue(response.body());
                }else {
                    createNewUserLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                createNewUserLiveData.postValue(null);
            }
        });
    }

    public void getUser(String userId){
        retroServiceInterface = RetroInstance.getRetroInstance().create(RetroServiceInterface.class);
        Call<UserResponse> call = retroServiceInterface.getUser(userId);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    Log.d("MainActivity : getUser", "Success" + response.body() );
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("MainActivity : getUser", "onFailure" + t.getMessage());
            }
        });
    }

    public void deleteUser(String userId){
        retroServiceInterface = RetroInstance.getRetroInstance().create(RetroServiceInterface.class);
        Call<UserResponse> call = retroServiceInterface.deleteUser(userId);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    Log.d("MainActivity : delete", "Success" + response.body() );
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("MainActivity : delete", "onFailure" + t.getMessage());
            }
        });
    }

}
