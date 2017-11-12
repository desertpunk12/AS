/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.forms;

import java.util.ArrayList;

/**
 *
 * @author dpunk12
 */
public class Test {
    public static int getDayAttendance(ArrayList<Integer> ats){
        boolean canLate = false;
        boolean late = false;
        boolean attended = false;
        boolean cutting = false;
        
        int ret = -1;
        //0 Present
        //1 Absent
        //2 Late
        //3 Cutting
        
        
        for(int i=0;i<ats.size();i++){
            if(ats.get(i)==0){
                if(!attended){
                    attended = true;
                }
                if(canLate){
                    late=true;
                    ret = 2;
                }
            }else if(ats.get(i)==1){
                if(!attended){
                    canLate = true;
                    
                }
                if(attended){
                    ret=3;
                    break;
                }
            }
        }
        
        if(!attended){
            ret = 1;
        }
        
        return ret;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> tt = new ArrayList<>();
        tt.add(0);
        tt.add(1);
        tt.add(0);
        tt.add(0);
        tt.add(0);
        tt.add(0);
        System.out.println(getDayAttendance(tt));
    }
}
