package com.entity;

public class Ruku {
    private Integer id;

    private String zuoyexxname;

    private String typesname;

    private String teachername;

    private Integer shuliang;

    private String zyurl;

    private String zt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZuoyexxname() {
        return zuoyexxname;
    }

    public void setZuoyexxname(String zuoyexxname) {
        this.zuoyexxname = zuoyexxname == null ? null : zuoyexxname.trim();
    }

    public String getTypesname() {
        return typesname;
    }

    public void setTypesname(String typesname) {
        this.typesname = typesname == null ? null : typesname.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public Integer getShuliang() {
        return shuliang;
    }

    public void setShuliang(Integer shuliang) {
        this.shuliang = shuliang;
    }

    public String getZyurl() {
        return zyurl;
    }

    public void setZyurl(String zyurl) {
        this.zyurl = zyurl == null ? null : zyurl.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }
}