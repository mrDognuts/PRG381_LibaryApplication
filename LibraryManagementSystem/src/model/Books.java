/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author walte
 */
public abstract class Books {
    //fields
    protected String bookID,title,author,publisher,genre;
    
    //constructor
    public Books(String bookID,String title, String author, String publisher, String genre){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;  
    }
    @Override
    public String toString(){
        return "BookID: "+this.bookID+"\nTitle: "+this.title+"\nAuthor: "+this.author+"\nPublisher: "+this.publisher+"\nGenre: "+this.genre;
    }
}
