package com.example.wolframalphaclient.API;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "pod", strict = false)
public class OutputExpression {
    @ElementList(name = "subpod", required = false, inline = true)
    private List<ExpressionModel> expression;


    public List<ExpressionModel> getExpression() {
        return expression;
    }

    public void setExpression(List<ExpressionModel> expression) {
        this.expression = expression;
    }
}
