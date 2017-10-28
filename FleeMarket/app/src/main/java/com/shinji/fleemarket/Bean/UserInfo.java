package com.shinji.fleemarket.Bean;


import java.util.List;

/**
 * Created by Shin on 17/6/21.
 */

public class UserInfo {


    /**
     * uid : 26
     * realname : 金正源
     * username : Sh1nJi
     * college : College of Arts and Sciences (CAS)
     * major : Computer Science
     * gender : 2
     * dateOfBirth : 1996-1-1
     * sessionid : af011d8d04a21db4a5e0d2f5a14fe77c
     * token : 9da43324e8e37ffce1390a621a241132
     * bio : 我的名字叫金正源。私の名前は信一です。My name is Tony.
     * affectivestatus : 单身
     * avatar : {"big":"","middle":"","small":""}
     */



    private int uid;
    private String realname;
    private int gender;
    private String dateOfBirth;
    private String sessionid;
    private String token;
    private String bio;
    private String affectivestatus;
    private List<String> avatar;
    private String username;
    private String college;
    private String major;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

//    public String getDateOfBirth() {
//        return dateOfBirth(dateOfBirth);
//    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



//    public String dateOfBirth(String str) {
//        String dateOfBirth = "";
//        String[] date = str.split("-");
//        dateOfBirth = date[2] + " ";
//        dateOfBirth += DateUtil.getEngMonth(Integer.valueOf(date[1])-1) + " ";
//        dateOfBirth += date[0];
//        return dateOfBirth;
//    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAffectivestatus() {
        return affectivestatus;
    }

    public void setAffectivestatus(String affectivestatus) {
        this.affectivestatus = affectivestatus;
    }

    public List<String> getAvatar() {
        return avatar;
    }

    public void setAvatar(List<String> avatar) {
        this.avatar = avatar;
    }

    public String getBig() {
        return avatar.get(0);
    }

    public String getMiddle() {
        return avatar.get(1);
    }

    public String getSmall() {
        return avatar.get(2);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public static class AvatarBean {
        /**
         * big :
         * middle :
         * small :
         */

        private String big;
        private String middle;
        private String small;

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getMiddle() {
            return middle;
        }

        public void setMiddle(String middle) {
            this.middle = middle;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }
    }
}
