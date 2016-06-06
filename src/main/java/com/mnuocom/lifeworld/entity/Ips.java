package com.mnuocom.lifeworld.entity;

import java.util.Date;

public class Ips {
    private Integer id;

    private String ip;

    private String ipType;

    private String ipAddress;

    private String ipType1;

    private String ipBusiness;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType == null ? null : ipType.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getIpType1() {
        return ipType1;
    }

    public void setIpType1(String ipType1) {
        this.ipType1 = ipType1 == null ? null : ipType1.trim();
    }

    public String getIpBusiness() {
        return ipBusiness;
    }

    public void setIpBusiness(String ipBusiness) {
        this.ipBusiness = ipBusiness == null ? null : ipBusiness.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}