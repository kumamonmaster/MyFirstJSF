package com.myjsf;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "musicBean")
@RequestScoped
public class MusicBean {

    ArrayList type;
    ArrayList musician;
    ArrayList hall;
    
    public MusicBean() {
    }

    public ArrayList getType() {
        return type;
    }

    public void setType(ArrayList type) {
        this.type = type;
    }

    public ArrayList getMusician() {
        return musician;
    }

    public void setMusician(ArrayList musician) {
        this.musician = musician;
    }

    public ArrayList getHall() {
        return hall;
    }

    public void setHall(ArrayList hall) {
        this.hall = hall;
    }
    
}
