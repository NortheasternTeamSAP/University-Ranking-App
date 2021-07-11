/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

/**
 *
 * @author preet
 */




import info5100.university.example.Department.Department;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class College {


    ArrayList<Department> department = new ArrayList<>();
     ArrayList<Integer> Rating= new ArrayList<>();

    public College(ArrayList<Department> department) {
        this.department = department;
       
    }

    public float getCollegeRevenue() {
        float revenue = 0;

        for (Department d : department) {
            revenue += d.totalDepartmentRevenue();

        } return revenue;
    }

    public ArrayList<Department> getDepartment() {
        return department;
    }
    
    public double PercentageofStudentsAboveAverageSalaryinCollege() {
        double percent = 0;
        for (Department d : department) {
     List<StudentProfile> salarylist = d.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getSalary() >= 120000).collect(Collectors.toCollection(ArrayList::new));
      percent=  ((double) salarylist.size() / (double) d.getStudentDirectory().getStudentlist().size()) * 100;

} return percent;
    }
    
    
     public double percentOfStudentsInTop5RankingofCollege() {
         double percent = 0;
        for (Department d : department) {
        List<StudentProfile> percentlist  = d.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) percentlist .size() / (double) d.getStudentDirectory().getStudentlist().size()) * 100;
    } return percent;
    }
    
    
    
    public Set<String> getDeaprtmentByMostSalaryPaid() {
        Set<String> namelist= new HashSet<>();
    
    for (Department d : department) {
   namelist = d.getCoursesByMostSalaryPaidinDepartment();
     }
    
    return namelist;
}
        public void setRating(int rating) {

        Rating.add(rating);
        Collections.sort(Rating, Collections.reverseOrder());

    }

    public ArrayList<Integer> getRating() {

        return Rating;
    }
    
    
    
}