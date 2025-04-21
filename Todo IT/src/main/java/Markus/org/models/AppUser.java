package Markus.org.models;

import Markus.org.AppRole;

public class AppUser {
    private String userName;
    private String passWord;
    private AppRole role;

    public String getUserName() {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }

    public AppRole getRole() {
        if (passWord == null || passWord.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null ) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.role = role;
    }

    public AppUser(String userName, String passWord, AppRole role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
}
