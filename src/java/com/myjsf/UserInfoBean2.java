package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "userInfoBean2")
@SessionScoped
public class UserInfoBean2 implements Serializable {
    String userName;
    String birthDay;
    String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String targetPage() {
        if(gender.equals("men")) {
            return "resultForMen";
        } else {
            return "resultForWomen";
        }
    }
}
