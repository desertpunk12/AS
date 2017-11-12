package com.jkp.as.objects;

import com.jkp.as.utils.DB;
import java.sql.SQLException;

public class Section{
	
	private int sectionid;
	private int adviserid;
	private String sectionname;
	private String schoolyear;

	public Section(){}

	public int getSectionid(){
		return this.sectionid;
	}

	public int getAdviserid(){
		return this.adviserid;
	}

	public String getSectionname(){
		return this.sectionname;
	}

	public String getSchoolyear(){
		return this.schoolyear;
	}

	public void setSectionid(int sectionid){
		this.sectionid = sectionid;
	}

	public void setAdviserid(int adviserid){
		this.adviserid = adviserid;
	}

	public void setSectionname(String sectionname){
		this.sectionname = sectionname;
	}

	public void setSchoolyear(String schoolyear){
		this.schoolyear = schoolyear;
	}
        
        
        public void addToDatabase() throws SQLException{
            String query = "INSERT INTO section VALUES(DEFAULT,"+
                    adviserid+",'"+
                    schoolyear+"','"+
                    sectionname+"');";
            DB.query(query, true);
        }
}
