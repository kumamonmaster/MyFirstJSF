package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "userInfoBean4")
@SessionScoped
public class UserInfoBean4 implements Serializable {

    String userName;
    String birthDay;
    
    public UserInfoBean4() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
}
