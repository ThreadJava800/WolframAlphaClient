package com.example.wolframalphaclient.API;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.wolframalphaclient.R;
import com.example.wolframalphaclient.views.MainActivity;
import com.example.wolframalphaclient.views.ViewModel;

import java.io.InputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Controller implements Callback<RSSModel> {
    private String request_url;
    private StringBuilder expression = new StringBuilder();
    private ViewModel viewModel;

    public Controller(ViewModel viewModel, String request_url) {
        this.viewModel = viewModel;
        this.request_url = request_url;
    }

    public String getRequest_url() {
        return request_url;
    }

    public String getExpression() {
        return expression.toString();
    }


    public void run() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.wolframalpha.com/v2/")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
        WolframAPI wolframAPI = retrofit.create(WolframAPI.class);
        Call<RSSModel> call = wolframAPI.getAnswer(request_url, MainActivity.APIKey);
        call.enqueue(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<RSSModel> call, Response<RSSModel> response) {
        if (response.isSuccessful()) {
            RSSModel model = response.body();
            model.getAnswer().forEach(answer -> {
                answer.getExpression().forEach(text -> {
                    if (text.getText() != null) {
                        expression.append(text.getText()).append('\n').append('\n');
                    }
                });
            });
        } else {
            expression.append("Invalid request. Try again!");
        }
        viewModel.setOutputExpression(expression.toString());
        viewModel.setIsLoading(false);
    }

    @Override
    public void onFailure(Call<RSSModel> call, Throwable t) {
        expression.append("Invalid request. Try again!");
        viewModel.setOutputExpression(expression.toString());
        viewModel.setIsLoading(false);
    }
}
