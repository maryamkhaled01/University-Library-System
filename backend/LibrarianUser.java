/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author LENOVO
 */
public class LibrarianUser implements Record{
     private String librarianId, name, email, address, phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
     @Override
    public String lineRepresentation(){
        return librarianId+","+name+","+email+","+address+","+phoneNumber;
    }
    
     @Override
    public String getSearchKey(){
        return librarianId;
    }

    public void addRow(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
