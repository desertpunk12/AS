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
public class Section_data {
    private int id_num;
    private String Adviser;
    private String Section_name;
    private String  School_Year;

    
    public Section_data(int id_num,String Adviser,String Section_name,String School_Year){
        this.id_num=id_num;
        this.Adviser=Adviser;
        this.Section_name=Section_name;
        this.School_Year=School_Year;
    }
    /**
     * @return the id_num
     */
    public int getId_num() {
        return id_num;
    }

    /**
     * @return the Adviser
     */
    public String getAdviser() {
        return Adviser;
    }

    /**
     * @return the Section_name
     */
    public String getSection_name() {
        return Section_name;
    }

    /**
     * @return the School_Year
     */
    public String getSchool_Year() {
        return School_Year;
    }
                 
}
