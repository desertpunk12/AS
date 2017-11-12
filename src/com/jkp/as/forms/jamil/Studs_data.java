/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jkp.as.forms.jamil;

/**
 *
 * @author Jamil Francisco
 */
public class Studs_data {
    private String lrn;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String Guardian_name;
    private String Guardian_contact;

    public Studs_data(String lrn,String first_name,String last_name,String middle_name,String Guardian_name,String Guardian_contact){
        this.lrn=lrn;
        this.first_name=first_name;
        this.last_name=last_name;
        this.middle_name=middle_name;
        this.Guardian_contact=Guardian_contact;
        this.Guardian_name=Guardian_name;
    }
    
    public String getLrn() {
        return lrn;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @return the middle_name
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * @return the Guardian_name
     */
    public String getGuardian_name() {
        return Guardian_name;
    }

    /**
     * @return the Guardian_contact
     */
    public String getGuardian_contact() {
        return Guardian_contact;
    }
    
    
}
