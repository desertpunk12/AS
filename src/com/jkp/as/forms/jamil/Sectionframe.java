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
public class Sectionframe extends javax.swing.JDialog {

    /**
     * Creates new form student
     */
    public Sectionframe(java.awt.Frame parent, boolean modal) {
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
            Logger.getLogger(Sectionframe.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Not Connected to Datebase");
            return null;
        }
                }
public void add(){

String adviser= adviser_txt.getText();
String section = Section_txt.getText();
String schoolyear = school_txt.getText();



      Connection con = getConnection();
          
         try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `section` (`Adviser`, `Section_name`, `School_Year`) VALUES (?, ?, ?);");
               ps.setString(1,adviser);
               ps.setString(2,section);
                ps.setString(3,schoolyear );
               
              ps.executeUpdate();
                

                JOptionPane.showMessageDialog(null, "SAVE");
                      idnum_txt.setText("");
adviser_txt.setText("");
Section_txt.setText("");
school_txt.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }  
               
              }
 public void update(){
    int num = Integer.parseInt(idnum_txt.getText());

String adviser= adviser_txt.getText();
String section = Section_txt.getText();
String schoolyear = school_txt.getText();


             Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;
       
              try {
                    UpdateQuery= "UPDATE `section` SET `Adviser`=?, `Section_name`=?, `School_Year`=? WHERE  `id_num`=?";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                   ps1.setString(1,adviser);
               ps1.setString(2,section);
                  ps1.setString(3,schoolyear);
               
                    ps1.setInt(4,num);
             
                ps1.executeUpdate();
                    findUsers();
                             idnum_txt.setText("");
adviser_txt.setText("");
Section_txt.setText("");
school_txt.setText("");
                JOptionPane.showMessageDialog(null,"Update Complete");
                  
                } catch (SQLException ex) {
                    Logger.getLogger(Sectionframe.class.getName()).log(Level.SEVERE, null, ex);
                
            }
 }
ArrayList<Section_data>listsection(String ValToSearch){
       ArrayList<Section_data> skilllist = new ArrayList<>();
       
       Statement st;
       ResultSet rs;
       
       try{
           Connection con = getConnection();
           st = con.createStatement();
           String searchQueary = "SELECT * FROM `section` WHERE CONCAT(`id_num`, `Adviser`, `Section_name`, `School_Year`)LIKE'%"+ValToSearch+"%'";
           rs = st.executeQuery(searchQueary);
          Section_data user;
           while(rs.next()){
               user = new Section_data(  
                      rs.getInt("id_num"),
                      rs.getString("Adviser"),
                      rs.getString("Section_name"),
                      rs.getString("School_Year")
                     
                      
               );
                skilllist.add(user);
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return skilllist;   
   }

public void findUsers(){
       ArrayList<Section_data> users = listsection(jTextField1.getText());  
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
    Object[] row = new Object[4];
    for(int i =0; i<users.size();i++){
        row[0]=users.get(i).getId_num();
         row[1]=users.get(i).getAdviser();
          row[2]=users.get(i).getSection_name();
           row[3]=users.get(i).getSchool_Year();
            

        model.addRow(row);
    }}
 public void ShowItem(int index){
   idnum_txt.setText(Integer.toString(listsection("").get(index).getId_num()));
adviser_txt.setText(listsection("").get(index).getAdviser());
Section_txt.setText(listsection("").get(index).getSection_name());
school_txt.setText(listsection("").get(index).getSchool_Year());

}
  public void delete(){
     if(jLabel6.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Click to table to choose!");
}else{
         Connection con = getConnection();
              String UpdateQuery =null;
            PreparedStatement ps1 = null;

              try {
                    UpdateQuery= "DELETE FROM `section` WHERE `id_num` = ?";
                    ps1 = con.prepareStatement(UpdateQuery);                    
                
                    ps1.setInt(1,Integer.parseInt(idnum_txt.getText()));
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted!");
                  findUsers();
            

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
        school_txt = new javax.swing.JTextField();
        Section_txt = new javax.swing.JTextField();
        adviser_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_num", "Adviser", "Section_name", "School_year"
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
        jLabel5.setText("Adviser:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 60, 30));
        jPanel1.add(school_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, 30));
        jPanel1.add(Section_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, 30));
        jPanel1.add(adviser_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel6.setText("Section name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel7.setText("School_year:");
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
adviser_txt.getText().isEmpty()||
Section_txt.getText().isEmpty()||
school_txt.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Invalid Inputs!");
}else{
        add();
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
adviser_txt.setText("");
Section_txt.setText("");
school_txt.setText("");

 jButton2.setVisible(true);
 jButton1.setVisible(false);
  jButton4.setVisible(false);
        jButton3.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if(
adviser_txt.getText().isEmpty()||
Section_txt.getText().isEmpty()||
school_txt.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Invalid Inputs!");
}else{        update();
        findUsers();}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete();
        findUsers();
                       idnum_txt.setText("");
adviser_txt.setText("");
Section_txt.setText("");
school_txt.setText("");
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
            java.util.logging.Logger.getLogger(Sectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sectionframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sectionframe dialog = new Sectionframe(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Section_txt;
    private javax.swing.JTextField adviser_txt;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField school_txt;
    // End of variables declaration//GEN-END:variables
}
