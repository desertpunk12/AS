/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.objects;

import com.jkp.as.utils.DB;
import java.sql.SQLException;

/**
 *
 * @author dpunk12
 */
public class Enroll {

    private int enrollid;
    private String studentid;
    private int sectionid;
    
    
    public int getEnrollid() {
        return enrollid;
    }

    public void setEnrollid(int enrollid) {
        this.enrollid = enrollid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }
    
    public void addToDatabase() throws SQLException{
        String query = "INSERT INTO enroll VALUES(DEFAULT,"+
                studentid+","+
                sectionid+");";
        DB.query(query, true);
    }
    
    
    
}
