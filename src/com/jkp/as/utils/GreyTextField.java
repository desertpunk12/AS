/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author dpunk12
 */
public class GreyTextField {
    
    public static void greyifyTextFieldText(JPasswordField txt,String defaulttext){
        txt.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if(String.valueOf(txt.getPassword()).equals(defaulttext)){
                    txt.setText(null);
                    txt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
               if(String.valueOf(txt.getPassword()).equals("")){
                   txt.setText(defaulttext);
                   txt.setForeground(Color.GRAY);
               }
            }
        });
        
    }
    
    public static void greyifyTextFieldText(JTextField txt,String defaulttext){
        txt.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if(txt.getText().equals(defaulttext)){
                    txt.setText(null);
                    txt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
               if(txt.getText().equals("")){
                   txt.setText(defaulttext);
                   txt.setForeground(Color.GRAY);
               }
            }
        });
        
    }
}
