/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class StudentBook implements Record {
    private String studentId, bookId;
    private LocalDate borrowDate;
    
    public StudentBook(String studentId, String bookId, LocalDate borrowDate){
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }
    
    public String getStudentId(){
        return studentId;
    }
    
    public String getBookId(){
        return bookId;
    }
    
    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    
    @Override
    public String lineRepresentation(){
        return studentId+","+bookId+","+borrowDate;
    }
    
    @Override
    public String getSearchKey(){
        return studentId+","+bookId;
    }
}
