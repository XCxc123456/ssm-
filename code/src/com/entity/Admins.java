package com.entity;

public class Admins {
    private Integer id;

    private String username;

    private String password;
    
    private String zyurl;
    
    private String passwordNew;

    public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public String getZyurl() {
		return zyurl;
	}

	public void setZyurl(String zyurl) {
		this.zyurl = zyurl;
	}
}