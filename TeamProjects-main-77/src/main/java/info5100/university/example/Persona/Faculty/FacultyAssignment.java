/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    
    CourseOffer courseoffer;
    FacultyProfile facultyprofile;
     ArrayList<Integer> Rating= new ArrayList<>();
    
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }
    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
         public void setRating(int rating) {

        Rating.add(rating);
        Collections.sort(Rating, Collections.reverseOrder());

    }

    public CourseOffer getCourseoffer() {
        return courseoffer;
    }

    public FacultyProfile getFacultyprofile() {
        return facultyprofile;
    }

    public ArrayList<Integer> getRating() {

        return Rating;
    }
 
}
