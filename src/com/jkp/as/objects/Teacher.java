package com.jkp.as.objects;

import com.jkp.as.utils.DB;
import java.sql.SQLException;

public class Teacher{

	private int teacherid;
	private String firstname;
	private String lastname;
	private String middlename;
        private String username;
        private String password;


	public Teacher(){}

	public int getTeacherid(){
		return teacherid;
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
        
        public String getUsername(){
            return username;
        }
        
        public String getPassword(){
            return password;
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
        
        public void setUsername(String username){
            this.username = username;
        }
        
        public void setPassword(String password){
            this.password = password;
        }
        
        public void addToDatabase() throws SQLException{
            String query = "INSERT INTO teacher VALUES(DEFAULT,'"+
                    firstname+"','"+
                    lastname+"','"+
                    middlename+"','"+
                    username+"','"+
                    password+"');";
            DB.query(query, true);
        }


}
