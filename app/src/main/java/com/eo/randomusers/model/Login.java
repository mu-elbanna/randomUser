package com.eo.randomusers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Login  implements Serializable {
    @Expose
    @SerializedName("sha256")
    private String sha256;
    @Expose
    @SerializedName("sha1")
    private String sha1;
    @Expose
    @SerializedName("md5")
    private String md5;
    @Expose
    @SerializedName("salt")
    private String salt;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("uuid")
    private String uuid;

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
