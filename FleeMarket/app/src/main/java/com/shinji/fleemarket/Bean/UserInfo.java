package com.shinji.fleemarket.Bean;


/**
 * Created by Shin on 17/6/21.
 */

public class UserInfo {


    /**
     * uid : 3
     * username : Sh1nJi
     * password : 6de090535c0561a3919b7dbdf5750412
     * realname :
     * email :
     * salt : 77c3c8
     * token : 35d552980e0fe7e5434f43714753ff5b8bb39f5faf6f50a120d319e8c0cbba6c
     * expiretime : 16777215
     */

    private String uid;
    private String username;
    private String password;
    private String realname;
    private String email;
    private String salt;
    private String token;
    private String expiretime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }
}
