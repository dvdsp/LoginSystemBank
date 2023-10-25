/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import common.Validate;
import java.util.Locale;
import view.Menu;

/**
 *
 * @author DELL
 */
public class LoginSystemManager extends Menu<String> {
    static String[] mc = {"Vietnamese", "English", "exit"};
    protected Library library;
    protected Validate valid;
    Locale vietnamese;
    Locale english = Locale.US;
    public LoginSystemManager(){
        super("\nLOGIN FUNCTION OF EBANK SYSTEM", mc);
        library = new Library();
        valid = new Validate();
        vietnamese = new Locale("vi");
        
    }

    @Override
    public void execute(int n) {      
        switch(n) {
            case 1-> library.login(vietnamese);
            case 2-> library.login(english);
            case 3-> System.exit(0);
        }
    }
    

    
    
    
    
    
    
    
}
