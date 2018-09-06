package com.myjsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "travelBean")
@RequestScoped
public class TravelBean {

    String area;
    String purpose;
    String comment;
    
    public TravelBean() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
