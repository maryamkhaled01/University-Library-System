/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import constants.FileNames;
import java.io.FileNotFoundException;

/**
 *
 * @author LENOVO
 */
public class AdminRole implements FileNames{
    private LibrarianUserDatabase database;
    
    public AdminRole() throws FileNotFoundException{
        database = new LibrarianUserDatabase(LIBRARIANS_FILENAME);
        database.readFromFile();
    }
    
    public void addLibrarian(String librarianId, String name, String email,String address, String phoneNumber){
        LibrarianUser librarian = new LibrarianUser(librarianId,name,email,address,phoneNumber);
        database.insertRecord(librarian);
        //System.out.println(librarian.lineRepresentation());
    }
    
    public LibrarianUser[] getListOfLibrarians(){
        return database.returnAllRecords().toArray(new LibrarianUser[database.returnAllRecords().size()]);
    }
    
    public void removeLibrarian(String key){
        database.deleteRecord(key);
    }
    
    public void logout() throws FileNotFoundException{
        database.saveToFile();
    }
}
