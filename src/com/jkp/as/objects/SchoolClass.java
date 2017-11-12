package com.jkp.as.objects;

import com.jkp.as.utils.DB;
import java.sql.SQLException;

public class SchoolClass{
	
	private int classid;
	private int teacherid;
        private int sectionid;
        private String classname;
        private String sectionname;
	private String timein;
	private String timeout;

	public SchoolClass(){}
	
	public int getClassid(){
		return classid;
	}

	public int getTecherid(){
		return teacherid;
	}
        
        public int getSectionid(){
            return sectionid;
        }
        
        public String getClassname(){
            return classname;
        }
        
        public String getSectionname(){
            return sectionname;
        }

	public String getTimein(){
		return timein;
	}

	public String getTimeout(){
		return timeout;
	}

	public void setClassid(int classid){
		this.classid = classid;
	}

	public void setTeacherid(int teacherid){
		this.teacherid = teacherid;
	}
        
        public void setSectionid(int sectionid){
            this.sectionid = sectionid;
        }
        
        public void setClassname(String classname){
            this.classname = classname;
        }
        
        public void setSectionname(String sectionname){
            this.sectionname = sectionname;
        }

	public void setTimein(String timein){
		this.timein = timein;
	}

	public void setTimeout(String timeout){
		this.timeout = timeout;
	}
        
        public void addToDatabase() throws SQLException{
            String query = "INSERT INTO class VALUES(DEFAULT,"+
                    teacherid+",'"+
                    sectionid+"','"+
                    timein+"','"+
                    timeout+"','"+
                    classname+"');";
            DB.query(query, true);
        }

}
