package com.market.model;

public class Item {
    private Integer itemid;

    private String itemname;

    private String itemprice;

    private String itemstatus;

    private String iteminfo;

    private String itempic;

    private Integer userid;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice == null ? null : itemprice.trim();
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus == null ? null : itemstatus.trim();
    }

    public String getIteminfo() {
        return iteminfo;
    }

    public void setIteminfo(String iteminfo) {
        this.iteminfo = iteminfo == null ? null : iteminfo.trim();
    }

    public String getItempic() {
        return itempic;
    }

    public void setItempic(String itempic) {
        this.itempic = itempic == null ? null : itempic.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}