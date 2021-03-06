/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jkp.as.forms.jamil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamil Francisco
 */
public class ClassManager extends javax.swing.JDialog {

    /**
     * Creates new form student
     */
    public ClassManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        findUsers();
        jButton1.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
    }
                public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/student_data","root","");
            return con; 
        } catch (SQLException ex) {
            Logger.getLogger(ClassManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Not Connected to Datebase");
            return null;
        }
        
                }
                  Connection con = getConnection();
public void add(){

String teacher= teacher_txt.getText();
String section = Section_txt.getText();
String class1 = Class_txt.getText();
String timein = timein_txt.getText();
String timeout=timeout_txt.getText();


          
         try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `class_data` (`teacher`,`section`,`Class_name`,`time_in`,`time_out`) VALUES (?,?,?,?,?);");
               ps.setString(1,teacher);
               ps.setString(2,section);
                ps.setString(3,class1);
                 ps.setString(4,timein);
                  ps.setString(5,timeout);
              ps.executeUpdate();
                

                JOptionPane.showMessageDialog(null, "SAVE");

             
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }  
               
              }
 public void update(){
    int num = Integer.parseInt(idnum_txt.getText());
String teacher= teacher_txt.getText();
String section = Section_txt.getText();
String class1 = Class_txt.getText();
String timein = timein_txt.getText();
String timeout=timeout_txt.getText();


             Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;
       
              try {
                    UpdateQuery= "UPDATE `class_data` SET `teacher`=?, `section`=?, `Class_name`=?, `time_in`=?, `time_out`=? WHERE `id_num`=?";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                   ps1.setString(1,teacher);
               ps1.setString(2,section);
                  ps1.setString(3,class1);
                    ps1.setString(4,timein);
                ps1.setString(5,timeout);
                    ps1.setInt(6,num);
                 
                ps1.executeUpdate();

                JOptionPane.showMessageDialog(null,"Update Complete");
                  
                } catch (SQLException ex) {
                    Logger.getLogger(ClassManager.class.getName()).log(Level.SEVERE, null, ex);
                
            }
 }
ArrayList<Classdata>listclass(String ValToSearch){
       ArrayList<Classdata> skilllist = new ArrayList<>();
       
       Statement st;
       ResultSet rs;
       
       try{
         
           st = con.createStatement();
           String searchQueary = "SELECT * FROM `class_data` WHERE CONCAT(`id_num`, `teacher`, `section`, `Class_name`, `time_in`, `time_out`)LIKE'%"+ValToSearch+"%'";
           rs = st.executeQuery(searchQueary);
          Classdata user;
           while(rs.next()){
               user = new Classdata(  
                      rs.getInt("id_num"),
                      rs.getString("teacher"),
                      rs.getString("section"),
                      rs.getString("Class_name"),
                       rs.getString("time_in"),
                       rs.getString("time_out")
                      
               );
                skilllist.add(user);
         
    
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return skilllist;   
   }

public void findUsers(){
       ArrayList<Classdata> users = listclass(jTextField1.getText());  
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
    Object[] row = new Object[6];
    for(int i =0; i<users.size();i++){
        row[0]=users.get(i).getId_num();
         row[1]=users.get(i).getTeacher();
          row[2]=users.get(i).getSection();
           row[3]=users.get(i).getClass_name();
            row[4]=users.get(i).getTime_in();
             row[5]=users.get(i).getTime_out();

        model.addRow(row);
    }}
 public void ShowItem(int index){
   idnum_txt.setText(Integer.toString(listclass("").get(index).getId_num()));
teacher_txt.setText(listclass("").get(index).getTeacher());
Section_txt.setText(listclass("").get(index).getSection());
Class_txt.setText(listclass("").get(index).getClass_name());
timein_txt.setText(listclass("").get(index).getTime_in());
timeout_txt.setText(listclass("").get(index).getTime_out());
  
}
  public void delete(){
     if(jLabel6.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Click to table to choose!");
}else{
         Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;

              try {
                    UpdateQuery= "DELETE FROM `class_data` WHERE `id_num` = ?";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                    ps1.setInt(1,Integer.parseInt(idnum_txt.getText()));
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted!");
                  findUsers();
          idnum_txt.setText("");
teacher_txt.setText("");
Section_txt.setText("");
Class_txt.setText("");
timein_txt.setText("");
timeout_txt.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                
            }
}
     
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        idnum_txt = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Class_txt = new javax.swing.JTextField();
        Section_txt = new javax.swing.JTextField();
        teacher_txt = new javax.swing.JTextField();
        timein_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        timeout_txt = new javax.swing.JTextField();
        G_contact = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_num", "teacher", "Section", "Class_name", "time_in", "time_out"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 560, 130));

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 110, 40));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 40));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 110, 40));

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 40));

        idnum_txt.setBackground(new java.awt.Color(255, 255, 255));
        idnum_txt.setOpaque(true);
        jPanel1.add(idnum_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 170, 30));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 400, 30));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel4.setText("ID num:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Search:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel5.setText("Teacher:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 60, 30));
        jPanel1.add(Class_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, 30));
        jPanel1.add(Section_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, 30));
        jPanel1.add(teacher_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 170, 30));
        jPanel1.add(timein_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel8.setText("Time In:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 50, 30));
        jPanel1.add(timeout_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 170, 30));

        G_contact.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        G_contact.setText("Time Out:");
        jPanel1.add(G_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel6.setText("Section:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 40, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel7.setText("Class Name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Class", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 18))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 410));

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 660, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(
teacher_txt.getText().isEmpty()||
Section_txt.getText().isEmpty()||
Class_txt.getText().isEmpty()||
timein_txt.getText().isEmpty()||
timeout_txt.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Invalid Inputs!");
      }else{
        add();
                                idnum_txt.setText("");
teacher_txt.setText("");
Section_txt.setText("");
Class_txt.setText("");
timein_txt.setText("");
timeout_txt.setText("");
findUsers();
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        findUsers();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int index = jTable1.getSelectedRow();
        ShowItem(index);
         jButton1.setVisible(true);
        jButton3.setVisible(true);
        jButton2.setVisible(false);
        jButton4.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          idnum_txt.setText("");
teacher_txt.setText("");
Section_txt.setText("");
Class_txt.setText("");
timein_txt.setText("");
timeout_txt.setText("");
 jButton2.setVisible(true);
 jButton1.setVisible(false);
  jButton4.setVisible(false);
        jButton3.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update();
        findUsers();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(
teacher_txt.getText().isEmpty()||
Section_txt.getText().isEmpty()||
Class_txt.getText().isEmpty()||
timein_txt.getText().isEmpty()||
timeout_txt.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Invalid Inputs!");
      }else{
        delete();
        findUsers();
        teacher_txt.setText("");
Section_txt.setText("");
Class_txt.setText("");
timein_txt.setText("");
timeout_txt.setText("");
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClassManager dialog = new ClassManager(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
            
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Class_txt;
    private javax.swing.JLabel G_contact;
    private javax.swing.JTextField Section_txt;
    private javax.swing.JLabel idnum_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField teacher_txt;
    private javax.swing.JTextField timein_txt;
    private javax.swing.JTextField timeout_txt;
    // End of variables declaration//GEN-END:variables
}
