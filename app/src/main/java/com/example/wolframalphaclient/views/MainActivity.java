package com.example.wolframalphaclient.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;


import com.example.wolframalphaclient.R;
import com.example.wolframalphaclient.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    public static String APIKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModel viewModel = new ViewModel(null, null);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setModel(viewModel);
        ((TextInputLayout) findViewById(R.id.inputLayout)).setEndIconOnClickListener(viewModel::onSearchIconClicked);

        APIKey = getApiKeyFromAsset();
    }

    String getApiKeyFromAsset(){
        byte[] buffer;
        try{
            InputStream inputStream = this.getAssets().open("apiKey.txt");
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String result = new String(buffer);
            inputStream.close();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
}