/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author phatn
 */

@Entity
public class User implements Serializable {
    
    @Id
    private String email;
    private String lastName;
    private String firstName;
    
    public User(String firstName, String lastName, String email){
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public User(){
        this.email = "";
        this.lastName = "";
        this.firstName="";
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setLastName(String last){
        this.lastName = last;
    }
    
    public void setFirstName(String first){
        this.firstName = first;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
}
