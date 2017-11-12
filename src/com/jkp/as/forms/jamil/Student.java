/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.forms.jamil;

import com.jkp.as.utils.DB;
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
public class Student extends javax.swing.JDialog {

    /**
     * Creates new form student
     */
    public Student(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        findUsers();
        jButton1.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
    }

    public void add() {
        String lrn = lrn_txt.getText();
        String name1 = firstname_txt.getText();
        String name2 = lastname_txt.getText();
        String name3 = middlename_txt.getText();
        
        String gname = g_name.getText();
        String contactmun = g_num.getText();


        try {
            DB.query("INSERT INTO student VALUES('"
                    +lrn+"','"
                    + name1+"','"
                    + name2+"','"
                    + name3+"','"
                    + contactmun+"','"
                    + gname+"')", true);
            JOptionPane.showMessageDialog(null, "SAVE");

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        String lrn = lrn_txt.getText();
        String name1 = firstname_txt.getText();
        String name2 = lastname_txt.getText();
        String name3 = middlename_txt.getText();
        String gname = g_name.getText();
        String contactmun = g_num.getText();

        try {
            DB.query("UPDATE student SET "
                    + "firstname='"+name1+"', "
                    + "lastname='"+name2+"', "
                    + "middlename='"+name3+"',"
                    + "contact='"+contactmun+"',"
                    + "guardian='"+gname+"'"
                    + " WHERE lrn='"+lrn+"'",true);
            JOptionPane.showMessageDialog(null, "Update Complete");

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    ArrayList<Studs_data> liststuds(String ValToSearch) {
        ArrayList<Studs_data> skilllist = new ArrayList<>();

        try {
            
            ResultSet rs = DB.query("SELECT * FROM student WHERE UPPER(CONCAT(firstname,lastname,middlename,guardian,contact)) LIKE UPPER('%"+ValToSearch+"%')");
            Studs_data user;
            while (rs.next()) {
                user = new Studs_data(
                        rs.getString("lrn"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("middlename"),
                        rs.getString("guardian"),
                        rs.getString("contact")
                );
                skilllist.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return skilllist;
    }

    public void findUsers() {
        ArrayList<Studs_data> users = liststuds(jTextField1.getText());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getLrn();
            row[1] = users.get(i).getFirst_name();
            row[2] = users.get(i).getMiddle_name();
            row[3] = users.get(i).getLast_name();
            row[4] = users.get(i).getGuardian_name();
            row[5] = users.get(i).getGuardian_contact();

            model.addRow(row);
        }
    }

    public void ShowItem(int index) {
        lrn_txt.setText(liststuds("").get(index).getLrn());
        firstname_txt.setText(liststuds("").get(index).getFirst_name());
        middlename_txt.setText(liststuds("").get(index).getMiddle_name());
        lastname_txt.setText(liststuds("").get(index).getLast_name());
        g_name.setText(liststuds("").get(index).getGuardian_name());
        g_num.setText(liststuds("").get(index).getGuardian_contact());

    }

    public void delete() {
        if (jLabel6.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Click to table to choose!");
        } else {

            try {
                DB.query("DELETE FROM student WHERE lrn='"+lrn_txt.getText()+"'",true);
                JOptionPane.showMessageDialog(null, "Deleted!");
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
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lrn_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lastname_txt = new javax.swing.JTextField();
        middlename_txt = new javax.swing.JTextField();
        firstname_txt = new javax.swing.JTextField();
        g_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        g_num = new javax.swing.JTextField();
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
                "lrn", "First Name", "Middle Name", "Last Name", "Guardian's Name", "Guardian's Contact"
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

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 400, 30));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel4.setText("Irn:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 30, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Search:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));
        jPanel1.add(lrn_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel5.setText("First Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 60, 30));
        jPanel1.add(lastname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, 30));
        jPanel1.add(middlename_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, 30));
        jPanel1.add(firstname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 170, 30));
        jPanel1.add(g_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel8.setText("Guardian's Name:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, 30));
        jPanel1.add(g_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 170, 30));

        G_contact.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        G_contact.setText("Guardian's Name:");
        jPanel1.add(G_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel6.setText("Middle Name:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel7.setText("Last Name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 0, 18))); // NOI18N
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
        if (lrn_txt.getText().isEmpty()
                || firstname_txt.getText().isEmpty()
                || middlename_txt.getText().isEmpty()
                || lastname_txt.getText().isEmpty()
                || g_name.getText().isEmpty()
                || g_num.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Inputs!");
        } else {

            add();
            findUsers();
            lrn_txt.setText("");
            firstname_txt.setText("");
            middlename_txt.setText("");
            lastname_txt.setText("");
            g_name.setText("");
            g_num.setText("");
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
        lrn_txt.setText("");
        firstname_txt.setText("");
        middlename_txt.setText("");
        lastname_txt.setText("");
        g_name.setText("");
        g_num.setText("");
        jButton2.setVisible(true);
        jButton1.setVisible(false);
        jButton4.setVisible(false);
        jButton3.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (lrn_txt.getText().isEmpty()
                || firstname_txt.getText().isEmpty()
                || middlename_txt.getText().isEmpty()
                || lastname_txt.getText().isEmpty()
                || g_name.getText().isEmpty()
                || g_num.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Inputs!");
        } else {
            update();
            findUsers();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel G_contact;
    private javax.swing.JTextField firstname_txt;
    private javax.swing.JTextField g_name;
    private javax.swing.JTextField g_num;
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
    private javax.swing.JTextField lastname_txt;
    private javax.swing.JTextField lrn_txt;
    private javax.swing.JTextField middlename_txt;
    // End of variables declaration//GEN-END:variables
}
