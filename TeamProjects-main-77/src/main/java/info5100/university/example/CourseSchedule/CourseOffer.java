/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassign;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassign = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassign.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(); //seat is already linked to course offer
        cl.registerStudent(sa);; //coures offer seat is now linked to student
        return sa;
    }
    public boolean isPopular(){
        int occupiedSeats = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                occupiedSeats +=1;
            }
        }
        if((occupiedSeats/seatlist.size())*100>=90){
            return true;
        }
        return false;
        
    }
    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
   public String getCourseName() {
        return course.getName();
    }

    public Course getCourse() {
        return course;
    }
    
      public void setTeacherRating(int rating) {

        facultyassign.setRating(rating);
    }

    public ArrayList<Integer> getTeacherRating() {

        return facultyassign.getRating();
    }
    
    
         public void setCourseRating(int rating) {

        course.setRating(rating);
    }

    public ArrayList<Integer> getCourseRating() {

        return course.getRating();
    }
    
    
    
}
