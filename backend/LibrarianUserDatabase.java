/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;



/**
 *
 * @author LENOVO
 */
class LibrarianUserDatabase extends Database{
    
    public LibrarianUserDatabase (String filename){
        setFilename(filename);
    }
     
    @Override
    public LibrarianUser createRecordFrom(String line){
        String [] LibrarianDataAsString = line.split(",");
        LibrarianUser Librarian = new LibrarianUser(LibrarianDataAsString[0],LibrarianDataAsString[1],
                        LibrarianDataAsString[2],LibrarianDataAsString[3],LibrarianDataAsString[4]);
        return Librarian;
    }
}
