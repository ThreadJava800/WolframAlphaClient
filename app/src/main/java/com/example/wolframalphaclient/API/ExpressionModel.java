package com.example.wolframalphaclient.API;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "subpod", strict = false)
public class ExpressionModel {
    @Element(name = "plaintext", required = false)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
