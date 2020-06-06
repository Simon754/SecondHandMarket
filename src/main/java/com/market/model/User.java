package com.market.model;

public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private Integer userauth;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getUserauth() {
        return userauth;
    }

    public void setUserauth(Integer userauth) {
        this.userauth = userauth;
    }
}