package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoaDonDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public void themHD(HoaDon_DTO hd, final AddBanCallback callback) {
        ApiService apiService = retrofit.create(ApiService.class);

        Call<String> call = apiService.themHD(hd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
