/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fakerPackage;

import com.github.javafaker.Faker;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Employer.EmployerProfile;
import info5100.university.example.Persona.EmploymentHistory.Employment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistory;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sravy
 */
public class DataStore {
    private final Random random;
    public static DataStore dataInstance;
    
    
    public static DataStore getDataInstance(){
        if(dataInstance == null){
           dataInstance = new DataStore();
        }
        return dataInstance;
    }
    
    public DataStore(){
    random = new Random();
    
    }
    
    public Department generateDepartmentData(){
        Faker faker = new Faker();
        
        Department department = new Department("INFO");
        
        float leftLimit = 3.0F;
        float rightLimit = 4F;
        
        //creating courses
        for(int i = 1; i <= 10; i++){
            department.newCourse(department.getName() + "-" + i, Integer.toString(i), i, i); //check parameters
        }
        
        //Creating employers
        
        EmployerDirectory empDirec = new EmployerDirectory(department);
        for(int i = 0; i <= 10; i++){
            int num = random.nextInt(10);
            if(num == 0){
                num = 1;
            }
            empDirec.newEmployerProfile(faker.company().name(), num);
             
        }
        
        CourseSchedule fallCoursesSchedule = department.newCourseSchedule("Fall 2021");
        
        //creating courses offered for 2021
        
        for(int i = 1; i <= 10; i++){
            CourseOffer courseOffer = fallCoursesSchedule.newCourseOffer(Integer.toString(i));
            courseOffer.generatSeats(30);
        }
        
        //Creating student data with courses and registration of courses
        
        for(int j = 0; j <= 30; j++){
            PersonDirectory personDirec = department.getPersonDirectory();
            Person person = personDirec.newPerson(Integer.toString(j + 1), faker.name().fullName());
            StudentDirectory studentDirec = department.getStudentDirectory();
            StudentProfile studentProfile = studentDirec.newStudentProfile(person); 
            CourseLoad courseLoad = studentProfile.newCourseLoad("Fall 2021");
            
            ArrayList<CourseOffer> courseList = fallCoursesSchedule.getSchedule(); //check later
            Collections.shuffle(courseList);
            
            for(int i = 1; i <= 8; i++){
                SeatAssignment seatAssignment = courseLoad.newSeatAssignment(courseList.get(i), leftLimit + random.nextFloat() * (rightLimit - leftLimit));
               
            }
            
        }
        
         for(int j = 0; j <= 30; j++){
             
             PersonDirectory personDirec = department.getPersonDirectory();
             Person person = personDirec.newPerson(Integer.toString(j + 1), faker.name().fullName());
            FacultyDirectory facultydirec = department.getFacultydirectory();
             FacultyProfile facultyprofile = facultydirec.newFacultyProfile(person); 
                    
            ArrayList<CourseOffer> courseList = fallCoursesSchedule.getSchedule(); //check later
            Collections.shuffle(courseList);
            
            for(int i = 1; i <= 8; i++){
                
                for(CourseOffer c: courseList){
           c.AssignAsTeacher(facultyprofile);
                }
            }
            
        }
        
        //creating Employement details of student
        for(StudentProfile studentProfile: department.getStudentDirectory().getStudentlist()){
            EmploymentHistory empHistory = new EmploymentHistory();
            List<CourseOffer> courseOfferList = studentProfile.getCourseLoadBySemester("Fall 2021").getListOfCoursesForCourseLoad();
            Collections.shuffle(courseOfferList);
            ArrayList<CourseOffer> list1 = new ArrayList();
            list1.add(courseOfferList.get(0));
            list1.add(courseOfferList.get(courseOfferList.size() - 1));
            int num = random.nextInt(3);
            List<EmployerProfile> list2 = empDirec.getEmployerlist();
            Collections.shuffle(list2);
            double salary = ThreadLocalRandom.current().nextDouble(90000, 120000);
            if(num == 0){
                num += 1;
                
            }
            if(studentProfile.getStudentGPA() > 3.5){
                salary = 130000;
            }
            for(int i = 1; i <= num + 1; i++){
                Employment employment = new Employment(list1, faker.job().position(), salary, list2.get(i));
                empHistory.newEmployment(employment);
                salary = salary + (0.50 * salary);
            }
            
            studentProfile.setEmploymenthistory(empHistory);
        }
            
            department.getStudentDirectory().getStudentlist().sort((o1,o2) -> Integer.parseInt(o1.getPerson().getPersonId()) - Integer.parseInt(o2.getPerson().getPersonId()));
            return department;
        
    }    
}
 
    

