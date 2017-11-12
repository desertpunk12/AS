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
public class teacher_data {
    
private int Id_num;
private String first_name;
private String Last_name;
private String Middle_name;
private String User_name;
     private String Password;
    
     
     
     public teacher_data(    
int Id_num,
String first_name,
String Last_name,
String Middle_name,
String User_name,
     String Password
    ){
         this.Id_num=Id_num;
         this.first_name=first_name;
         this.Last_name=Last_name;
         this.Middle_name=Middle_name;
         this.User_name=User_name;
         this.Password=Password;
     }

    /**
     * @return the Id_num
     */
    public int getId_num() {
        return Id_num;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return the Last_name
     */
    public String getLast_name() {
        return Last_name;
    }

    /**
     * @return the Middle_name
     */
    public String getMiddle_name() {
        return Middle_name;
    }

    /**
     * @return the User_name
     */
    public String getUser_name() {
        return User_name;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }
     
}
