package com.deepakshankar.ilovezappos.model;

import java.io.Serializable;
import java.util.List;

/**
 * This is the class that is used as a POJO class to hold the JSON object that ZAppos API returns.
 * Created by DeepakShankar on 1/28/2017.
 */

public class Result implements Serializable {

    private String originalTerm;
    private int currentResultCount;
    private int totalResultCount;
    private String term;
    private List<Product> results;

    public String getOriginalTerm() {
        return originalTerm;
    }

    public void setOriginalTerm(String originalTerm) {
        this.originalTerm = originalTerm;
    }

    public int getCurrentResultCount() {
        return currentResultCount;
    }

    public void setCurrentResultCount(int currentResultCount) {
        this.currentResultCount = currentResultCount;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private int statusCode;
}
