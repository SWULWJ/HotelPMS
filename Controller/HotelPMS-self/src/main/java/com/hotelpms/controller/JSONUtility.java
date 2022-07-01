package com.hotelpms.controller;

public class JSONUtility {
    private String result;
    private String path;

    public JSONUtility(String result, String path){
        this.result = result;
        this.path = path;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
