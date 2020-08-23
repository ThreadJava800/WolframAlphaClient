package com.example.wolframalphaclient.API;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "queryresult ", strict = false)
public class RSSModel {

    @ElementList(name = "pod", inline = true)
    private List<OutputExpression> answer;

    public List<OutputExpression> getAnswer() {
        return answer;
    }

    public void setAnswer(List<OutputExpression> answer) {
        this.answer = answer;
    }
}
