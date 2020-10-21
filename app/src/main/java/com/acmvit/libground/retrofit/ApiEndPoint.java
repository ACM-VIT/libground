package com.acmvit.libground.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("random")
    Call<ApiResponse> getData();

}
