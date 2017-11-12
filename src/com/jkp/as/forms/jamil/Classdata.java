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
public class Classdata {
    private int id_num;
    private String teacher;
    private String section;
    private String Class_name;
    private String time_in;
    private String time_out;

    public Classdata(int id_num,String teacher,String section,String Class_name,String time_in,String time_out){
        this.id_num=id_num;
        this.teacher=teacher;
        this.section=section;
        this.Class_name=Class_name;
        this.time_in=time_in;
        this.time_out=time_out;
    }
    /**
     * @return the id_num
     */
    public int getId_num() {
        return id_num;
    }

    /**
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @return the Class_name
     */
    public String getClass_name() {
        return Class_name;
    }

    /**
     * @return the time_in
     */
    public String getTime_in() {
        return time_in;
    }

    /**
     * @return the time_out
     */
    public String getTime_out() {
        return time_out;
    }
    
}
