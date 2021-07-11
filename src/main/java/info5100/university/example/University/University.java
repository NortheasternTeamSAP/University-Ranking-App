/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.University;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author preet
 */




import info5100.university.example.College.College;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class University {

    ArrayList<College> colleges = new ArrayList<>();

    public University(ArrayList<College> colleges) {
        this.colleges = colleges;
    }

    public float getCollegeRevenue() {
        float revenue = 0;

        for (College c : colleges) {
            revenue += c.getCollegeRevenue();

        } return revenue;
    }
    
     public double PercentageofStudentsAboveAverageSalaryinUniversity() {
        double percent = 0;
        
        for (College c : colleges) {
        for (Department d : c.getDepartment()) {
     List<StudentProfile> salarylist = d.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getSalary() >= 120000).collect(Collectors.toCollection(ArrayList::new));
      percent=  ((double) salarylist.size() / (double) d.getStudentDirectory().getStudentlist().size()) * 100;

} 
    }return percent;
     }
     
      public Set<String> getCollegeByMostSalaryPaid() {
        Set<String> namelist= new HashSet<>();
    
for (College c : colleges) {
      
namelist=c.getDeaprtmentByMostSalaryPaid();
     
}
    return namelist;
}
   
    public double percentOfStudentsInTop5RankingofUniversity() {
         double percent = 0;
       for (College c : colleges) {
        for (Department d : c.getDepartment()) {
        List<StudentProfile> percentlist  = d.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) percentlist .size() / (double) d.getStudentDirectory().getStudentlist().size()) * 100;
    } 
       }return percent;
    }   
     
     
     
     
}