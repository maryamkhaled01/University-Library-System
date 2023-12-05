/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author LENOVO
 */
 class BookDatabase extends Database {
    
    public BookDatabase (String filename){
        setFilename(filename);
    }
    
    @Override
    public Book createRecordFrom(String line){
        String [] bookDataAsString = line.split(",");
        Book book = new Book(bookDataAsString[0],bookDataAsString[1],
                        bookDataAsString[2],bookDataAsString[3],
                        Integer.parseInt(bookDataAsString[4]));
        return book;
    }
}
