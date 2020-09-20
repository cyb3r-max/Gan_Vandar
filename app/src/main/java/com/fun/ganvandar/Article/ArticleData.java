package com.fun.ganvandar.Article;

import java.util.ArrayList;

public class ArticleData {

    private int total_rows;
    private ArrayList<Article> articles;

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}