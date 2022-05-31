package com.ms.model;

public class Problem {
    private Integer p_id;
    private String p_context;
    private String p_url;
    private String p_type;
    private String p_from;

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getP_from() {
        return p_from;
    }

    public void setP_from(String p_from) {
        this.p_from = p_from;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_context() {
        return p_context;
    }

    public void setP_context(String p_context) {
        this.p_context = p_context;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }
}
