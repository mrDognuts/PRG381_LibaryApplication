/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author walte
 */
public abstract class Borrowers {
    
        //fields
    protected String borrowersID,name,surname,phone,email,address;
    
    //constructor
    public Borrowers(String borrowersID,String name, String surname, String phone, String email,String address){
        this.borrowersID = borrowersID;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;  
        this.address = address;
    }
    @Override
    public String toString(){
        return "BorrowersID: "+this.borrowersID+"\nFullname: "+this.name+this.surname+"\nPhone: "+this.phone+"\nEmail: "+this.email+"\nAddress: "+this.address;
    }
}
