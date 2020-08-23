package com.example.wolframalphaclient.API;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "pod", strict = false)
public class OutputExpression {
    @Element(name = "plaintext", required = false)
    @Path("subpod")
    private String expression;


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
