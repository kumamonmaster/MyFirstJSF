package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.Date;

@Named(value = "convertBean")
@RequestScoped
public class ConvertBean {

    Date theDay;
    
    public ConvertBean() {
    }

    public Date getTheDay() {
        return theDay;
    }

    public void setTheDay(Date theDay) {
        this.theDay = theDay;
    }
    
}
