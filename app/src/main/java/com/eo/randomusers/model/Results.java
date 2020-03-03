package com.eo.randomusers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Results implements Serializable {
    @Expose
    @SerializedName("nat")
    private String nat;
    @Expose
    @SerializedName("picture")
    private Picture picture;
    @Expose
    @SerializedName("id")
    private Id id;
    @Expose
    @SerializedName("cell")
    private String cell;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("registered")
    private Registered registered;
    @Expose
    @SerializedName("dob")
    private Dob dob;
    @Expose
    @SerializedName("login")
    private Login login;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("location")
    private Location location;
    @Expose
    @SerializedName("name")
    private Name name;
    @Expose
    @SerializedName("gender")
    private String gender;

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
