/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmploymentHistroy {
    
    ArrayList<Employment> employments;
    int promotion =0;

    public ArrayList<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(ArrayList<Employment> employments) {
        this.employments = employments;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
    
    
    public EmploymentHistroy(){
        employments = new ArrayList();
    }
    
    
    public Employment newEmployment(Employment e) {

        if (employments.size() > 0) {
            Employment last = employments.get(employments.size() - 1);
            if (!last.getJobposition().equalsIgnoreCase(e.getJobposition())) {
                promotion++;
            }
        }
        employments.add(e);

        return e;
    }
    
}
