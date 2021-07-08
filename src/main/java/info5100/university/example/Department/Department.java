/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    //EmployerDirectory employerdirectory;

    HashMap<String, CourseSchedule> mastercoursecatalog;
     ArrayList<Integer> Rating= new ArrayList<>();

    public String getName() {
        return name;
    }

    public CourseCatalog getCoursecatalog() {
        return coursecatalog;
    }

    @Override
    public String toString() {
        return "" + name + '}';
    }

    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public HashMap<String, CourseSchedule> getMastercoursecatalog() {
        return mastercoursecatalog;
    }
    
 public Set<String> getPopularCoursesByJobPromotion() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getPromotion() >= 2).collect(Collectors.toCollection(ArrayList::new));
        List<CourseOffer> courselist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Employment> emp = list.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(emp.get(emp.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namesList = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namesList;
    }
public Set<String> getPopularCoursesByOrganizationRanking() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 3).collect(Collectors.toCollection(ArrayList::new));
        List<CourseOffer> courselist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Employment> emp = list.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(emp.get(emp.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namesList = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namesList;
    }

 public double percentageOfStudentsBasedonGrade() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getStudentGPA()>= 3.5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    public double percentageOfStudentsBasedonJobPromotions() {
        List<StudentProfile> list = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getPromotion() >= 2).collect(Collectors.toCollection(ArrayList::new));
        return ((double) list.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }
    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory=new FacultyDirectory(this);
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }
    
     public List<CourseOffer> getMostPopuplarCourses(String semester) {
        List<CourseOffer> popularlist = new ArrayList<>();
        CourseSchedule co = mastercoursecatalog.get(semester);
        popularlist.addAll(co.getMostPopularCourses());
        return popularlist;
    }


    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }
    
 public double percentageStudentsAbvAverageSalary() {
        List<StudentProfile> salarylist = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getSalary() >= 120000).collect(Collectors.toCollection(ArrayList::new));
        return ((double) salarylist.size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }
 
 
    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr,int p) {

        Course c = coursecatalog.newCourse(n, nm, cr,p);
        return c;
    }
 public int totalDepartmentRevenue(){

        int revenue=0;
        for(CourseSchedule cs : mastercoursecatalog.values()){

            revenue+= cs.calculateTotalRevenues();
        }return revenue;
 }
        
        public ArrayList<StudentProfile> CompareByGPA(ArrayList<StudentProfile> list) {
        Collections.sort(list,
                (o1, o2) -> Float.compare(o2.getStudentGPA(), o1.getStudentGPA())
        );
        return list;
    }
        
        
   
    
  
     
 public double percentOfStudentsInTop5RankingInDepartment() {
        List<StudentProfile> percentlist  = this.getStudentDirectory().getStudentlist().stream().filter(p -> p.getEmploymenthistory().getEmployments().get(p.getEmploymenthistory().getEmployments().size() - 1).getEmployer().getRanking() <= 5).collect(Collectors.toCollection(ArrayList::new));
        return ((double) percentlist .size() / (double) this.getStudentDirectory().getStudentlist().size()) * 100;
    }

    
        public Set<String> getCoursesByMostSalaryPaidinDepartment() {
        List<StudentProfile> slist = this.getStudentDirectory().getStudentlist();
        Collections.sort(slist,
                (o1, o2)
                -> new Double(o2.getEmploymenthistory().getEmployments().get(o2.getEmploymenthistory().getEmployments().size() - 1).getSalary()).compareTo(o1.getEmploymenthistory().getEmployments().get(o1.getEmploymenthistory().getEmployments().size() - 1).getSalary())
        );

         List<CourseOffer> courselist = new ArrayList<>();
        //  maxium 3 salaries
        for (int i = 0; i <= 2; i++) {
            List<Employment> employments = slist.get(i).getEmploymenthistory().getEmployments();
            courselist.addAll(employments.get(employments.size() - 1).getRelevantcourseoffers());
        }
        Set<String> namelist = courselist.stream()
                .map(CourseOffer::getCourseName)
                .collect(Collectors.toSet());
        return namelist;
    }
        
    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }
    
  
     
    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
    
  
        public void setRating(int rating) {

        Rating.add(rating);
        Collections.sort(Rating, Collections.reverseOrder());

    }

    public ArrayList<Integer> getRating() {

        return Rating;
    }
    
    
    
    
    
    
}
