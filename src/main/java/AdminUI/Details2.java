/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminUI;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class Details2 extends javax.swing.JPanel {

    /**
     * Creates new form DepartmentDetails
     */
    StudentDirectory studentdata;
    Department department;
    FacultyProfile fp;
    StudentProfile studentdetails;

    public Details2(Department d) {
        initComponents();
        this.department = d;

        if (d != null) {
            populateTable(this.department.getStudentDirectory().getStudentlist());
        }
        lblcoursesfeedback.setVisible(false);
        lblcoursestaken.setVisible(false);
        feedbackCoursePane.setVisible(false);
        courseTakenScrollPane.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        lblcoursestaken = new javax.swing.JLabel();
        lblcoursesfeedback = new javax.swing.JLabel();
        feedbackCoursePane = new javax.swing.JScrollPane();
        txtFeedbackCourses = new javax.swing.JTextArea();
        courseTakenScrollPane = new javax.swing.JScrollPane();
        txtCoursesopted = new javax.swing.JTextArea();

        lblTitle.setBackground(new java.awt.Color(204, 0, 51));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Overview Faculty Details");
        lblTitle.setOpaque(true);

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));

        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Faculty ID", "Faculty Name", "Courses"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDepartment);

        lblcoursestaken.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcoursestaken.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblcoursestaken.setText("Courses Opted :");

        lblcoursesfeedback.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblcoursesfeedback.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblcoursesfeedback.setText("Courses Feedback");

        txtFeedbackCourses.setEditable(false);
        txtFeedbackCourses.setColumns(20);
        txtFeedbackCourses.setRows(5);
        feedbackCoursePane.setViewportView(txtFeedbackCourses);

        txtCoursesopted.setEditable(false);
        txtCoursesopted.setColumns(20);
        txtCoursesopted.setRows(5);
        courseTakenScrollPane.setViewportView(txtCoursesopted);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(89, 89, 89))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcoursestaken)
                    .addComponent(lblcoursesfeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feedbackCoursePane, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseTakenScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblcoursestaken, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(courseTakenScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblcoursesfeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(feedbackCoursePane, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane courseTakenScrollPane;
    private javax.swing.JScrollPane feedbackCoursePane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcoursesfeedback;
    private javax.swing.JLabel lblcoursestaken;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTextArea txtCoursesopted;
    private javax.swing.JTextArea txtFeedbackCourses;
    // End of variables declaration//GEN-END:variables

    private void populateTable(List<StudentProfile> list) {
        DefaultTableModel model = (DefaultTableModel) tblDepartment.getModel();
        
        model.setRowCount(0);
        for (StudentProfile co : list) {

            Object[] row = new Object[6];
            row[0] = co;
            row[1] = co.getPerson().getName();
            for(CourseOffer c:co.getCoursesTaken()){
            row[2] = c.getCourseName();
            }
            
            Employment emp = co.getEmploymenthistory().getEmployments().get(co.getEmploymenthistory().getEmployments().size() - 1);
            row[3] = emp.getEmployer().getName();
            row[4] = emp.getSalary();
            row[5] = emp.getJobposition();
            model.addRow(row);
        }
    }
}
