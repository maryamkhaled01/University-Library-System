/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import constants.FileNames;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 *
 * @author LENOVO
 */
public class LibrarianRole implements FileNames{
    private BookDatabase booksDatabase = new BookDatabase(BOOKS_FILENAME);;
    private StudentBookDatabase sBDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
    
    public LibrarianRole() throws FileNotFoundException{
       booksDatabase.readFromFile();
       sBDatabase.readFromFile();
    }
    
    public void addBook(String id, String title, String authorName, String publisherName, int quantity){
        Book book = new Book(id,title,authorName,publisherName,quantity);
        booksDatabase.insertRecord(book);
    }
    
    public Book[] getListOfBooks(){
        return booksDatabase.returnAllRecords().toArray(new Book[booksDatabase.returnAllRecords().size()]);
    }
    
    public StudentBook[] getListOfBorrowingOperations(){
        return sBDatabase.returnAllRecords().toArray(new StudentBook[sBDatabase.returnAllRecords().size()]);
    }
    
    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) throws FileNotFoundException{
        StudentBook record = new StudentBook(studentId,bookId,borrowDate);
        Book book = (Book) booksDatabase.getRecord(bookId);
        if(sBDatabase.contains(studentId+","+bookId))
            return 1;
        else if (book.getQuantity() == 0)
            return 0;
        else {
            int n = book.getQuantity();
            n--;
            book.setQuantity(n);
            sBDatabase.insertRecord(record);
            return 2;
        }
    }
    
    public double returnBook(String studentId, String bookId, LocalDate returnDate) throws FileNotFoundException{
        Book book = (Book) booksDatabase.getRecord(bookId);
        int n = book.getQuantity();
        n++;
        book.setQuantity(n);
        StudentBook sBook = (StudentBook) sBDatabase.getRecord(studentId+","+bookId);
        LocalDate borrowDate = sBook.getBorrowDate();
        long differenceInDays = ChronoUnit.DAYS.between((Temporal) borrowDate, returnDate);
        sBDatabase.deleteRecord(studentId+","+bookId);
        if(differenceInDays < 7)
            return 0;
        else
            return (differenceInDays - 7)*0.5;
    }
    
    public void logout() throws  FileNotFoundException{
        sBDatabase.saveToFile();
        booksDatabase.saveToFile();
    }
}
