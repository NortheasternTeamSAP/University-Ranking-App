/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistory;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    EmploymentHistory employmenthistory;
     private Icon logoImage;
    

    public StudentProfile(Person p ,Icon logoImage) {
        this.logoImage = logoImage;
        person = p;
        transcript = new Transcript();
        employmenthistory = new EmploymentHistory();
    }

    public Icon getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(Icon logoImage) {
        this.logoImage = logoImage;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }
 public List<CourseOffer> getCoursesTaken() {

        return transcript.getCourses();
    }
    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }
     
    public float getStudentGPA() {
        if (transcript == null) {
            return 0;
        }
        return transcript.calculateGPA();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public EmploymentHistory getEmploymenthistory() {
        return employmenthistory;
    }

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }
    
      @Override
    public String toString() {
        return this.person.getPersonId();
    }
}
