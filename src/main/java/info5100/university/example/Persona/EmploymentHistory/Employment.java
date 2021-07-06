/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Employer.EmployerProfile;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author kal bugrara
 */
public class Employment {
    ArrayList<CourseOffer> relevantcourseoffers;
    int weight;
    String quality;
    String job;
    double salary;
    String jobposition;
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    public Employment(String j){
        
        ArrayList relevantcourseoffers = new ArrayList();
        
    }
    
     public Employment(ArrayList<CourseOffer> relevantcourseoffers, String position, double salary, EmployerProfile employer) {
        this.relevantcourseoffers = relevantcourseoffers;
        //this.quality = quality;
        this.jobposition = position;
        this.salary = salary;
        this.employer = employer;
    }

    public ArrayList<CourseOffer> getRelevantcourseoffers() {
        return relevantcourseoffers;
    }

    public void setRelevantcourseoffers(ArrayList<CourseOffer> relevantcourseoffers) {
        this.relevantcourseoffers = relevantcourseoffers;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobposition() {
        return jobposition;
    }

    public void setJobposition(String jobposition) {
        this.jobposition = jobposition;
    }

    public Employment getNextemplyment() {
        return nextemplyment;
    }

    public void setNextemplyment(Employment nextemplyment) {
        this.nextemplyment = nextemplyment;
    }

    public EmployerProfile getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerProfile employer) {
        this.employer = employer;
    }

   public String getRelevantCourses(){
        if(this.relevantcourseoffers.size()>0){
            return relevantcourseoffers.stream().map(CourseOffer :: getCourseName).collect(Collectors.toList()).toString();
        }
        return "";
    }
}
