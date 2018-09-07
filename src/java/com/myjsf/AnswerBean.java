package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "answerBean")
@RequestScoped
public class AnswerBean {

    String gender;
    String brand;
    String brandName;
    final String[] brandList = {
        "Marc Jacobs", "EMODA", "EGOIST", "MURUA", "dazzlin", "その他"
    };
    
    public AnswerBean() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
        setBrandName(brandList[Integer.parseInt(brand) - 1]);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String[] getBrandList() {
        return brandList;
    }
    
}
