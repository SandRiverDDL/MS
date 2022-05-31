package com.ms.model;

import java.util.Date;

public class Note {
    private Integer n_id;
    private Date n_date;
    private String n_title;
    private String n_context;

    public Integer getN_id() {
        return n_id;
    }

    public void setN_id(Integer n_id) {
        this.n_id = n_id;
    }

    public Date getN_date() {
        return n_date;
    }

    public void setN_date(Date n_date) {
        this.n_date = n_date;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_context() {
        return n_context;
    }

    public void setN_context(String n_context) {
        this.n_context = n_context;
    }
}
