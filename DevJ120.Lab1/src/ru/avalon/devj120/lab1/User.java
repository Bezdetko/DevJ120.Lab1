/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.avalon.devj120.lab1;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alebezd
 */
public class User {
    
    private int id;
    private String name;
    private boolean isAdmin;
    
    static ArrayList<User> users = new ArrayList<User>();

    public User() {
    }

    public User(int id, String name, boolean isAdmin) throws UserException{
        setId(id);
        setName(name);
        setIsAdmin(isAdmin);
        users.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws UserException {
        if (users.isEmpty()) this.id = id;
        for (User n: users){
            if (id!=n.id){
                this.id = id;}
            else throw new UserException("Не уникальный id");
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if(name == null || name.trim().equals("")) 
            throw new UserException("Пустое имя пользователя");
        this.name = name;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        if ( name != null & !name.trim().equals("")){
        User cloneUser=null;   
        try {
            cloneUser = new User( new Random().nextInt(999), this.name, this.isAdmin);
        } catch (UserException ex) {
            System.out.println(ex.getMessage());
        }
        return cloneUser;
        }
        else throw new CloneNotSupportedException("User не подлежит клонированию");
      
    }
    
    @Override
    public boolean equals(Object obj){
        User user;
        if (obj instanceof User){
            user = (User) obj;
        } else return false;
        
        if (user.isIsAdmin()==this.isIsAdmin() && user.getName()==this.getName())
            return true;
        else 
            return false;
        
    }
            
            
//    public static void printALL(){
//        System.out.println(users.toString());
//    }
    
    public static void printALL(){
     for (User n: users){
            System.out.println(n.toString());
        }
     }
    
    @Override
    public String toString(){
      return  "id: " + getId() + "; name: " + getName() + "; is admin: " + isIsAdmin() + "; hashCode: " +  hashCode();
      
        
    }

    @Override
    public int hashCode() {
        
        return getName().hashCode() * (isIsAdmin() ? 3 : 5);
    }
}