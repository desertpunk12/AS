/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.forms;

import com.jkp.as.objects.Attendance;
import com.jkp.as.objects.SchoolClass;
import com.jkp.as.utils.DB;
import com.jkp.as.utils.GreyTextField;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.fill.JRFillInterruptedException;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author dpunk12
 */
public class ShowAllAttendance extends javax.swing.JFrame {

    /**
     * Creates new form ShowAllAttendance
     */
    public ShowAllAttendance() {
        
        initComponents();
        GreyTextField.greyifyTextFieldText(txtSearchClass, "Search Class");
        try{
        refreshClassTable();
        }catch(SQLException e){e.printStackTrace();}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblClassList = new javax.swing.JTable();
        txtSearchClass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnlJasperView = new javax.swing.JPanel();
        btnSummaryWeekly = new javax.swing.JButton();
        btnSummaryMonthly = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblClassList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClassList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClassListMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblClassList);

        txtSearchClass.setForeground(java.awt.Color.gray);
        txtSearchClass.setText("Search Class");
        txtSearchClass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchClassKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchClassKeyTyped(evt);
            }
        });

        jButton1.setText("Print Selected");

        btnSummaryWeekly.setText("View Summary Weekly");
        btnSummaryWeekly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryWeeklyActionPerformed(evt);
            }
        });

        btnSummaryMonthly.setText("View Summary Monthly");
        btnSummaryMonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryMonthlyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJasperViewLayout = new javax.swing.GroupLayout(pnlJasperView);
        pnlJasperView.setLayout(pnlJasperViewLayout);
        pnlJasperViewLayout.setHorizontalGroup(
            pnlJasperViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJasperViewLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlJasperViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSummaryMonthly)
                    .addComponent(btnSummaryWeekly))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlJasperViewLayout.setVerticalGroup(
            pnlJasperViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJasperViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSummaryWeekly)
                .addGap(18, 18, 18)
                .addComponent(btnSummaryMonthly)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtSearchClass, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlJasperView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 621, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlJasperView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchClassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchClassKeyReleased
        try{
        refreshClassTable();
        }catch(SQLException e){e.printStackTrace();}
    }//GEN-LAST:event_txtSearchClassKeyReleased

    private void txtSearchClassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchClassKeyTyped
        try{
        refreshClassTable();
        }catch(SQLException e){e.printStackTrace();}
    }//GEN-LAST:event_txtSearchClassKeyTyped

    private void tblClassListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassListMousePressed
        
    }//GEN-LAST:event_tblClassListMousePressed

    private void btnSummaryMonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryMonthlyActionPerformed
        viewSummaryMonthly();
    }//GEN-LAST:event_btnSummaryMonthlyActionPerformed

    private void btnSummaryWeeklyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryWeeklyActionPerformed
        viewSummaryweekly();
    }//GEN-LAST:event_btnSummaryWeeklyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSummaryMonthly;
    private javax.swing.JButton btnSummaryWeekly;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlJasperView;
    private javax.swing.JTable tblClassList;
    private javax.swing.JTextField txtSearchClass;
    // End of variables declaration//GEN-END:variables
    
    private HashMap<String,Integer> classes = new HashMap<>();
    
    
    private void viewSummaryMonthly(){
        HashMap<String,Object> params = new HashMap<>();
        int selectedClassid = this.classes.get(tblClassList.getValueAt(tblClassList.getSelectedRow(), 0));
        params.put("classid",selectedClassid);
        try{
            viewReport(pnlJasperView, "AttendanceSummaryMonthly.jasper", params, true);
        }catch(SQLException e){
            e.printStackTrace();
        } catch (JRFillInterruptedException | JRException ex) {
            Logger.getLogger(ShowAllAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void viewReport(JPanel pnl, String srcFile, HashMap<String,Object> m, boolean compiled) throws JRFillInterruptedException,SQLException,JRException  {
        JasperPrint jp;
        if (compiled)
            jp = JasperFillManager.fillReport(srcFile, m, DB.getConnection());
        else{
            JasperReport jr = JasperCompileManager.compileReport(srcFile);
            jp = JasperFillManager.fillReport(jr, m, DB.getConnection());
        }
        JasperViewer.viewReport(jp,false);
//        JRViewer pnlReport= new JRViewer(jp);
//
//        pnlReport.setZoomRatio(0.75f);
//        SwingUtilities.invokeLater(()-> {
//            for(int i=pnl.getComponentCount()-1;i>=0;i--){
//                pnl.remove(i);
//            }
//
//            pnl.add(pnlReport);
//            pnl.updateUI();
//            pnl.repaint();
//        });
//        System.out.println("DONE report!");

    }
    
    
    private void viewSummaryweekly(){
        HashMap<String,Object> params = new HashMap<>();
        int selectedClassid = this.classes.get(tblClassList.getValueAt(tblClassList.getSelectedRow(), 0));
        params.put("classid",selectedClassid);
        try{
            viewReport(pnlJasperView, "AttendanceSummaryWeekly.jasper", params, true);
        }catch(SQLException e){
            e.printStackTrace();
        } catch (JRFillInterruptedException | JRException ex) {
            Logger.getLogger(ShowAllAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshClassTable() throws SQLException {
        String searchString = txtSearchClass.getText();
        

        String searchQuery = "";
        if (!searchString.equals("Search Class") && !searchString.equals("")) {
            searchQuery = " WHERE LOWER(classname) LIKE LOWER(\'%" + searchString + "%\') OR LOWER(sectionname) LIKE LOWER(\'%" + searchString + "%\');";
        }

        ResultSet rs = DB.query("SELECT c.*,s.sectionname FROM class c JOIN teacher t USING(teacherid) JOIN section s USING(sectionid)" + searchQuery);

        ArrayList<SchoolClass> classes = new ArrayList<>();
        this.classes.clear();
        while (rs.next()) {
            SchoolClass c = new SchoolClass();
            c.setClassid(rs.getInt(1));
            c.setTeacherid(rs.getInt(2));
            c.setSectionid(rs.getInt(3));
            c.setTimein(rs.getString(4));
            c.setTimeout(rs.getString(5));
            c.setClassname(rs.getString(6));
            c.setSectionname(rs.getString(7));

            classes.add(c);
//            if(this.classes!=null)
            
            this.classes.put(c.getClassname() + " (" + c.getSectionname() + ")", c.getClassid());
        }

        String[][] datas = new String[classes.size()][1];
        String[] colNames = {"Classes"};

        for (int i = 0; i < classes.size(); i++) {
            SchoolClass c = classes.get(i);
            datas[i][0] = c.getClassname() + " (" + c.getSectionname() + ")";
        }

        tblClassList.setModel(new DefaultTableModel(datas, colNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });
    }
}
