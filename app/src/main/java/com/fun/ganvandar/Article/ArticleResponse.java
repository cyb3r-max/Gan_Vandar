package com.fun.ganvandar.Article;

public class ArticleResponse {

    private boolean status;
    private ArticleData data;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArticleData getData() {
        return data;
    }

    public void setData(ArticleData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
