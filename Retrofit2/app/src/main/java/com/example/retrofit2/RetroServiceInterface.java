package com.example.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetroServiceInterface {

    @POST("users")
    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 04fb725a3c0aa4dce06d3993f62d7798395b2115f0255c3c4f0bb921bc1f06ac"})
    Call<UserResponse> createUser(@Body User params);

    @GET("users/{user}")
    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 04fb725a3c0aa4dce06d3993f62d7798395b2115f0255c3c4f0bb921bc1f06ac"})
    Call<UserResponse> getUser(@Path("user") String userId);


    @DELETE("users/{user}")
    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization: Bearer 04fb725a3c0aa4dce06d3993f62d7798395b2115f0255c3c4f0bb921bc1f06ac"})
    Call<UserResponse> deleteUser(@Path("user") String userId);

}
