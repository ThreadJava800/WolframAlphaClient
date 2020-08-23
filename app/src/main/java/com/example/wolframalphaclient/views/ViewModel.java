package com.example.wolframalphaclient.views;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.example.wolframalphaclient.API.Controller;
import com.example.wolframalphaclient.R;

import java.util.ArrayList;

public class ViewModel {
    private String inputExpression;
    private ObservableField<String> outputExpression = new ObservableField<>();

    public void setInputExpression(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public ObservableField<String> getOutputExpression() {
        return outputExpression;
    }

    public void setOutputExpression(String outputExpression) {
        this.outputExpression.set(outputExpression);
    }

    public void setOutputExpression(ArrayList<String> outputExpression) {
        StringBuilder result = new StringBuilder();
        for (String i : outputExpression) {
            if (!i.equals("null" + '\n' + '\n')) {
                result.append(i);
            }
        }
        setOutputExpression(result.toString());
    }

    public ViewModel(String inputExpression, String outputExpression) {
        this.inputExpression = inputExpression;
        this.outputExpression.set(outputExpression);
    }

    public String getInputExpression() {
        return inputExpression;
    }

    public void onSearchIconClicked(View view) {
        if (inputExpression == null) {
            Toast.makeText(view.getContext(), R.string.enter_expression, Toast.LENGTH_LONG).show();
        } else {
            Controller controller = new Controller(this, inputExpression);
            controller.run();
        }

    }
}
