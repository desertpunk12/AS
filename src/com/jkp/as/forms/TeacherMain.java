/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkp.as.forms;

import com.jkp.as.forms.jamil.ClassManager;
import com.jkp.as.forms.jamil.Sectionframe;
import com.jkp.as.forms.jamil.Student;
import com.jkp.as.forms.jamil.teacher;
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
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.fill.JRFillInterruptedException;

/**
 *
 * @author dpunk12
 */
public class TeacherMain extends javax.swing.JFrame {

    /**
     * Creates new form TeacherMain
     */
    private int id;
    public TeacherMain(int id,boolean isAdmin) {
        this.id = id;
        initComponents();
        this.isAdmin = isAdmin;

        if (!isAdmin) {
            hideNonAdminComponents();
        }

        GreyTextField.greyifyTextFieldText(txtClassSearch, defaultstringClasssearch);
        GreyTextField.greyifyTextFieldText(txtStudentSearch, defaultstringStudentsearch);
        txtStudentSearch.requestFocus();

        thrdClasssearch = new Thread();

        //Set today date
        try {
            ResultSet rs = DB.query("SELECT DATE(NOW());");
            rs.next();
            txtDate.setText(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            refreshClassTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateStudentsTable();

    }

    //<editor-fold defaultstate="collapsed" desc="NetBeans Code">
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdgrp = new javax.swing.ButtonGroup();
        btnStudent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClasses = new javax.swing.JTable();
        txtClassSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtStudentSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudensAttendance = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnClass = new javax.swing.JButton();
        btnSection = new javax.swing.JButton();
        btnEnroll = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        btnStudent.setText("Student");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        tblClasses.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClasses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClassesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblClassesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblClasses);

        txtClassSearch.setForeground(Color.GRAY);
        txtClassSearch.setText("Search Class");
        txtClassSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClassSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClassSearchKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtStudentSearch.setForeground(Color.GRAY);
        txtStudentSearch.setText("Search Student");
        txtStudentSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStudentSearchKeyTyped(evt);
            }
        });

        tblStudensAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Student", "Attendance", "Note"
            }
        ));
        tblStudensAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudensAttendanceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStudensAttendanceMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudensAttendance);

        btnUpdate.setText("Done");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtStudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addContainerGap())
        );

        btnTeacher.setText("Teacher");
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });

        btnClass.setText("Class");
        btnClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassActionPerformed(evt);
            }
        });

        btnSection.setText("Section");
        btnSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSectionActionPerformed(evt);
            }
        });

        btnEnroll.setText("Enroll Student");
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });

        jButton1.setText("Show All Attendance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Check Today");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtDate.setText("2017-11-05");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTeacher)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtClassSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnroll)
                        .addGap(22, 22, 22)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudent)
                    .addComponent(btnTeacher)
                    .addComponent(btnClass)
                    .addComponent(btnSection)
                    .addComponent(btnEnroll)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtClassSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        enrollStudents();
    }//GEN-LAST:event_btnEnrollActionPerformed

    private void txtClassSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassSearchKeyTyped
        try {
            refreshClassTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtClassSearchKeyTyped

    private void txtStudentSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentSearchKeyTyped
//        System.out.println("Student Search:"+txtStudentSearch.getText());
//        searchStudent();
    }//GEN-LAST:event_txtStudentSearchKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        checkToday();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassesMouseClicked

        updateStudentsTable();
    }//GEN-LAST:event_tblClassesMouseClicked

    private void tblStudensAttendanceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudensAttendanceMousePressed
        studentSelected();
    }//GEN-LAST:event_tblStudensAttendanceMousePressed

    private void tblStudensAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudensAttendanceMouseClicked
        studentSelected();
    }//GEN-LAST:event_tblStudensAttendanceMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        sendWarnings();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblClassesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassesMousePressed
        updateStudentsTable();
    }//GEN-LAST:event_tblClassesMousePressed

    private void tblClassesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassesMouseReleased
        updateStudentsTable();
    }//GEN-LAST:event_tblClassesMouseReleased

    private void txtStudentSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentSearchKeyReleased

        searchStudent();
    }//GEN-LAST:event_txtStudentSearchKeyReleased

    private void txtClassSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassSearchKeyReleased
        updateStudentsTable();
    }//GEN-LAST:event_txtClassSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showSummaryAttendance();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        Student student = new Student(this, true);
        student.setVisible(true);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
//        teacher teacher = new teacher(this,true);
//        teacher.setVisible(true);
        AddTeacher addTeacher = new AddTeacher(this,true);
        addTeacher.setVisible(true);
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassActionPerformed
//        ClassManager classmanager = new ClassManager(this,true);
//        classmanager.setVisible(true);
        AddClass addClass = new AddClass(this,true);
        addClass.setVisible(true);
    }//GEN-LAST:event_btnClassActionPerformed

    private void btnSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSectionActionPerformed
//        Sectionframe sectionframe = new Sectionframe(this,true);
//        sectionframe.setVisible(true);
        AddSection addSection = new AddSection(this,true);
        addSection.setVisible(true);
    }//GEN-LAST:event_btnSectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClass;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnSection;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup rdgrp;
    private javax.swing.JTable tblClasses;
    private javax.swing.JTable tblStudensAttendance;
    private javax.swing.JTextField txtClassSearch;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtStudentSearch;
    // End of variables declaration//GEN-END:variables

    //</editor-fold>
    
    private String messageCutting = "Magandang araw! Nais ko pong ipaalam na ang iyong anak ay hindi pumasok sa kanyang klase ngayon."
            + " Magbigay alam kung bakit po siya lumiban. Salamat po!";
    private String messageAbsent = "Magandang araw! Nais ko pong ipabatid na umabot nang 3 araw nang pagliban sa klase ang inyong anak."
            + " Mainam na makipagita kayo sa kanyang taga pay! Salamat po!";

    private HashMap<String, Integer> classes = new HashMap<>();
    private HashMap<String, String> students = new HashMap<>();

    private ArrayList<Attendance> attendances;

    private String defaultstringClasssearch = "Search Class";
    private String defaultstringStudentsearch = "Search Student";

    private Thread thrdClasssearch;

    private EnrollStudents enrollStuds;

    private boolean isAdmin = false;


    private void enrollStudents() {
        if (enrollStuds == null) {
            enrollStuds = new EnrollStudents();
        }
        enrollStuds.setLocationRelativeTo(null);
        enrollStuds.setVisible(true);
    }

    private void refreshClassTable() throws SQLException {
        String searchString = txtClassSearch.getText();

        String searchQuery = "";
        if (!searchString.equals(defaultstringClasssearch) && !searchString.equals("")) {
            searchQuery = " WHERE LOWER(classname) LIKE LOWER(\'%" + searchString + "%\') OR LOWER(sectionname) LIKE LOWER(\'%" + searchString + "%\');";
        }
        ResultSet rs;
        if(!isAdmin){
        rs = DB.query("SELECT c.*,s.sectionname FROM class c JOIN teacher t USING(teacherid) JOIN section s USING(sectionid)" + searchQuery
                +" WHERE teacherid="+id);
        }else{
        rs = DB.query("SELECT c.*,s.sectionname FROM class c JOIN teacher t USING(teacherid) JOIN section s USING(sectionid)" + searchQuery);    
        }

        ArrayList<SchoolClass> classes = new ArrayList<>();
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

        tblClasses.setModel(new DefaultTableModel(datas, colNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });
    }

    private void dateChanged() {
        updateStudentsTable();
    }

    private void updateStudentsTable() {
        //check if attendance exsists
        String studentSearch = "";
        if(!txtStudentSearch.getForeground().equals(Color.GRAY)){
            studentSearch = txtStudentSearch.getText();
        }
        try {
            DefaultTableModel model;
            if (tblClasses.getSelectedRow() < 0) {
                return;
            }
            int selectedClassid = this.classes.get(tblClasses.getValueAt(tblClasses.getSelectedRow(), 0));
            ResultSet rs = DB.query("SELECT * FROM attendance JOIN class USING(classid) WHERE day = '" + txtDate.getText() + "' AND classid=" + selectedClassid);
            if (rs.next()) {
                
                
                
                rs = DB.query("SELECT DISTINCT lrn, fullname,a.* FROM attendance a JOIN class USING(classid) JOIN section USING(sectionid) "
                        + " JOIN enroll USING(sectionid) "
                        + " JOIN student_fullname ON(a.studentid=lrn) "
                        + " WHERE UPPER(fullname) LIKE UPPER('%"+studentSearch+"%') AND day = DATE('"+ txtDate.getText() 
                        + "') AND classid=" + selectedClassid);
                attendances = new ArrayList<>();
                model = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                };
                model.addColumn("Student");
                model.addColumn("Attendance");
                model.addColumn("Note");
                while (rs.next()) {
                    Attendance aa = new Attendance();
                    aa.setStudentid(rs.getString(1));
                    aa.setFullname(rs.getString(2));
                    aa.setAttendanceid(rs.getInt(3));
                    aa.setStudentid(rs.getString(4));
                    aa.setClassid(rs.getInt(5));
                    aa.setAttend(rs.getInt(6));
                    aa.setNote(rs.getString(7));
                    aa.setDay(rs.getString(8));

                    attendances.add(aa);
                    this.students.put(aa.getFullname(), aa.getStudentid());
                    model.addRow(new String[]{aa.getFullname(), aa.getAttend() + "", aa.getNote()});
                }

            } else {
                model = new DefaultTableModel(new String[][]{
                    {"No Students", "No Attendance"}
                }, new String[]{"Students", "Attendance"}) {

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }

                };
            }

            tblStudensAttendance.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void searchStudent() {
        updateStudentsTable();
    }

    private void checkToday() {
        try {
            ResultSet rs = DB.query("SELECT DATE(NOW());");
            rs.next();
            txtDate.setText(rs.getString(1));
            int selectedClassid = this.classes.get(tblClasses.getValueAt(tblClasses.getSelectedRow(), 0));
            rs = DB.query("SELECT * FROM attendance WHERE day=DATE('"+txtDate.getText()+"')AND classid="+selectedClassid);
//            rs = DB.query("SELECT studentid, classid, 0 AND DATE(NOW()) "
//                    + "FROM class JOIN section USING(sectionid) "
//                    + "JOIN enroll USING(sectionid) "
//                    + "JOIN student ON(studentid=lrn) "
//                    + "WHERE classid=" + selectedClassid);
            if(!rs.next()){
                DB.query("INSERT INTO attendance(studentid,classid,attend,day) SELECT studentid, classid, 0, DATE(NOW()) "
                        + "FROM class JOIN section USING(sectionid) "
                        + "JOIN enroll USING(sectionid) "
                        + "JOIN student ON(studentid=lrn) "
                        + "WHERE classid=" + selectedClassid, true);
            }
            updateStudentsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void studentSelected() {
        String selectedStudentname = tblStudensAttendance.getValueAt(tblStudensAttendance.getSelectedRow(), 0).toString();

        Attendance attendance = attendances.get(tblStudensAttendance.getSelectedRow());
        System.out.println(attendance.getAttendanceid());

        SetAttendance att = new SetAttendance(attendance, selectedStudentname, this, true);
        updateStudentsTable();
    }
    
    private void sendAbsentWarning(String studentid){
        try{
            float numOfAbsents = 0;
            ResultSet rs = DB.query("select count(*) from (SELECT COUNT(attend) schooldays,day from "
                    + "attendance where studentid='"+studentid+"' GROUP BY day) sd LEFT JOIN"
                                    +"(select count(attend) present,day from attendance "
                    + "where studentid='"+studentid+"' and attend=0 GROUP BY day) pr USING(day) WHERE present is null;");
            rs.next();
            numOfAbsents = rs.getInt(1);
            if(numOfAbsents>=3){
                System.out.println("Sending absent warning for student: "+studentid);
                DB.query("INSERT INTO send VALUES(DEFAULT," + studentid + ",'" + messageAbsent + "',DEFAULT,DEFAULT);", true);
            }
        }catch(SQLException e){e.printStackTrace();}
    }
    
    private void sendCuttingClassWarning(String studentid) {
        try {
            ResultSet rs = DB.query("SELECT attend FROM attendance a JOIN class USING(classid) "
                    + "JOIN section USING(sectionid) JOIN enroll USING(sectionid) JOIN student ON(a.studentid=lrn) "
                    + "WHERE day = DATE('" + txtDate.getText() + "') AND lrn='" + studentid + "' ORDER BY timein;");
            ArrayList<Integer> ats = new ArrayList<>();
            while (rs.next()) {
                ats.add(rs.getInt(1));
//                System.out.print(ats.get(ats.size() - 1));
            }
//            System.out.println();
//            System.out.println("dayattendance:" + getDayAttendance(ats));
            if (getDayAttendance(ats) == 3) {
                DB.query("INSERT INTO send VALUES(DEFAULT," + studentid + ",'" + messageCutting + "',DEFAULT,DEFAULT);", true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getDayAttendance(ArrayList<Integer> ats) {
        boolean canLate = false;
        boolean late = false;
        boolean attended = false;
        boolean cutting = false;

        int ret = 0;
        //0 Present
        //1 Absent
        //2 Late
        //3 Cutting

        for (int i = 0; i < ats.size(); i++) {
            if (ats.get(i) == 0) {
                if (!attended) {
                    attended = true;
                }
                if (canLate) {
                    late = true;
                    ret = 2;
                }
            } else if (ats.get(i) == 1) {
                if (!attended) {
                    canLate = true;

                }
                if (attended) {
                    ret = 3;
                    break;
                }
            }
        }

        if (!attended) {
            ret = 1;
        }

        return ret;
    }

    private void sendWarnings() {
        
        for (int i = 0; i < students.size(); i++) {
            String ss = this.students.get(tblStudensAttendance.getValueAt(i, 0).toString());
            System.out.println("ss:" + ss + " size:" + students.size());
            
            sendCuttingClassWarning(ss);
            sendAbsentWarning(ss);
            
        }
        
        
    }

    private void hideNonAdminComponents() {
        btnEnroll.setVisible(false);
        btnStudent.setVisible(false);
        btnTeacher.setVisible(false);
        btnClass.setVisible(false);
        btnSection.setVisible(false);
    }
    
    
    private void showSummaryAttendance(){
        ShowAllAttendance saa = new ShowAllAttendance();
        saa.setLocationRelativeTo(null);
        saa.setVisible(true);
    }
}
