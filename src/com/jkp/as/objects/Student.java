package com.jkp.as.objects;

import com.jkp.as.utils.DB;
import java.sql.SQLException;

public class Student{

	private String lrn;
	private String firstname;
	private String lastname;
	private String middlename;
	private String guardian;
	private String contact;

	public Student(){
	}

	private String getLrn(){
		return lrn;
	}

	public String getFirstname(){
		return firstname;
	}

	public String getLastname(){
		return lastname;
	}

	public String getMiddlename(){
		return middlename;
	}
        
        public String getContact(){
            return contact;
        }
        
        public String getGuardian(){
            return guardian;
        }

	public void setLrn(String lrn){
		this.lrn = lrn;
	}

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public void setMiddlename(String middlename){
		this.middlename = middlename;
	}
        
        public void setContact(String contact){
            this.contact = contact;
        }
        
        public void setGuardian(String guardian){
            this.guardian = guardian;
        }

        
        public void addToDatabase() throws SQLException{
            String query = "INSERT INTO student VALUES("+
                    lrn+",'"+
                    firstname+"','"+
                    lastname+"','"+
                    middlename+"','"+
                    contact+"','"+
                    guardian+"');";
            DB.query(query, true);
        }



}
