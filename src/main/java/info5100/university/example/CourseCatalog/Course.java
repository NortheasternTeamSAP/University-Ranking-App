/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kal bugrara
 */
public class Course {
    String number;
    String name;
    int credits;
    int price ; //per credit hour
    ArrayList<Integer> Rating= new ArrayList<>();

    @Override
    public String toString() {
        return "" + name ;
    }
    
    
    public void setRating(int rating) {

 

        Rating.add(rating);
        Collections.sort(Rating, Collections.reverseOrder());

 

    }

 

    public ArrayList<Integer> getRating() {

 

        return Rating;
    }
    
    
    public Course(String n, String numb, int ch,int p){
        name = n;
        number = numb;
        credits = ch;
        price=p;
        
        
    }
    public String getCOurseNumber(){
        return number;
    }
    
    public int getCoursePrice(){
        return price*credits;
        
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
