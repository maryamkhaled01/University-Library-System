/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import constants.FileNames;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
abstract class Database implements FileNames {
    private ArrayList<Record> records;
    private String filename;
    
    public void setFilename(String filename){
        this.filename = filename;
    }
    
    public void readFromFile() throws FileNotFoundException{
        if(records == null)
           records = new ArrayList<>();
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                records.add(createRecordFrom(line));
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred while openning the file.");
        }
    }
    
    abstract public Record createRecordFrom(String line);
     
    public ArrayList<Record> returnAllRecords(){
        return records;
    }
     
    public boolean contains(String key){
        for(int i=0; i<records.size(); i++){
            if(records.get(i).getSearchKey().equalsIgnoreCase(key))
                return true;
        }
        return false;
    }
    
    public Record getRecord(String key){
        int i;
        for(i=0; i<records.size(); i++)
            if(records.get(i).getSearchKey().equalsIgnoreCase(key))
                break;
        return records.get(i);
    }
    
    public void insertRecord(Record record){
        if(records == null)
            records = new ArrayList<>();
        boolean flag = true;
        for(int i=0; i<records.size(); i++)
            if(records.get(i).getSearchKey().equalsIgnoreCase(record.getSearchKey())){
                flag = false;
                break;
            } 
        if(flag)
            records.add(record);
        //System.out.println(record.lineRepresentation());
    }
    
    public void deleteRecord(String key){
        for(int i=0; i<records.size(); i++)
            if(records.get(i).getSearchKey().equalsIgnoreCase(key)){
                records.remove(i);
                break;
            }
    }
    
    public void saveToFile() throws FileNotFoundException{
        File file = new File(filename);
        PrintWriter pw = new PrintWriter(file);
        for(int i=0; i<records.size(); i++)
            pw.println(records.get(i).lineRepresentation());
        pw.close();
    }
}
