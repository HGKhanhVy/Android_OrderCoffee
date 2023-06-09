package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import com.example.android_appordercoffee.API.AddBanCallback;
import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.DTO.CT_HoaDon_DTO;
import com.example.android_appordercoffee.DTO.HoaDon_DTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CT_HoaDonDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public static void themCT_HD(CT_HoaDon_DTO hd, final AddBanCallback callback) {
        ApiService apiService = retrofit.create(ApiService.class);

        Call<String> call = apiService.themCT_HD(hd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
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
