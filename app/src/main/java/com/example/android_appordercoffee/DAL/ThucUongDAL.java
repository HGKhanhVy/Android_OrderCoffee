package com.example.android_appordercoffee.DAL;

import static com.example.android_appordercoffee.API.ApiService.retrofit;

import com.example.android_appordercoffee.API.ApiService;
import com.example.android_appordercoffee.API.GetMaBanCallback;
import com.example.android_appordercoffee.API.GetThucUongCallback;
import com.example.android_appordercoffee.API.MaChucVuCallback;
import com.example.android_appordercoffee.DTO.BanDTO;
import com.example.android_appordercoffee.DTO.ThucUongDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThucUongDAL {
    ApiService apiService = retrofit.create(ApiService.class);

    public void getAllThucUong(final GetThucUongCallback callback) {
        Call<List<ThucUongDTO>> call = apiService.getAllThucUong();
        call.enqueue(new Callback<List<ThucUongDTO>>() {
            @Override
            public void onResponse(Call<List<ThucUongDTO>> call, Response<List<ThucUongDTO>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ArrayList<ThucUongDTO> listNuoc = new ArrayList<>();
                        for (ThucUongDTO t : response.body()) {
                            ThucUongDTO nc = new ThucUongDTO(t.getTenNuoc(), t.getGia());
                            listNuoc.add(nc);
                        }
                        callback.onSuccess(listNuoc);
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }
            @Override
            public void onFailure(Call<List<ThucUongDTO>> call, Throwable t) {
                callback.onError();
            }
        });
    }

    public void getMaNuoc(String tenNuoc, String size, final MaChucVuCallback callback) {
        Call<String> call = apiService.getMaNuoc(tenNuoc, size);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onError();
                    }
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
