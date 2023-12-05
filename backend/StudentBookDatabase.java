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
class StudentBookDatabase extends Database {
    
    public StudentBookDatabase (String filename){
        setFilename(filename);
    }
    
    @Override
    public StudentBook createRecordFrom(String line){
        String [] studentBookDataAsString = line.split(",");
        StudentBook book = new StudentBook(studentBookDataAsString[0],studentBookDataAsString[1],
                        LocalDate.parse(studentBookDataAsString[2]));
        return book;
    }
}
